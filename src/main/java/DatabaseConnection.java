import oracle.jdbc.OracleDatabaseException;
import oracle.jdbc.driver.DatabaseError;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance = null;
    private String url;
    private String username;
    private String password;

    public static DatabaseConnection CreateConnection(String url, String username, String password){
        if(instance == null){
            instance = new DatabaseConnection(url, username, password);
        }
        return instance;
    }

     private DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection Connect() throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        if(conn == null) throw new RuntimeException("Houston, we've lost connection!");
        return conn;
    }

}
