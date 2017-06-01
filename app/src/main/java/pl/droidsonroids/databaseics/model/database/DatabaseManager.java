package pl.droidsonroids.databaseics.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DataBaseisc.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_USER_TABLE =
            "create table user ("
                    + "login text primary key,"
                    + "name text,"
                    + "lastname text"
                    + ");";

    private static final String DELETE_USER_TABLE =
            "drop table if exists user;";

    DatabaseManager(final Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        db.execSQL(DELETE_USER_TABLE);
        onCreate(db);
    }
}
