package pndtech.com.istarve.View.cart;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.produto.Item;
import pndtech.com.istarve.R;
import pndtech.com.istarve.Util.adapter.AdapterCardCarrinho;


class CartPresenter implements CartContract.Presenter {
    private CartContract.View contractView;
    private Context context;
    private static List<Item> itens;
    private static AdapterCardCarrinho cardCarrinho;

    CartPresenter(Context context, CartContract.View contractView) {
        this.contractView = contractView;
        this.context = context;

    }


    @Override
    public void getInstanceRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        contractView.setInstanceRecycleView(recyclerView);
    }

    @Override
    public void updateProdutos() {
        itens = getDataProdutos();
        if (cardCarrinho == null) {
            cardCarrinho = new AdapterCardCarrinho(itens, context);
        } else if (!cardCarrinho.getItens().equals(itens)) {
            cardCarrinho.setItens(itens);
        }
        contractView.setAdapter(cardCarrinho);
    }

    public List<Item> getDataProdutos() {
        List<Item> itens = new ArrayList<>();
       /* itens.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg","Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        itens.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg","Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        itens.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg","Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        itens.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg","Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        itens.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg","Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        itens.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg","Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        */

        return itens;
    }


}
