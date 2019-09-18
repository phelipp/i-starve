package pndtech.com.istarve.Data.percistence.dao.cliente;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import pndtech.com.istarve.Data.client.Address;
import pndtech.com.istarve.Data.percistence.DataHelper;
import pndtech.com.istarve.Data.percistence.dao.Dao;
import pndtech.com.istarve.Data.percistence.table.AddressTable;
import pndtech.com.istarve.Data.percistence.table.ProdutoTable;
import pndtech.com.istarve.Data.percistence.table.StateTable;
import pndtech.com.istarve.Data.percistence.table.Table;
import pndtech.com.istarve.Data.produto.Produto;

public class DaoAddress implements Dao<Address> {
    private DataHelper dataHelper;

    public DaoAddress(Context context) {
        dataHelper = new DataHelper(context, null, null, DataHelper.VERSAO);

    }

    @Override
    public void save(Address object) {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase();) {
            db.insert(AddressTable.TABLE, null, object.toContentValues());

        }

    }

    @Override
    public void delete(int id) {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase();) {
            String selection = Table.ID + "=?";
            String[] args = {String.valueOf(id)};
            db.delete(AddressTable.TABLE, selection, args);

        }
    }

    @Override
    public void update(Address object) {

    }

    @Override
    public List<Address> select() {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase();) {
            StringBuilder sql = new StringBuilder("SELECT a.*,s.* FROM ? a INNER JOIN ? s on (a.? = s.? )");
            String[] args={AddressTable.TABLE, StateTable.NAME,AddressTable.FK_STATE,StateTable.ID};
            Cursor cursor = db.rawQuery(sql.toString(),args);

            List<Address> addresses = new Address().getCursorToObject(cursor);
            cursor.close();
            return addresses;
        }
    }


}
