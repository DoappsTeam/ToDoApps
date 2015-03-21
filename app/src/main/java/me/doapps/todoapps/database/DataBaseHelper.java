package me.doapps.todoapps.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jonathan on 21/03/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "todoapps.sqlite";
    private static final int DB_VERSION = 1;

    public DataBaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManager.CREATE_TABLE_VERB);
        db.execSQL(DataBaseManager.CREATE_TABLE_OBJECT);
        db.execSQL(DataBaseManager.CREATE_TABLE_TASK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DataBaseManager.DROP_TABLE_VERB);
        db.execSQL(DataBaseManager.DROP_TABLE_OBJECT);
        db.execSQL(DataBaseManager.DROP_TABLE_TASK);
        onCreate(db);
    }
}
