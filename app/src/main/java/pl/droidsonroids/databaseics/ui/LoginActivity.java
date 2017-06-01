package pl.droidsonroids.databaseics.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pl.droidsonroids.databaseics.model.preferences.DataPreferences;
import pl.droidsonroids.databaseics.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editLogin;
    private EditText editPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
        setListeners();
    }

    private void findViews() {
        editLogin = (EditText) findViewById(R.id.edit_login);
        editPassword = (EditText) findViewById(R.id.edit_password);
        buttonLogin = (Button) findViewById(R.id.button_login);
    }

    private void setListeners() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                saveCredentialsToPrefs();
                goToMainScreen();
            }
        });
    }

    private void saveCredentialsToPrefs() {
        DataPreferences.getInstance().saveLogin(editLogin.getText().toString());
    }

    private void goToMainScreen() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
}
