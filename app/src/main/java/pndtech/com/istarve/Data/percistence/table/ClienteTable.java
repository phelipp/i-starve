package pndtech.com.istarve.Data.percistence.table;

public class ClienteTable implements Table {

    public final static String TABLE = "cliente";
  //  public final static String ID_PHONE = "_id_phone";
   // public final static String ID_ADDRESS = "_id_address";
    public final static String NAME = "name";
    public final static String LAST_NAME = "last_name";
    public final static String CPF = "cpf";


    @Override
    public String sqlCreateTable() {

        return String.format(CREATE_TABLE_BEGIN +",%s TEXT,%s TEXT,%s TEXT);", TABLE, NAME,LAST_NAME,CPF);
    }
    @Override
    public String sqlDropTable() {
        return String.format(""+DROP_SQL,TABLE);
    }
}
