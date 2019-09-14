package pndtech.com.istarve.Data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import pndtech.com.istarve.Data.client.UserLogin;

public class PreferencesLogin implements InjectPreference<UserLogin> {
    public static final String EMAIL = "email";
    public static final String PASS = "password";

    private SharedPreferences preferences;
    private static PreferencesLogin instance;

    private PreferencesLogin(AppCompatActivity activity) {
        preferences = activity.getBaseContext().getSharedPreferences(TAG_PREFERENCES, Context.MODE_PRIVATE);
    }

    public static PreferencesLogin getInstance(AppCompatActivity activity) {
        return (instance == null) ? new PreferencesLogin(activity) : instance;
    }

    @Override
    public void save(UserLogin object) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(EMAIL, object.getEmail());
        editor.putString(PASS, object.getPassword());
        editor.apply();
    }

    @Override
    public UserLogin getObject() {
        String email = preferences.getString(EMAIL, "");
        String password = preferences.getString(PASS, "");
        return new UserLogin(email, password);

    }

    @Override
    public void clear() {
        save(new UserLogin("", ""));
    }
}
