package pndtech.com.istarve.Data.client;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;
import pndtech.com.istarve.Data.percistence.table.AddressTable;
import pndtech.com.istarve.Data.percistence.table.ClienteTable;
import pndtech.com.istarve.Data.percistence.table.PhoneTable;
import pndtech.com.istarve.Data.percistence.table.StateTable;
import pndtech.com.istarve.Data.percistence.table.Table;

public class Cliente implements ObjectPercistence {
    private int id;
    private String name;
    private String lastName;
    private Phone phone;
    private Address address;
    private String cpf;

    public Cliente() {
        phone = new Phone();
        address = new Address();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Table.ID, this.id);
        contentValues.put(ClienteTable.FK_PHONE, this.phone.getId());
        contentValues.put(ClienteTable.FK_ADDRESS, this.address.getId());
        contentValues.put(ClienteTable.NAME, this.name);
        contentValues.put(ClienteTable.LAST_NAME, this.lastName);
        contentValues.put(ClienteTable.CPF, this.cpf);

        return contentValues;
    }

    @Override
    public List<Cliente> getCursorToObject(Cursor cursor) {
        List<Cliente> clientes = new ArrayList<>();
        cursor.moveToFirst();
        int indexId = cursor.getColumnIndex(Table.ID);
        int indexName = cursor.getColumnIndex(ClienteTable.NAME);
        int indexLastName = cursor.getColumnIndex(ClienteTable.LAST_NAME);
        int indexCpf = cursor.getColumnIndex(ClienteTable.CPF);


        int indexIdState = cursor.getColumnIndex(StateTable.TABLE + "." + StateTable.NAME);
        int indexNameState = cursor.getColumnIndex(StateTable.TABLE + "." + StateTable.NAME);

        int indexIdPhone = cursor.getColumnIndex(PhoneTable.TABLE + "." + PhoneTable.ID);
        int indexNumberPhone = cursor.getColumnIndex(PhoneTable.TABLE + "." + PhoneTable.NUMBER);
        int indexDDDPhone = cursor.getColumnIndex(PhoneTable.TABLE + "." + PhoneTable.DDD);

        int indexIdAddress = cursor.getColumnIndex(AddressTable.TABLE + "." + AddressTable.ID);
        int indexStreetAddress = cursor.getColumnIndex(AddressTable.TABLE + "." + AddressTable.STREET);
        int indexNumberAddress = cursor.getColumnIndex(AddressTable.TABLE + "." + AddressTable.NUMBER);
        int indexNeighborhoodAddress = cursor.getColumnIndex(AddressTable.TABLE + "." + AddressTable.NEIGHBORHOOD);
        int indexCityAddress = cursor.getColumnIndex(AddressTable.TABLE + "." + AddressTable.CITY);
        int indexZipCodeAddress = cursor.getColumnIndex(AddressTable.TABLE + "." + AddressTable.ZIP_CODE);

        while (cursor.moveToNext()) {
            Cliente cliente = new Cliente();
            Address address = new Address();
            State state = new State();
            Phone phone = new Phone();
            phone.setId(cursor.getInt(indexIdPhone));
            phone.setDdd(cursor.getString(indexDDDPhone));
            phone.setNumber(cursor.getString(indexNumberPhone));

            state.setId(cursor.getInt(indexIdState));
            state.setName(cursor.getString(indexNameState));

            address.setId(cursor.getInt(indexIdAddress));
            address.setStreet(cursor.getString(indexStreetAddress));
            address.setNumber(cursor.getString(indexNumberAddress));
            address.setNeighborhood(cursor.getString(indexNeighborhoodAddress));
            address.setCity(cursor.getString(indexCityAddress));
            address.setState(state);
            address.setZipCode(cursor.getString(indexZipCodeAddress));

            address.setState(state);

            cliente.setId(cursor.getInt(indexId));
            cliente.setName(cursor.getString(indexName));
            cliente.setLastName(cursor.getString(indexLastName));
            cliente.setCpf(cursor.getString(indexCpf));
            cliente.setPhone(phone);
            cliente.setAddress(address);

            clientes.add(cliente);
        }
        return clientes;
    }
}
