package pndtech.com.istarve.Data.percistence.table;

public class ProdutoTable implements Table {

    public final static String TABLE = "item";
    public final static String ID_PRODUTO="_id_produto";
    public final static String AMOUNT="amount";

    @Override
    public String sqlCreateTable() {

        return String.format(CREATE_TABLE_BEGIN +",%s INTEGER,%s REAL);",TABLE,ID_PRODUTO,AMOUNT);

    }
    @Override
    public String sqlDropTable() {
        return String.format(""+DROP_SQL,TABLE);
    }
}
