package pndtech.com.istarve.Data.client;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;
import pndtech.com.istarve.Data.percistence.table.AddressTable;
import pndtech.com.istarve.Data.percistence.table.StateTable;
import pndtech.com.istarve.Data.percistence.table.Table;

public class Address implements ObjectPercistence {
    private int id;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String zipCode;
    private State state;

    public Address() {
        state = new State();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Table.ID, this.id);
        contentValues.put(AddressTable.FK_STATE, this.state.getId());
        contentValues.put(AddressTable.STREET, this.street);
        contentValues.put(AddressTable.NUMBER, this.number);
        contentValues.put(AddressTable.NEIGHBORHOOD, this.neighborhood);
        contentValues.put(AddressTable.CITY, this.city);
        contentValues.put(AddressTable.ZIP_CODE, this.zipCode);
        return contentValues;
    }

    @Override
    public List<Address> getCursorToObject(Cursor cursor) {
        List<Address> addresses = new ArrayList<>();
        cursor.moveToFirst();
        int indexId = cursor.getColumnIndex(Table.ID);
        int indexNameState = cursor.getColumnIndex(StateTable.TABLE + "." + StateTable.NAME);
        int indexIdState = cursor.getColumnIndex(StateTable.TABLE + "." + StateTable.NAME);
        int indexStreet = cursor.getColumnIndex(AddressTable.STREET);
        int indexNumber = cursor.getColumnIndex(AddressTable.NUMBER);
        int indexNeighborhood = cursor.getColumnIndex(AddressTable.NEIGHBORHOOD);
        int indexCity = cursor.getColumnIndex(AddressTable.CITY);
        int indexZipCode = cursor.getColumnIndex(AddressTable.ZIP_CODE);
        while (cursor.moveToNext()) {
            Address address = new Address();
            State state = new State();
            state.setId(cursor.getInt(indexIdState));
            state.setName(cursor.getString(indexNameState));

            address.setId(cursor.getInt(indexId));
            address.setStreet(cursor.getString(indexStreet));
            address.setNumber(cursor.getString(indexNumber));
            address.setNeighborhood(cursor.getString(indexNeighborhood));
            address.setCity(cursor.getString(indexCity));
            address.setState(state);
            address.setZipCode(cursor.getString(indexZipCode));

            addresses.add(address);
        }
        return addresses;
    }
}
