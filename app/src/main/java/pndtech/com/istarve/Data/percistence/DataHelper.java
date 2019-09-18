package pndtech.com.istarve.Data.percistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import pndtech.com.istarve.Data.percistence.table.AddressTable;
import pndtech.com.istarve.Data.percistence.table.CartTable;
import pndtech.com.istarve.Data.percistence.table.ClienteTable;
import pndtech.com.istarve.Data.percistence.table.ItemTable;
import pndtech.com.istarve.Data.percistence.table.PedidoTable;
import pndtech.com.istarve.Data.percistence.table.PhoneTable;
import pndtech.com.istarve.Data.percistence.table.ProdutoTable;
import pndtech.com.istarve.Data.percistence.table.StateTable;
import pndtech.com.istarve.Data.percistence.table.Table;

public class DataHelper extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "banco.db";
    public static final int VERSAO = 1;
    public  static Table tableCart,
            tablePedido,
            tablePhone,
            tableState,
            tableAddress,
            tableItem,
            tableCliente,
            tableProduto;
    private StringBuffer sql = new StringBuffer();
    private StringBuffer sqlDrop = new StringBuffer();

    public DataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        tableCart = new CartTable();
        tablePedido = new PedidoTable();
        tablePhone = new PhoneTable();
        tableState = new StateTable();
        tableAddress = new AddressTable();
        tableCliente = new ClienteTable();
        tableItem = new ItemTable();
        tableProduto = new ProdutoTable();


        sql.append(tablePhone.sqlCreateTable());
        sql.append(tableState.sqlCreateTable());
        sql.append(tableAddress.sqlCreateTable());
        sql.append(tableProduto.sqlCreateTable());
        sql.append(tableItem.sqlCreateTable());
        sql.append(tableCliente.sqlCreateTable());
        sql.append(tablePedido.sqlCreateTable());
        sql.append(tableCart.sqlCreateTable());


        sqlDrop.append(tableAddress.sqlDropTable());
        sqlDrop.append(tablePhone.sqlDropTable());
        sqlDrop.append(tableAddress.sqlDropTable());
        sqlDrop.append(tableProduto.sqlDropTable());
        sqlDrop.append(tableItem.sqlDropTable());
        sqlDrop.append(tableCliente.sqlDropTable());
        sqlDrop.append(tablePedido.sqlDropTable());
        sqlDrop.append(tableCart.sqlDropTable());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(sqlDrop.toString());
        onCreate(sqLiteDatabase);
    }
}
