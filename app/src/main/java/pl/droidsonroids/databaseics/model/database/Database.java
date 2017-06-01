package pl.droidsonroids.databaseics.model.database;

class Database {
    private Database() {}

    static class Tables {
        static final String USER = "user";
    }

    static class Columns {
        static final String LOGIN = "login";
        static final String NAME = "name";
        static final String LASTNAME = "lastname";
    }
}
