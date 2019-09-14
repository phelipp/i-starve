package pndtech.com.istarve.Data.preferences;

import pndtech.com.istarve.Data.Inject.Inject;

public interface InjectPreference<E extends ObjectPreferences> extends Inject {
    public static final String TAG_PREFERENCES = "app";
    void save(E object);

    E getObject();
    void clear();
}
