package sk.filiptvrdon;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "test.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:/Users/Filip/Documents/SQLite/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = connection.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + " (" +
                    COLUMN_NAME + " text, " +
                    COLUMN_PHONE + " integer, " +
                    COLUMN_EMAIL + " text" +
                    ")");

            insertContact("Filip", "123456789", "filip@email.com");
            insertContact("John", "87652442424", "john@email.com");
            insertContact("Jane", "8765672424", "jane@email.com");

            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while (results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void insertContact(String name, String phone, String email) throws SQLException {
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + ", " +
                    COLUMN_PHONE + ", " +
                    COLUMN_EMAIL + ")" +
                    "VALUES ('" + name + "', " + phone + ", '" + email + "')");
        }
    }


}