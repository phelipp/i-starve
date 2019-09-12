package pndtech.com.istarve.view.story;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import pndtech.com.istarve.R;
import pndtech.com.istarve.Util.adapter.AdapterCardLoja;

public class StoryFragment extends Fragment implements StoryContract.View {

    private View root;
    private RecyclerView recyclerView;
    private StoryContract.Presenter storyPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_story, container, false);
        storyPresenter = new StoryPresenter(this.getContext(), this);
        storyPresenter.getInstanceRecyclerView(root);
        storyPresenter.updateProdutos();

        return root;
    }



    @Override
    public void setAdapter(AdapterCardLoja adapter) {
        this.recyclerView.setAdapter(adapter);
    }

    @Override
    public void setInstanceRecycleView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }


}
