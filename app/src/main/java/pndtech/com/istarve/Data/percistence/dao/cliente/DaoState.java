package pndtech.com.istarve.Data.percistence.dao.cliente;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import pndtech.com.istarve.Data.client.Phone;
import pndtech.com.istarve.Data.client.State;
import pndtech.com.istarve.Data.percistence.DataHelper;
import pndtech.com.istarve.Data.percistence.dao.Dao;
import pndtech.com.istarve.Data.percistence.table.AddressTable;
import pndtech.com.istarve.Data.percistence.table.PhoneTable;
import pndtech.com.istarve.Data.percistence.table.StateTable;
import pndtech.com.istarve.Data.percistence.table.Table;

public class DaoState implements Dao<State> {
    private DataHelper dataHelper;

    public DaoState(Context context) {
        dataHelper = new DataHelper(context, null, null, DataHelper.VERSAO);

    }

    @Override
    public void save(State object) {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase()) {
            db.insert(StateTable.TABLE, null, object.toContentValues());

        }

    }

    @Override
    public void delete(int id) {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase()) {
            String selection = Table.ID + "=?";
            String[] args = {String.valueOf(id)};
            db.delete(StateTable.TABLE, selection, args);

        }
    }

    @Override
    public void update(State object) {

    }

    @Override
    public List<State> select() {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase()) {
            Cursor cursor = db.query(StateTable.TABLE, null, null, null, null, null, null);
            List<State> states = new State().getCursorToObject(cursor);
            cursor.close();
            return states;
        }
    }


}
