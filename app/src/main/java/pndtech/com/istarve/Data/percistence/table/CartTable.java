package pndtech.com.istarve.Data.percistence.table;


public class CartTable implements Table {
    public static final String TABLE = "cart";

    @Override
    public String sqlCreateTable() {
        return String.format(CREATE_TABLE_BEGIN + ");", TABLE);
    }

    @Override
    public String sqlDropTable() {
        return String.format("" + DROP_SQL, TABLE);
    }


}
