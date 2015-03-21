package me.doapps.todoapps.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
    private static final String VERB_ID = "verbId";
    private static final String OBJECT_ID = "objectId";
    private static final String VERB_NAME = "verbName";
    private static final String OBJECT_NAME = "objectName";

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
    public static final String CREATE_TABLE_TASK = "create table " + TABLE_TASK + " ("
            + ID + " integer primary key autoincrement,"
            + NAME + " text not null,"
            + RATE + " integer,"
            + DUEDATE + " text,"
            + CREATED + " text,"
            + UPDATED + " text,"
            + STATE + " integer,"
            + VERB_ID + " integer,"
            + OBJECT_ID + " integer,"
            + VERB_NAME + " text,"
            + OBJECT_NAME + " text);";

    public static final String DROP_TABLE_VERB = "drop table if exist " + TABLE_VERB;
    public static final String DROP_TABLE_OBJECT = "drop table if exist " + TABLE_OBJECT;
    public static final String DROP_TABLE_TASK = "drop table if exist " + TABLE_TASK;

    private DataBaseHelper helper;
    private SQLiteDatabase db;

    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat formater_simple = new SimpleDateFormat("dd/MM/yyyy");
    Calendar calendar = Calendar.getInstance();

    public DataBaseManager(Context context) {
        helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public boolean insertVerb(String name, int rate, int state) {
        try {
            String created_at = formater.format(calendar.getTime());
            String updated_at = formater.format(calendar.getTime());

            ContentValues contentValues = new ContentValues();
            contentValues.put(NAME, name);
            contentValues.put(RATE, rate);
            contentValues.put(CREATED, created_at);
            contentValues.put(UPDATED, updated_at);
            contentValues.put(STATE, state);
            if (db.insert(TABLE_VERB, null, contentValues) != -1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.e("DBM", "insertVerb " + e.toString());
            return false;
        }
    }

    public boolean insertObject(String name, int rate, int state) {
        try {
            String created_at = formater.format(calendar.getTime());
            String updated_at = formater.format(calendar.getTime());

            ContentValues contentValues = new ContentValues();
            contentValues.put(NAME, name);
            contentValues.put(RATE, rate);
            contentValues.put(CREATED, created_at);
            contentValues.put(UPDATED, updated_at);
            contentValues.put(STATE, state);
            if (db.insert(TABLE_OBJECT, null, contentValues) != -1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.e("DBM", "insertObject " + e.toString());
            return false;
        }
    }

    public boolean insertTask(String name, int rate, String duedate, int state, int verbId, int objectId) {
        try {
            String created_at = formater.format(calendar.getTime());
            String updated_at = formater.format(calendar.getTime());

            ContentValues contentValues = new ContentValues();
            contentValues.put(NAME, name);
            contentValues.put(RATE, rate);
            contentValues.put(DUEDATE, duedate);
            contentValues.put(CREATED, created_at);
            contentValues.put(UPDATED, updated_at);
            contentValues.put(STATE, state);
            contentValues.put(VERB_ID, verbId);
            contentValues.put(OBJECT_ID, objectId);
            if (db.insert(TABLE_TASK, null, contentValues) != -1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.e("DBM", "insertObject " + e.toString());
            return false;
        }
    }

    public Cursor selectVerbs() {
        try {
            Cursor c = db.rawQuery("SELECT " + NAME + " FROM " + TABLE_VERB + " WHERE " + STATE + " =1 ORDER BY 1 DESC", null);
            return c;
        } catch (Exception e) {
            Log.e("ERROR DBM - selectPublicity", e.toString());
            return null;
        }
    }

    public Cursor selectObjects() {
        try {
            Cursor c = db.rawQuery("SELECT " + NAME + " FROM " + TABLE_OBJECT + " WHERE " + STATE + " =1 ORDER BY 1 DESC", null);
            return c;
        } catch (Exception e) {
            Log.e("ERROR DBM - selectPublicity", e.toString());
            return null;
        }
    }

    /*generate ContentValues*/
    private ContentValues contentValuesTask(String name, int rate, String duedate, String created, String updated, int state, int verbId, int objectId, String verbname, String objectName) {
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(RATE, rate);
        values.put(DUEDATE, duedate);
        values.put(CREATED, created);
        values.put(UPDATED, updated);
        values.put(STATE, state);
        values.put(VERB_ID, verbId);
        values.put(OBJECT_ID, objectId);
        values.put(VERB_NAME, verbname);
        values.put(OBJECT_NAME, objectName);
        return values;
    }

    public Cursor selectTask() {
        String[] columns = new String[]{ID, NAME, VERB_NAME, OBJECT_NAME, DUEDATE, STATE};
        return db.query(TABLE_TASK, columns, STATE + "=?", new String[]{"1"}, null, null, null);
    }

    public Cursor selectTaskByState() {
        String[] args = new String[]{"1", "2"};
        Cursor c = db.rawQuery(" SELECT * FROM task WHERE state=? ", args);
        return c;
    }

    public void insertTask(String name) {
        String created_at = formater.format(calendar.getTime());
        String updated_at = formater.format(calendar.getTime());
        db.insert(TABLE_TASK, null, contentValuesTask(name, 0, created_at, created_at, updated_at, 1, 1, 1, "Barrer", "Sala"));
    }

    public void updateTask(String id, String state) {
        ContentValues values = new ContentValues();
        values.put(STATE, state);
        db.update(TABLE_TASK, values, ID + "=?", new String[]{id});
    }
}
