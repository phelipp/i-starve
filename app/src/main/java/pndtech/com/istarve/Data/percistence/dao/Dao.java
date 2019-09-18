package pndtech.com.istarve.Data.percistence.dao;

import android.content.ContentValues;

import java.util.List;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;

public interface Dao<E extends ObjectPercistence> {
    void save(E object);

    void delete(int id);

    void update(E object);

    List<E> select();
}
