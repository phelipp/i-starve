package pndtech.com.istarve.Util.data;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.produto.Produto;

public class DaoProduto {
    public final static String NODE = "Produto";
    public final static String COL_NAME = "name";
    public final static String COL_VALUE = "value";
    public final static String COL_URL_IMAGE = "imageUrl";


    public void save(Produto objeto) {
        Dao.getInstance().getDatabaseReference()
                .child(NODE)
                .child(String.valueOf(objeto.getId()))
                .setValue(objeto);
    }


    public List<Produto> select() {
        final List<Produto> produtos = new ArrayList<>();
        Dao.getInstance().getDatabaseReference()
                .child(NODE).
                addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            Produto produto = new Produto(Integer.valueOf(data.getKey()));
                            produto.setName(data.child(COL_NAME).getValue().toString());
                            produto.setValue(data.child(COL_VALUE).getValue().toString());
                            produto.setImageUrl(data.child(COL_URL_IMAGE).getValue().toString());
                            produtos.add(produto);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        return (produtos.size() > 0) ? produtos : null;
    }


    public Produto select(final int id) {

        final Produto produto = new Produto(id);
        Dao.getInstance().getDatabaseReference()
                .child(NODE)
                .child(String.valueOf(id))
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        produto.setName(dataSnapshot.child(COL_NAME).getValue().toString());
                        produto.setValue(dataSnapshot.child(COL_VALUE).getValue().toString());
                        produto.setImageUrl(dataSnapshot.child(COL_URL_IMAGE).getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
        return (produto.getName().isEmpty()) ? null : produto;

    }
}
