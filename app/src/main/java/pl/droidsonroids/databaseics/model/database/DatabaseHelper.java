package pl.droidsonroids.databaseics.model.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import pl.droidsonroids.databaseics.DataApplication;
import pl.droidsonroids.databaseics.model.User;

class DatabaseHelper {

    private static DatabaseHelper instance;
    private final DatabaseManager databaseManager;

    private DatabaseHelper() {
        databaseManager = new DatabaseManager(DataApplication.getInstance());
    }

    public static DatabaseHelper getInstance() {
        if (instance == null) {
            instance = new DatabaseHelper();
        }

        return instance;
    }

    public void saveUser(final User user) {
        final SQLiteDatabase writableDatabase = databaseManager.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Database.Columns.LOGIN, user.login);
        values.put(Database.Columns.NAME, user.name);
        values.put(Database.Columns.LASTNAME, user.lastname);

        writableDatabase.insert(Database.Tables.USER, null, values);

        writableDatabase.close();
    }
}
