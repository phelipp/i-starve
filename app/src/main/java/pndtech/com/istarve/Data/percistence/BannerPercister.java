package pndtech.com.istarve.Data.percistence;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.Banner;

public class BannerPercister implements Percistence<Banner> {
    private static List<Banner> objects;
    private static BannerPercister instance;

    public static BannerPercister getInstance() {
        return instance = (instance == null) ? new BannerPercister() : instance;
    }

    private BannerPercister() {
        objects = (objects == null) ? new ArrayList<Banner>() : objects;
    }

    @Override
    public List<Banner> get() {
        List<Banner> banners = new ArrayList<>();
        banners.add(new Banner("https://i.imgur.com/TTDA9Fx.png"));
        banners.add(new Banner("https://i.imgur.com/jCmPwIf.png"));
        banners.add(new Banner("https://i.imgur.com/TTDA9Fx.png"));
        banners.add(new Banner("https://i.imgur.com/jCmPwIf.png"));
        return banners;
    }

    @Override
    public Banner getIndex(int position) {
        return objects.get(position);
    }


}
