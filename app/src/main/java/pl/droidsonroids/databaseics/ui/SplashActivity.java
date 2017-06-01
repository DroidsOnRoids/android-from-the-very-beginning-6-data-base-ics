package pl.droidsonroids.databaseics.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pl.droidsonroids.databaseics.model.preferences.DataPreferences;
import pl.droidsonroids.databaseics.R;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DELAY_MILLIS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (DataPreferences.getInstance().getLogin() == null) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                finish();
            }
        }, SPLASH_DELAY_MILLIS);
    }
}
