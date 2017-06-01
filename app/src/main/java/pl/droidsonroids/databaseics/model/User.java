package pl.droidsonroids.databaseics.model;

import com.orm.SugarRecord;

public class User extends SugarRecord<User> {
    public String login;
    public String name;
    public String lastname;

    public User(){}

    public User(final String login, final String name, final String lastname) {
        this.login = login;
        this.name = name;
        this.lastname = lastname;
    }
}
