package pl.droidsonroids.databaseics.model.preferences;

import android.content.SharedPreferences;

import pl.droidsonroids.databaseics.DataApplication;

import static android.content.Context.MODE_PRIVATE;

public class DataPreferences {

    private static final String PACKAGE_NAME = DataPreferences.class.getPackage().getName();
    private static final String APPLICATION_PREFERENCES = PACKAGE_NAME + ".DataBaseicsPreferences";
    private static DataPreferences instance;

    private final String PREFS_LOGIN = "login";

    private SharedPreferences sharedPreferences;

    private DataPreferences() {
        sharedPreferences =
                DataApplication.getInstance().getSharedPreferences(APPLICATION_PREFERENCES, MODE_PRIVATE);
    }

    public static DataPreferences getInstance() {
        if (instance == null) {
            instance = new DataPreferences();
        }

        return instance;
    }

    public void saveLogin(final String login) {
        sharedPreferences.edit().putString(PREFS_LOGIN, login).apply();
    }

    public String getLogin() {
        return sharedPreferences.getString(PREFS_LOGIN, null);
    }
}
