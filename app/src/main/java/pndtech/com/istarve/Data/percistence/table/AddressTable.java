package pndtech.com.istarve.Data.percistence.table;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;

public class AddressTable implements Table {

    public final static String TABLE = "adress";
    public final static String ID_CLIENTE = "_id_cliente";
    public final static String ID_STATE = "_id_state";
    public final static String STREET = "street";
    public final static String NUMBER = "number";
    public final static String NEIGHBORHOOD = "neighborhood";
    public final static String CITY = "city";
    public final static String ZIP_CODE = "zip_code";


    @Override
    public String sqlCreateTable() {
        return String.format(CREATE_TABLE_BEGIN + ",%s INTEGER,%s INTEGER,%s TEXT,%s TEXT,%s TEXT, %s TEXT)",
                TABLE, ID_CLIENTE, ID_STATE, STREET, NEIGHBORHOOD, CITY, ZIP_CODE);
    }

    @Override
    public String sqlDropTable() {
        return String.format(""+DROP_SQL,TABLE);
    }


}
