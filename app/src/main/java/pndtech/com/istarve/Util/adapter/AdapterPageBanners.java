package pndtech.com.istarve.Util.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import pndtech.com.istarve.Data.Banner;
import pndtech.com.istarve.R;

public class AdapterPageBanners extends PagerAdapter {

    private List<Banner> banners;
    private Context context;
    private LayoutInflater layoutInflater;
    public AdapterPageBanners(Context context, List<Banner> banners) {
        this.context = context;
        this.banners = banners;
    }


    @Override
    public int getCount() {

        return banners.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater =LayoutInflater.from(context);

      //  ImageView image =view.findViewById(R.id.image);
     //   Picasso.get().load(banners.get(position).getUrlImage()).into(image);
        return layoutInflater.inflate(R.layout.card_banners,container,false);
    }


}
