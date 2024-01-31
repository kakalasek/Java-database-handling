import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try{
            Properties prop = new Properties();

            FileInputStream ip = new FileInputStream("src/main/resources/config.properties");

            prop.load(ip);

            DatabaseConnection connection = DatabaseConnection.CreateConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));

            Connection conn = connection.Connect();

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException("Houston, our SQL is F*cked up!\n" + e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Houston, there aint no damn file like that!\n" + e);
        } catch (IOException e) {
            throw new RuntimeException("Houston, the file is in some stupid ass format!" + e);
        }
    }
}


