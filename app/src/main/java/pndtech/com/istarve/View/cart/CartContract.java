package pndtech.com.istarve.View.cart;

import androidx.recyclerview.widget.RecyclerView;

import pndtech.com.istarve.Util.adapter.AdapterCardCarrinho;

interface CartContract {
    interface View {
        void setAdapter(AdapterCardCarrinho adapter);
        void setInstanceRecycleView(RecyclerView recyclerView);

    }

    interface Presenter {
        void getInstanceRecyclerView(android.view.View view);
        void updateProdutos();
    }
}
