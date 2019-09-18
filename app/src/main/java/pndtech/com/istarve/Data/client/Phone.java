package pndtech.com.istarve.Data.client;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;
import pndtech.com.istarve.Data.percistence.table.PhoneTable;
import pndtech.com.istarve.Data.percistence.table.Table;

public class Phone implements ObjectPercistence {

    private int id;
    private String ddd;
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Table.ID, this.id);
        contentValues.put(PhoneTable.ID, this.id);
        contentValues.put(PhoneTable.DDD, this.ddd);
        contentValues.put(PhoneTable.NUMBER, this.number);

        return contentValues;
    }

    @Override
    public List<Phone> getCursorToObject(Cursor cursor) {
        List<Phone> phones = new ArrayList<>();
        cursor.moveToFirst();
        int indexId = cursor.getColumnIndex(Table.ID);
        int indexNumber = cursor.getColumnIndex(PhoneTable.NUMBER);
        int indexDDD = cursor.getColumnIndex(PhoneTable.DDD);


        while (cursor.moveToNext()) {

            Phone phone = new Phone();
            phone.setId(cursor.getInt(indexId));
            phone.setDdd(cursor.getString(indexDDD));
            phone.setNumber(cursor.getString(indexNumber));

            phones.add(phone);
        }
        return phones;
    }

}
