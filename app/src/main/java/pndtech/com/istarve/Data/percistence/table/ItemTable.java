package pndtech.com.istarve.Data.percistence.table;

public class ItemTable implements Table {

    public final static String TABLE = "item";
    public final static String FK_PRODUTO="_fk_produto";
    public final static String FK_PEDIDO="_fk_pedido";
    public final static String AMOUNT="amount";

    @Override
    public String sqlCreateTable() {

        return String.format(CREATE_TABLE_BEGIN +",%s INTEGER, %s INTEGER,%s REAL" +
                "foreing key (%s) references %s(%s)," +
                "foreing key (%s) references %s(%s) );",TABLE,FK_PRODUTO,FK_PEDIDO,AMOUNT,
                FK_PEDIDO,PedidoTable.TABLE,ID,
                FK_PRODUTO,ProdutoTable.TABLE,ID);

    }
    @Override
    public String sqlDropTable() {
        return String.format(""+DROP_SQL,TABLE);
    }
}
