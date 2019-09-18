package pndtech.com.istarve.Data.percistence.table;

public class StateTable implements Table {
    public static final String TABLE = "state";
    public static final String NAME = "name";


    @Override
    public String sqlCreateTable() {
        return String.format(CREATE_TABLE_BEGIN +",%s TEXT);",TABLE,NAME);
    }
    @Override
    public String sqlDropTable() {
        return String.format(""+DROP_SQL,TABLE);
    }
}
