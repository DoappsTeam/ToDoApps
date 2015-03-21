package me.doapps.todoapps.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jonathan on 21/03/2015.
 */
public class DataBaseManager {
    private static final String TABLE_VERB = "verb";
    private static final String TABLE_OBJECT = "object";
    private static final String TABLE_TASK = "task";

    private static final String ID = "_id";
    private static final String VERD_ID = "verbId";
    private static final String OBJECT_ID = "objectId";

    private static final String NAME = "name";
    private static final String RATE = "rate";
    private static final String DUEDATE = "duedate";
    private static final String CREATED = "created";
    private static final String UPDATED = "updated";
    private static final String STATE = "state";

    public static final String CREATE_TABLE_VERB = "create table " + TABLE_VERB + " ("
            + ID + " integer primary key autoincrement,"
            + NAME + " text not null,"
            + RATE + " integer,"
            + CREATED + " text,"
            + UPDATED + " text,"
            + STATE + " integer);";
    public static final String CREATE_TABLE_OBJECT = "create table " + TABLE_OBJECT + " ("
            + ID + " integer primary key autoincrement,"
            + NAME + " text not null,"
            + RATE + " integer,"
            + CREATED + " text,"
            + UPDATED + " text,"
            + STATE + " integer);";
    public static final String CREATE_TABLE_TASK = "create table " + TABLE_OBJECT + " ("
            + ID + " integer primary key autoincrement,"
            + NAME + " text not null,"
            + RATE + " integer,"
            + DUEDATE + " text,"
            + CREATED + " text,"
            + UPDATED + " text,"
            + STATE + " integer,"
            + VERD_ID + " integer,"
            + OBJECT_ID + " integer);";

    public static final String DROP_TABLE_VERB = "drop table if exist " + TABLE_VERB;
    public static final String DROP_TABLE_OBJECT = "drop table if exist "+ TABLE_OBJECT;
    public static final String DROP_TABLE_TASK = "drop table if exist "+ TABLE_TASK;

    private DataBaseHelper helper;
    private SQLiteDatabase db;

    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat formater_simple = new SimpleDateFormat("dd/MM/yyyy");
    Calendar calendar = Calendar.getInstance();

    public DataBaseManager(Context context){
        helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
    }
}
