package rishabhbhandari.com.handy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rishabhbhandari on 2016-01-20.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Notes.db";
    public static final String TABLE_NAME = "note_table";
    public static final String COL_1 = "ID";
    //public static final String COL_2="time";
    public static final String COL_2 = "name";
    public static final String COL_3 = "label";
    public static final String COL_4 = "notes";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,LABEL TEXT,NOTES TEXT)");//executes whatever query is passed method as an arg
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String label,String notes)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, label);
        contentValues.put(COL_4, notes);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;


    }
    public Cursor getAllData() // cursor = This interface provides random read-write access to the result set returned by a database query.
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from " + TABLE_NAME,null);
        return res;


    }

    /**
     * Created by rishabhbhandari on 2016-02-17.
     */
}