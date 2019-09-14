package pndtech.com.istarve.View.historic;

import android.content.Context;

public class HistoricPersister implements HistoricContract.Persister {
    private Context context;
    private HistoricContract.View historicView;

    public HistoricPersister(Context context, HistoricContract.View historicView) {
        this.context = context;
        this.historicView = historicView;
    }


}
