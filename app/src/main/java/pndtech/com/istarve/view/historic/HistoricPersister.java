package pndtech.com.istarve.view.historic;

import android.content.Context;
import android.view.View;

public class HistoricPersister implements HistoricContract.Persister {
    private Context context;
    private HistoricContract.View historicView;

    public HistoricPersister(Context context, HistoricContract.View historicView) {
        this.context = context;
        this.historicView = historicView;
    }


}
