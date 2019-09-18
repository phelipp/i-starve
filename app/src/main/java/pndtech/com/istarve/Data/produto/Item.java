package pndtech.com.istarve.Data.produto;

import android.content.ContentValues;
import android.database.Cursor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;
import pndtech.com.istarve.Data.percistence.table.ItemTable;
import pndtech.com.istarve.Data.percistence.table.ProdutoTable;

public class Item implements ObjectPercistence {
    private int id;
    private int amount;
    private Produto produto;

    public Item() {
        produto = new Produto();
    }

    public Item(int id, int amount, Produto produto) {
        this.id = id;
        this.amount = amount;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    @Override
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemTable.ID, this.id);
        contentValues.put(ItemTable.FK_PRODUTO, this.getProduto().getId());
        contentValues.put(ItemTable.AMOUNT, this.amount);
       
        return contentValues;
    }

    @Override
    public List<Produto> getCursorToObject(Cursor cursor) {
        List<Produto> produtos = new ArrayList<>();
        cursor.moveToFirst();
        int indexId = cursor.getColumnIndex(ProdutoTable.ID);
        int indexName = cursor.getColumnIndex(ProdutoTable.NAME);
        int indexValue = cursor.getColumnIndex(ProdutoTable.VALUE);
        int indexDescription = cursor.getColumnIndex(ProdutoTable.DESCRIPTION);
        int indexImage = cursor.getColumnIndex(ProdutoTable.IMAGE_URL);
        while (cursor.moveToNext()) {
            Produto produto =new Produto();
            produto.setId(cursor.getInt(indexId));
            produto.setName(cursor.getString(indexName));
            produto.setValue(cursor.getFloat(indexValue));
            produto.setDescription(cursor.getString(indexDescription));
            produto.setImageUrl(cursor.getString(indexImage));
            produtos.add(produto);
        }
        return produtos;
    }
}
