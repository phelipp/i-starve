package pndtech.com.istarve.View.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pndtech.com.istarve.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter loginPresenter;
   // @BindView(R.id.email)
    private EditText email;
   // @BindView(R.id.password)
    private EditText password;
 //   @BindView(R.id.btnLogin)
    private Button btnLogin;
  //  @BindView(R.id.register)
    private TextView register;
 //   @BindView(R.id.progress)
    private ProgressBar progress;
 //   @BindView(R.id.loginLinearlayout)
    private LinearLayout loginLinearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //ButterKnife.bind(this);
        this.email =findViewById(R.id.email);
        this.password =findViewById(R.id.password);
        this.btnLogin =findViewById(R.id.btnLogin);
        this.register =findViewById(R.id.register);
        this.progress =findViewById(R.id.progress);
        this.loginLinearLayout =findViewById(R.id.loginLinearlayout);
        loginPresenter = new LoginPresenter(this, this);
        loginPresenter.redirectLogin();
        loginPresenter.login();

    }


    @Override
    public ProgressBar getProgress() {
        return progress;
    }

    @Override
    public LinearLayout getLoginLinearLayout() {
        return loginLinearLayout;
    }

    @Override
    public EditText getEmail() {
        return email;
    }

    @Override
    public EditText getPassword() {
        return password;
    }

    @Override
    public Button getBtnLogin() {
        return btnLogin;
    }

    @Override
    public TextView getRegister() {
        return register;
    }


}
