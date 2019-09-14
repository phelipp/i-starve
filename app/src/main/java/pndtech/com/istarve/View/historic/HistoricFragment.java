package pndtech.com.istarve.View.historic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pndtech.com.istarve.R;

public class HistoricFragment extends Fragment implements HistoricContract.View {
    private HistoricContract.Persister historicPersister ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_historic, container, false);
        historicPersister = new HistoricPersister(this.getContext(),this);
        return root;
    }
}
