package pndtech.com.istarve.view.home;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

interface HomeContract {
    interface View {
       void setInstanceRecycleView(RecyclerView recyclerView);
    }

    interface Presenter {
        void getInstanceRecyclerView(android.view.View view);
    }
}
