package sk.filiptvrdon;

import java.sql.*;

public class Main {
    public static String url = "jdbc:sqlite:C:/Users/Filip/Documents/SQLite/test.db";
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Filip', 123456789, 'tvrdon.filip@gmail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('John', 987654321, 'john@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Jane', 65765759, 'jane@email.com')");


//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();

            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while(results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}