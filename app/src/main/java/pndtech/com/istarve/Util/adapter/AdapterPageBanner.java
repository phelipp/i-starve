package pndtech.com.istarve.Util.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;

import pndtech.com.istarve.Data.Banner;
import pndtech.com.istarve.R;

public class AdapterPageBanner extends FragmentStatePagerAdapter {
    private List<Banner> banners;


    public AdapterPageBanner(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {


        return null;
    }

    @Override
    public int getCount() {
        return banners.size();
    }
}
