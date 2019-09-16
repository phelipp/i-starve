package pndtech.com.istarve.Data.percistence.table;

public class PedidoTable implements Table {

    public final static String TABLE = "pedido";
    public final static String ID_CART = "_id_cart";
    public final static String ID_CLIENTE="_id_cliente";
    public final static String DATA="data_pedido";
    public final static String AMOUNT="amount";
    //private List<Item> itens;
    public final static String DESCRIPTION="description";
    public final static String MODO_PAGAMENTO="payment_model";
    @Override
    public String sqlCreateTable() {

        return String.format(CREATE_TABLE_BEGIN +",%s INTEGER,%s INTEGER,%s TEXT,%s REAL, %s TEXT, %s TEXT);",TABLE,ID_CART,ID_CLIENTE,DATA,AMOUNT,DESCRIPTION,MODO_PAGAMENTO);
    }
    @Override
    public String sqlDropTable() {
        return String.format(""+DROP_SQL,TABLE);
    }
}
