package pndtech.com.istarve.View.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import pndtech.com.istarve.R;
import pndtech.com.istarve.Util.adapter.AdapterPageBanners;

public class HomeFragment extends Fragment implements HomeContract.View {

    private HomeContract.Presenter homePresenter;
    private View root;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = root.findViewById(R.id.view_page);
        homePresenter = new HomePresenter(this.getContext(), this);

        return root;
    }

    @Override
    public void setAdapter(AdapterPageBanners adapter) {
        this.viewPager.setAdapter(adapter);
    }
}