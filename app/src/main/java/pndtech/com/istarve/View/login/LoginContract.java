package pndtech.com.istarve.View.login;

import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

interface LoginContract {
    interface View {
        EditText getEmail();

        EditText getPassword();

        Button getBtnLogin();

        Button getRegister();

        ProgressBar getProgress();

        LinearLayout getLoginLinearLayout();


    }

    interface Presenter {
        void register();

        void login();

        void redirectLogin();
    }
}
