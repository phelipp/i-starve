package pndtech.com.istarve.View.banner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pndtech.com.istarve.R;

public class BannerFragment extends Fragment implements BannerContract.View {

    private int position;
    private ImageView image;
    private BannerContract.Presenter presenter;
    private View root;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("bannerPos");
        }
    }

    @Nullable
        @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.card_banners, container, false);
        image = root.findViewById(R.id.image);
        presenter.setImage();
        return root;

    }

    public static BannerFragment getInstance(int position) {
        BannerFragment fragment = new BannerFragment();
        fragment.position = position;
        return fragment;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("bannerPos", position);
    }

    @Override
    public ImageView getImage() {
        return this.image;
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    @Override
    public View getViewRoot() {
        return root;
    }
}
