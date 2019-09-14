package pndtech.com.istarve.View.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import pndtech.com.istarve.R;
import pndtech.com.istarve.Util.adapter.AdapterCardBanners;
import pndtech.com.istarve.Util.adapter.AdapterCardCarrinho;

public class HomeFragment extends Fragment implements HomeContract.View {

    private HomeContract.Presenter homePresenter;
    private View root;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        homePresenter = new HomePresenter(this.getContext(), this);
        homePresenter.getInstanceRecyclerView(root);
        homePresenter.updateProdutos();
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