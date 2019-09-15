package pndtech.com.istarve.View.banner;

import android.widget.ImageView;

interface BannerContract {
    interface View {
        ImageView getImage();

        int getPosition();

        android.view.View getViewRoot();
    }

    interface Presenter {
        void setImage();

    }
}
