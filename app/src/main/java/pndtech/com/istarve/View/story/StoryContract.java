package pndtech.com.istarve.View.story;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pndtech.com.istarve.R;
import pndtech.com.istarve.Util.adapter.AdapterCardLoja;

interface StoryContract{
    interface View{
        void setAdapter(AdapterCardLoja adapter);
        void setInstanceRecycleView(RecyclerView recyclerView);
    }

    interface Presenter {
        void getInstanceRecyclerView(android.view.View view);
        public void updateProdutos();
    }
}
