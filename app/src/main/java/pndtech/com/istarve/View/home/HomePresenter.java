package pndtech.com.istarve.View.home;

import android.content.Context;
import android.view.View;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.Banner;
import pndtech.com.istarve.R;
import pndtech.com.istarve.Util.adapter.AdapterCardBanners;

public class HomePresenter implements HomeContract.Presenter  {

    private Context context;
    private HomeContract.View contractView;
    private static List<Banner> banners;
    private AdapterCardBanners adapter;
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
    @Override
    public void updateProdutos() {
        banners = getData();
        if (adapter == null) {
            adapter = new AdapterCardBanners(context,banners);
        } else if (!adapter.getBanners().equals(banners)) {
            adapter.setBanners(banners);
        }
        contractView.setAdapter(adapter);
    }
    private List<Banner> getData()
    {
        List<Banner> banners = new ArrayList<>();
        banners.add(new Banner("http://www.baltana.com/files/wallpapers-5/Hamburger-HD-Background-Wallpaper-16705.jpg"));
        banners.add(new Banner("http://www.baltana.com/files/wallpapers-5/Hamburger-HD-Background-Wallpaper-16705.jpg"));
        banners.add(new Banner("https://cdn.abcotvs.com/dip/images/294609_090414-ap-cheeseburgers-img.jpg"));
        banners.add(new Banner("https://pbs.twimg.com/media/CLAu5NUWsAALVGX.png"));
        return banners;
    }

}