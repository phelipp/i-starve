package pndtech.com.istarve.Data.produto;

import pndtech.com.istarve.Data.preferences.ObjectPreferences;

public class VersionProduto implements ObjectPreferences {

    private int version;

    public int getVersion() {
        return version;
    }

    public VersionProduto(int version) {
        this.version = version;
    }
}
