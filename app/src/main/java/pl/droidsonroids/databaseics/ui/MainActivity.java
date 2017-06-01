package pl.droidsonroids.databaseics.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pl.droidsonroids.databaseics.R;
import pl.droidsonroids.databaseics.model.preferences.DataPreferences;
import pl.droidsonroids.databaseics.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView textLogin;
    private EditText editName;
    private EditText editLastname;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        showLogin();
        setListeners();
    }

    private void findViews() {
        textLogin = (TextView) findViewById(R.id.text_login);
        editName = (EditText) findViewById(R.id.edit_name);
        editLastname = (EditText) findViewById(R.id.edit_lastname);
        buttonSave = (Button) findViewById(R.id.button_save);
    }

    private void showLogin() {
        final String login = DataPreferences.getInstance().getLogin();
        textLogin.setText(login);
    }

    private void setListeners() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                User user = new User(
                        textLogin.getText().toString(),
                        editName.getText().toString(),
                        editLastname.getText().toString());

                new SaveUserTask().execute(user);
            }
        });
    }

    private class SaveUserTask extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(final User... params) {
            final User user = params[0];
            user.save();
//            DatabaseHelper.getInstance().saveUser(user);
            return null;
        }
    }
}
