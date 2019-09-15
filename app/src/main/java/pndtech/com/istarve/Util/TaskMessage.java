package pndtech.com.istarve.Util;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class TaskMessage extends AsyncTask<String, String, Boolean> {
    private Context context;

    public TaskMessage(Context context) {
        this.context = context;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
       String msg =  (strings.length > 0)?strings[0]:"";
       String rotaQueuer =  (strings.length > 1)?strings[1]:"Produto";
            Message.getInstance().sendMsg(msg,rotaQueuer);
        return true;
    }

    @Override
    protected void onPreExecute() {
        Toast.makeText(context, "Terminando ", Toast.LENGTH_SHORT).show();
    }

}
