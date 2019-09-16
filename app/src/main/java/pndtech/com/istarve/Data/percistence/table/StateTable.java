package pndtech.com.istarve.Data.percistence.table;

public class StateTable implements Table {
    private static final String TABLE = "state";


    @Override
    public String sqlCreateTable() {
        return String.format(CREATE_TABLE_BEGIN +");",TABLE);
    }
    @Override
    public String sqlDropTable() {
        return String.format(""+DROP_SQL,TABLE);
    }
}
