package pndtech.com.istarve.Data.percistence.table;

public class ClienteTable implements Table {

    public final static String TABLE = "cliente";
    public final static String FK_PHONE = "_fk_phone";
    public final static String FK_ADDRESS = "_fk_address";
    public final static String NAME = "name";
    public final static String LAST_NAME = "last_name";
    public final static String CPF = "cpf";


    @Override
    public String sqlCreateTable() {

        return String.format(CREATE_TABLE_BEGIN + ",%s TEXT,%s TEXT,%s TEXT," +
                        "foreing key(%s) references %s(%s)," +
                        "foreing key (%s) references %s(%s);",
                TABLE, NAME, LAST_NAME, CPF, FK_PHONE, PhoneTable.TABLE, ID,FK_ADDRESS,AddressTable.TABLE,ID);
    }

    @Override
    public String sqlDropTable() {
        return String.format("" + DROP_SQL, TABLE);
    }
}
