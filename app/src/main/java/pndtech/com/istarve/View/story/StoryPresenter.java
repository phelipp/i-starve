package pndtech.com.istarve.View.story;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.Produto;
import pndtech.com.istarve.R;
import pndtech.com.istarve.Util.adapter.AdapterCardLoja;

class StoryPresenter implements StoryContract.Presenter {
    private StoryContract.View contractView;
    private Context context;
    private static List<Produto> produtos;
    private static AdapterCardLoja cardLoja;

    StoryPresenter(Context context, StoryContract.View contractView) {

        this.contractView = contractView;
        this.context = context;
        this.produtos = new ArrayList<>();
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
        produtos = getDataProdutos();
        if (cardLoja == null) {
            cardLoja = new AdapterCardLoja(produtos, context);
        } else if (!cardLoja.getProdutos().equals(produtos)) {
            cardLoja.setProdutos(produtos);
        }
        contractView.setAdapter(cardLoja);
    }

    public List<Produto> getDataProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg", "Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        produtos.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg", "Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        produtos.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg", "Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        produtos.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg", "Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        produtos.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg", "Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));
        produtos.add(new Produto(0, "H1", 10, "http://hd.wallpaperswide.com/thumbs/fast_food_burger-t2.jpg", "Duas Carnes e salada aaaa aaa aaa aa aa aa aa aa aaaaaasss sss ssss sss sssss "));


        return produtos;
    }


}
