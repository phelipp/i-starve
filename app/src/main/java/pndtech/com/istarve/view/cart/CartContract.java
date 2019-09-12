package pndtech.com.istarve.view.cart;

import androidx.recyclerview.widget.RecyclerView;

import pndtech.com.istarve.Util.adapter.AdapterCardCarrinho;
import pndtech.com.istarve.Util.adapter.AdapterCardLoja;

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
