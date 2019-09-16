package pndtech.com.istarve.Data.percistence.table;

public class ProdutoTable implements Table {

    public final static String TABLE = "produto";
    public final static String NAME = "name";
    public final static String VALUE = "value";
    public final static String DESCRIPTION = "description";
    public final static String IMAGE_URL = "image_url";

    @Override
    public String sqlCreateTable() {
        return String.format(CREATE_TABLE_BEGIN + ",%s TEXT,%s REAL, %s TEXT, %s TEXT);", TABLE, NAME, VALUE, DESCRIPTION, IMAGE_URL);
    }

    @Override
    public String sqlDropTable() {
        return String.format("" + DROP_SQL, TABLE);
    }
}
