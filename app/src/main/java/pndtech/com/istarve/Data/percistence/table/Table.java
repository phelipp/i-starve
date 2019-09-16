package pndtech.com.istarve.Data.percistence.table;

import pndtech.com.istarve.Data.percistence.ObjectPercistence;

public interface Table<E extends ObjectPercistence> {
    /**
     * Contem emseu valor todo o codigo ate a construção do ID so deve informar o nomeda tabela por meio de um String format
     */
    public final static String CREATE_TABLE_BEGIN = "CREATE TABLE %s( _id integer primary key autoincrement";
    public final static String DROP_SQL = "DROP TABLE IF EXISTS %s;";
    public final static String ID = "_id";

    String sqlCreateTable();

    String sqlDropTable();


}
