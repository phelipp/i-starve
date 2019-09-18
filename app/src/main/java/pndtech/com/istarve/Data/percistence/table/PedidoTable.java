package pndtech.com.istarve.Data.percistence.table;

public class PedidoTable implements Table {

    public final static String TABLE = "pedido";
    public final static String FK_CART = "_fk_cart";
    public final static String FK_CLIENTE="_fk_cliente";
    public final static String DATA="data_pedido";
    public final static String AMOUNT="amount";
    //private List<Item> itens;
    public final static String DESCRIPTION="description";
    public final static String MODO_PAGAMENTO="payment_model";
    @Override
    public String sqlCreateTable() {

        return String.format(CREATE_TABLE_BEGIN +",%s INTEGER,%s INTEGER,%s TEXT,%s REAL, %s TEXT, %s TEXT," +
                        "foreing key(%s) references %s(%s)," +
                        "foreing key (%s) references %s(%s);"
                ,TABLE,FK_CART,FK_CLIENTE,DATA,AMOUNT,DESCRIPTION,MODO_PAGAMENTO,FK_CART,CartTable.TABLE,ID,ClienteTable.NAME,ID);
    }
    @Override
    public String sqlDropTable() {
        return String.format(""+DROP_SQL,TABLE);
    }
}
