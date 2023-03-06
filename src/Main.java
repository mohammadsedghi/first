import java.sql.*;

public class Main {
    static final String DB_URL = "jdbc:postgresql://localhost/test";;
    static final String USER = "postgres";
    static final String PASS = "12345";
    static final String QUERY = "select * from test.person as p where name='ali'";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", First: " + rs.getString("name"));
                System.out.println(", Last: " + rs.getString("family"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}