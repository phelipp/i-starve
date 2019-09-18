package pndtech.com.istarve.Data.percistence.table;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;

public class AddressTable implements Table {

    public final static String TABLE = "address";
    public final static String FK_STATE = "_fk_state";
    public final static String STREET = "street";
    public final static String NUMBER = "number";
    public final static String NEIGHBORHOOD = "neighborhood";
    public final static String CITY = "city";
    public final static String ZIP_CODE = "zip_code";


    @Override
    public String sqlCreateTable() {
        return String.format(CREATE_TABLE_BEGIN + ",%s INTEGER,%s TEXT,%s INTEGER,%s TEXT,%s TEXT, %s TEXT," +
                        "foreing key (%s) references %s(%s)",
                TABLE,  FK_STATE, STREET, NUMBER, NEIGHBORHOOD, CITY, ZIP_CODE,
                FK_STATE,StateTable.TABLE,ID
                );
    }

    @Override
    public String sqlDropTable() {
        return String.format("" + DROP_SQL, TABLE);
    }


}
