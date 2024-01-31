import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
        DatabaseConnection connection = DatabaseConnection.CreateConnection("jdbc:oracle:thin:@localhost:1521:xepdb1", "PIPA", "pipa");

        Connection conn = connection.Connect();

        conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
   }
}


