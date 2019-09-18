package pndtech.com.istarve.Data.produto;

import android.content.ContentValues;
import android.database.Cursor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;
import pndtech.com.istarve.Data.percistence.table.ItemTable;
import pndtech.com.istarve.Data.percistence.table.ProdutoTable;
import pndtech.com.istarve.Data.percistence.table.Table;

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
    public List<Item> getCursorToObject(Cursor cursor) {
        List<Item> itens = new ArrayList<>();
        cursor.moveToFirst();
        int indexId = cursor.getColumnIndex(Table.ID);
        int indexAmout = cursor.getColumnIndex(ItemTable.AMOUNT);
        int indexIdProduto = cursor.getColumnIndex(ProdutoTable.ID);
        int indexNameProduto = cursor.getColumnIndex(ProdutoTable.NAME);
        int indexValueProduto = cursor.getColumnIndex(ProdutoTable.VALUE);
        int indexDescriptionProduto = cursor.getColumnIndex(ProdutoTable.DESCRIPTION);
        int indexImageProduto = cursor.getColumnIndex(ProdutoTable.IMAGE_URL);
        while (cursor.moveToNext()) {
            Item item = new Item();
            item.setId(cursor.getInt(indexId));
            item.setAmount(cursor.getInt(indexAmout));
            Produto produto =new Produto();
            produto.setId(cursor.getInt(indexIdProduto));
            produto.setName(cursor.getString(indexNameProduto));
            produto.setValue(cursor.getFloat(indexValueProduto));
            produto.setDescription(cursor.getString(indexDescriptionProduto));
            produto.setImageUrl(cursor.getString(indexImageProduto));
            item.setProduto(produto);
            itens.add(item);
        }
        return itens;
    }
}
