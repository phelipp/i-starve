package pndtech.com.istarve.View.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.Banner;
import pndtech.com.istarve.R;
import pndtech.com.istarve.Util.adapter.AdapterCardBanners;
import pndtech.com.istarve.Util.adapter.AdapterCardCarrinho;
import pndtech.com.istarve.Util.adapter.AdapterPageBanner;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class HomeFragment extends Fragment implements HomeContract.View {

    private HomeContract.Presenter homePresenter;
    private View root;
    private RecyclerView recyclerView;
    private ViewPager viewPager;
    private List<Banner> getData()
    {
        List<Banner> banners = new ArrayList<>();
        banners.add(new Banner("http://www.baltana.com/files/wallpapers-5/Hamburger-HD-Background-Wallpaper-16705.jpg"));
        banners.add(new Banner("http://www.baltana.com/files/wallpapers-5/Hamburger-HD-Background-Wallpaper-16705.jpg"));
        banners.add(new Banner("https://cdn.abcotvs.com/dip/images/294609_090414-ap-cheeseburgers-img.jpg"));
        banners.add(new Banner("https://pbs.twimg.com/media/CLAu5NUWsAALVGX.png"));
        return banners;
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        homePresenter = new HomePresenter(this.getContext(), this);
        homePresenter.getInstanceRecyclerView(root);


       // homePresenter.updateProdutos();
        return root;
    }

    @Override
    public void setInstanceRecycleView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public void setAdapter(AdapterCardBanners adapter) {
        if (this.recyclerView == null) homePresenter.getInstanceRecyclerView(root);
        this.recyclerView.setAdapter(adapter);
    }
}