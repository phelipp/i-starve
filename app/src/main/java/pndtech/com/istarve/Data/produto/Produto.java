package pndtech.com.istarve.Data.produto;

import android.content.ContentValues;
import android.database.Cursor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;
import pndtech.com.istarve.Data.percistence.table.ProdutoTable;
import pndtech.com.istarve.Util.Formats;

public class Produto implements Serializable, ObjectPercistence {
    private int id;
    private String name;
    private float value;
    private String description;
    private String imageUrl;

    public Produto() {
    }

    public Produto(int id) {
        this.id = id;
    }

    public Produto(int id, String name, float value, String imageUrl, String description) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public String getValueCurrency() {
        return Formats.currency(value);
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = Float.parseFloat(value);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ProdutoTable.ID, this.id);
        contentValues.put(ProdutoTable.NAME, this.name);
        contentValues.put(ProdutoTable.VALUE, this.value);
        contentValues.put(ProdutoTable.DESCRIPTION, this.description);
        contentValues.put(ProdutoTable.IMAGE_URL, this.imageUrl);
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
