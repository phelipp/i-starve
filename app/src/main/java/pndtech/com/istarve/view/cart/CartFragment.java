package pndtech.com.istarve.view.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import pndtech.com.istarve.R;
import pndtech.com.istarve.Util.adapter.AdapterCardCarrinho;

public class CartFragment extends Fragment implements CartContract.View {
    private CartContract.Presenter cartPresenter;
    private View root;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.root = inflater.inflate(R.layout.fragment_cart, container, false);
        this.cartPresenter = new CartPresenter(this.getContext(), this);
        this.cartPresenter.getInstanceRecyclerView(root);
        return root;
    }



    @Override
    public void setAdapter(AdapterCardCarrinho adapter) {
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setInstanceRecycleView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
