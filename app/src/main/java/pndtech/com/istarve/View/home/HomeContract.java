package pndtech.com.istarve.View.home;

import pndtech.com.istarve.Util.adapter.AdapterPageBanners;

interface HomeContract {
    interface View {

        void setAdapter(AdapterPageBanners adapter);
    }

    interface Presenter {
       void updataAdapter();
    }
}
