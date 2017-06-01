package pl.droidsonroids.databaseics;

import com.facebook.stetho.Stetho;
import com.orm.SugarApp;

public class DataApplication extends SugarApp {

    private static DataApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        Stetho.initializeWithDefaults(this);
    }

    public static DataApplication getInstance() {
        return instance;
    }
}
