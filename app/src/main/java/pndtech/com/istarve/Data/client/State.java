package pndtech.com.istarve.Data.client;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;
import pndtech.com.istarve.Data.percistence.table.StateTable;
import pndtech.com.istarve.Data.percistence.table.Table;

public class State implements ObjectPercistence {
    private int id;

    private String name;

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

    @Override
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Table.ID, this.id);
        contentValues.put(StateTable.NAME, this.name);
        return contentValues;
    }

    @Override
    public List<State> getCursorToObject(Cursor cursor) {
        List<State> states = new ArrayList<>();
        cursor.moveToFirst();
        int indexId = cursor.getColumnIndex(Table.ID);
        int indexName = cursor.getColumnIndex(StateTable.NAME);
        while (cursor.moveToNext()) {
            State state = new State();
            state.setId(cursor.getInt(indexId));
            state.setName(cursor.getString(indexName));
            states.add(state);
        }
        return states;
    }
}
