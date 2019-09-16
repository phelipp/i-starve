package pndtech.com.istarve.View.login;

import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import pndtech.com.istarve.Data.client.UserLogin;
import pndtech.com.istarve.Data.preferences.InjectPreference;
import pndtech.com.istarve.Data.preferences.PreferencesLogin;
import pndtech.com.istarve.R;
import pndtech.com.istarve.View.main.MainActivity;

public class LoginPresenter implements LoginContract.Presenter {
    private FirebaseAuth mAuth;
    private LoginContract.View loginView;
    private final AppCompatActivity activity;
    //private static  SharedPreferences preferences;
    private final InjectPreference preferenceLogin;

    LoginPresenter(LoginContract.View loginView, AppCompatActivity activity) {
        this.mAuth = FirebaseAuth.getInstance();
        this.loginView = loginView;
        this.activity = activity;
        preferenceLogin = PreferencesLogin.getInstance(activity);
        loginView.getLoginLinearLayout().setVisibility(View.INVISIBLE);
    }

    @Override
    public void register() {

        loginView.getRegister().setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String email = loginView.getEmail().getText().toString();
                String password = loginView.getPassword().getText().toString();
                Log.i("log", email);
                Log.i("log", password);
                Log.i("log", "--------------------");
                mAuth.createUserWithEmailAndPassword(email, password).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isComplete()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    assert user != null;
                                    user.sendEmailVerification();
                                    Toast.makeText(activity, "Confirme seu email !!!", Toast.LENGTH_SHORT).show();

                                } else {
                                    Log.d("erro", task.getException().toString());
                                    Toast.makeText(activity, "Erro ao registrar sua conta !!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                return true;
            }
        });

    }

    @Override
    public void login() {
        loginView.getBtnLogin().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectLogin();
            }
        });


    }

    @Override
    public void redirectLogin() {
        final UserLogin userLogin = (UserLogin) preferenceLogin.getObject();
        final String email = (loginView.getEmail() != null) ? loginView.getEmail().getText().toString() : "";
        final String password = (loginView.getPassword() != null) ? loginView.getPassword().getText().toString() : "";
        if (!email.isEmpty() || !password.isEmpty()) {
            userLogin.setEmail(email);
            userLogin.setPassword(password);
        }
        if (!userLogin.getEmail().isEmpty() || !userLogin.getPassword().isEmpty()) {
            loginView.getProgress().setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(userLogin.getEmail(), userLogin.getPassword())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isComplete()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                assert user != null;
                                if (user.isEmailVerified()) {
                                    preferenceLogin.save(userLogin);
                                    Intent intent = new Intent(activity.getBaseContext(), MainActivity.class);
                                    activity.startActivity(intent);

                                    //Toast.makeText(activity.getBaseContext(), "Direcionando pagina", Toast.LENGTH_SHORT).show();
                                } else {
                                    preferenceLogin.clear();
                                    renderLogin(true);
                                    Toast.makeText(activity, "Verifique seu email para logar", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                // renderLogin(true);
                                renderLogin(true);
                                Toast.makeText(activity, "Senha ou email invalido!", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

        } else {
            renderLogin(true);
        }
    }

    /***
     * Caso o valor seja false ele esconde o formulario e amostra o progressbar
     * @param value
     */
    private void renderLogin(boolean value) {
        if (value) {
            loginView.getProgress().setVisibility(View.INVISIBLE);
            loginView.getLoginLinearLayout().setVisibility(View.VISIBLE);
        } else {
            loginView.getProgress().setVisibility(View.VISIBLE);
            loginView.getLoginLinearLayout().setVisibility(View.INVISIBLE);
        }
    }

}
