package pndtech.com.istarve.Data.percistence.dao.cliente;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import pndtech.com.istarve.Data.percistence.DataHelper;
import pndtech.com.istarve.Data.percistence.dao.Dao;
import pndtech.com.istarve.Data.percistence.table.ProdutoTable;
import pndtech.com.istarve.Data.produto.Produto;

public class DaoProduto implements Dao<Produto> {
    private DataHelper dataHelper;

    public DaoProduto(Context context) {
        dataHelper = new DataHelper(context, null, null, DataHelper.VERSAO);

    }

    @Override
    public void save(Produto object) {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase();) {
            db.insert(ProdutoTable.TABLE, null, object.toContentValues());

        }

    }

    @Override
    public void delete(int id) {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase();) {
            String selection = ProdutoTable.ID + "=?";
            String[] args = {String.valueOf(id)};
            db.delete(ProdutoTable.TABLE, selection, args);

        }
    }

    @Override
    public void update(Produto object) {

    }

    @Override
    public List<Produto> select() {
        try (SQLiteDatabase db = dataHelper.getWritableDatabase();) {
            Cursor cursor = db.query(ProdutoTable.TABLE, null, null, null, null, null, null);
            List<Produto> produtos = new Produto().getCursorToObject(cursor);
            cursor.close();
            return produtos;
        }
    }


}
