package pndtech.com.istarve.Data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import pndtech.com.istarve.Data.produto.VersionProduto;

public class PreferencesProdutos implements InjectPreference {
    public static final String VERSION = "version";

    private SharedPreferences preferences;
    private static PreferencesProdutos instance;

    private PreferencesProdutos(AppCompatActivity activity) {
        preferences = activity.getBaseContext().getSharedPreferences(TAG_PREFERENCES, Context.MODE_PRIVATE);
        getObject();
    }

    @Override
    public void save(ObjectPreferences object) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt(VERSION,((VersionProduto)object).getVersion());
        edit.apply();
    }

    @Override
    public ObjectPreferences getObject() {

        return new VersionProduto(preferences.getInt(VERSION, 0));

    }

    /**
     * retorna para a versão 0
     */
    @Override
    public void clear() {
        save(new VersionProduto(0));
    }

    public static PreferencesProdutos getInstance(AppCompatActivity activity) {
        return (instance == null) ? new PreferencesProdutos(activity) : instance;
    }
}
