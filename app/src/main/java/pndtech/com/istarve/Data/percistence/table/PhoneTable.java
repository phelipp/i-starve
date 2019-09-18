package pndtech.com.istarve.Data.percistence.table;

public class PhoneTable implements Table {

    public final static String TABLE = "phone";
    public final static String DDD = "ddd";
    public final static String NUMBER = "number";


    @Override
    public String sqlCreateTable() {

        return String.format(CREATE_TABLE_BEGIN + ",%s TEXT,%s TEXT);", TABLE, DDD, NUMBER);
    }
    @Override
    public String sqlDropTable() {
        return String.format(""+DROP_SQL,TABLE);
    }
}
