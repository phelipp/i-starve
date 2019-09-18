package pndtech.com.istarve.Data.percistence;

import android.content.ContentValues;
import android.database.Cursor;

import java.io.Serializable;
import java.util.List;

import pndtech.com.istarve.Data.percistence.table.ProdutoTable;

public interface ObjectPercistence <E extends ObjectPercistence> extends Serializable {
     ContentValues toContentValues() ;
     List< E> getCursorToObject(Cursor cursor);
}
