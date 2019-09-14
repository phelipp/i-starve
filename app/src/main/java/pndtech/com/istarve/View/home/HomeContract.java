package pndtech.com.istarve.View.home;

import androidx.recyclerview.widget.RecyclerView;

import pndtech.com.istarve.Util.adapter.AdapterCardBanners;

interface HomeContract {
    interface View {
        void setInstanceRecycleView(RecyclerView recyclerView);
        void setAdapter(AdapterCardBanners adapter);
    }

    interface Presenter {
        void getInstanceRecyclerView(android.view.View view);
        void updateProdutos();
    }
}
