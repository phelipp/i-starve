package pndtech.com.istarve.Data.percistence.dao.cliente;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import pndtech.com.istarve.Data.client.Address;
import pndtech.com.istarve.Data.client.Phone;
import pndtech.com.istarve.Data.percistence.DataHelper;
import pndtech.com.istarve.Data.percistence.dao.Dao;
import pndtech.com.istarve.Data.percistence.table.AddressTable;
import pndtech.com.istarve.Data.percistence.table.PhoneTable;
import pndtech.com.istarve.Data.percistence.table.StateTable;
import pndtech.com.istarve.Data.percistence.table.Table;

public class DaoPhone implements Dao<Phone> {
    private DataHelper dataHelper;

    public DaoPhone(Context context) {
        dataHelper = new DataHelper(context, null, null, DataHelper.VERSAO);

    }

    @Override
    public void save(Phone object) {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase()) {
            db.insert(PhoneTable.TABLE, null, object.toContentValues());

        }

    }

    @Override
    public void delete(int id) {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase()) {
            String selection = Table.ID + "=?";
            String[] args = {String.valueOf(id)};
            db.delete(PhoneTable.TABLE, selection, args);

        }
    }

    @Override
    public void update(Phone object) {

    }

    @Override
    public List<Phone> select() {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase()) {
            Cursor cursor = db.query(PhoneTable.TABLE, null, null, null, null, null, null);
            List<Phone> phones = new Phone().getCursorToObject(cursor);
            cursor.close();
            return phones;
        }
    }


}
