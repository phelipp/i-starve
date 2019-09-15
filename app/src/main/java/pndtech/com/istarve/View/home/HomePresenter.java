package pndtech.com.istarve.View.home;

import android.content.Context;

import pndtech.com.istarve.Data.percistence.BannerPercister;
import pndtech.com.istarve.Data.percistence.Percistence;
import pndtech.com.istarve.Util.TaskMessage;
import pndtech.com.istarve.Util.adapter.AdapterPageBanners;

public class HomePresenter implements HomeContract.Presenter {
    private final   Percistence bannersPercistence;
    private Context context;
    private HomeContract.View contractView;
    private AdapterPageBanners adapter;

    // private static List<Banner> banners;
    // private AdapterPageBanners adapter;
    HomePresenter(Context context, HomeContract.View contractView) {
        this.context = context;
        this.contractView = contractView;
        bannersPercistence = BannerPercister.getInstance();
        updataAdapter();
        TaskMessage taskMessage = new TaskMessage(context);
        taskMessage.execute("Olha quem esta falando");
    }


    @Override
    public void updataAdapter() {
        if (adapter == null) {
            adapter = new AdapterPageBanners(context, bannersPercistence.get());
        }
        contractView.setAdapter(adapter);
    }
}