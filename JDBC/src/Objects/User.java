package Objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class User {
    private String url = "jdbc:mysql://localhost:3306/mydatabase";
    private String username = "root";
    private String password = "root1234";
    private String name;

    public User(String name){
        this.name = name;
    }

    public boolean save() {
        // SQL query to insert
        String insertSQL = "INSERT INTO users (name) VALUES ( '" + this.name + "' );";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement stmt = connection.createStatement();      // statement object
            int rowsAffected = stmt.executeUpdate(insertSQL);   // executing the statement

            // closing
            stmt.close();
            connection.close();

            if (rowsAffected > 0)  // successful insertion
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
