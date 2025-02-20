import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) {
        // MySQL Connection Details
        String url = "jdbc:mysql://localhost:3306/mydb"; // Change 'testdb' if using another database
        String user = "root"; // Change if using another user
        String password = "Rudasingw@76"; // Replace with your MySQL password

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connection Successful!");

            // Create a Statement
            Statement stmt = conn.createStatement();

            // Execute a Query
            String sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            // Print Query Results
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("age"));
            }

            // Close Resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL JDBC Driver Not Found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database Connection Error!");
            e.printStackTrace();
        }
    }
}
