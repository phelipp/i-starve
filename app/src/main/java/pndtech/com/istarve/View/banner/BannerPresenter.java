package pndtech.com.istarve.View.banner;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.Banner;

public class BannerPresenter implements BannerContract.Presenter {
    private BannerContract.View contractView;
    public final static List<Banner> banners = new ArrayList<>();


    public BannerPresenter(BannerContract.View contractView) {
        this.contractView = contractView;
        this.getData();

    }

    @Override
    public void setImage() {
        Picasso.get().load(contractView.getPosition()).into(contractView.getImage());
    }

    private void getData() {
        banners.clear();
        banners.add(new Banner("http://www.baltana.com/files/wallpapers-5/Hamburger-HD-Background-Wallpaper-16705.jpg"));
        banners.add(new Banner("http://www.baltana.com/files/wallpapers-5/Hamburger-HD-Background-Wallpaper-16705.jpg"));
        banners.add(new Banner("https://cdn.abcotvs.com/dip/images/294609_090414-ap-cheeseburgers-img.jpg"));
        banners.add(new Banner("https://pbs.twimg.com/media/CLAu5NUWsAALVGX.png"));
        //  return banners;
    }


}
