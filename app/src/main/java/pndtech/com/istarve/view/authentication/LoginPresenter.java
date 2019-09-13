package pndtech.com.istarve.view.authentication;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import pndtech.com.istarve.MainActivity;

public class LoginPresenter {
    private FirebaseAuth mAuth;

    public LoginPresenter() {
        this.mAuth = FirebaseAuth.getInstance();
    }

    public void onClickRegister(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isComplete()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            user.sendEmailVerification();
                        } else {

                        }
                    }
                });
    }

    public void onClickLogin(final AppCompatActivity activity, final String email, final String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isComplete()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user.isEmailVerified()) {
                                Intent intent = new Intent(activity, MainActivity.class);
                                activity.startActivity(intent);
                            } else {
                                Toast.makeText(activity, "Verifique seu email para logar", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(activity, "Senha ou email invalido!", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    public void redirect(final AppCompatActivity activity, FirebaseUser user) {


        if (user!=null) {
            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
        }
    }
}
