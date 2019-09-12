package pndtech.com.istarve.view.home;

import android.content.Context;
import android.view.View;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pndtech.com.istarve.R;

public class HomePresenter implements HomeContract.Presenter  {

    private Context context;
    private HomeContract.View contractView;

     HomePresenter(Context context, HomeContract.View contractView) {
        this.context = context;
        this.contractView = contractView;
    }
    @Override
    public void getInstanceRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        contractView.setInstanceRecycleView(recyclerView);
    }

}