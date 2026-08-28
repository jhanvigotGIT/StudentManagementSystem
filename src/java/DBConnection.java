import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException {

        String host = System.getenv("DB_HOST");
        String port = System.getenv("DB_PORT");
        String database = System.getenv("DB_NAME");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        
          
                    System.out.println("DB HOST = " + host);
System.out.println("DB PORT = " + port);
System.out.println("DB NAME = " + database);
System.out.println("DB USER = " + user);


        String url = "jdbc:mysql://" + host + ":" + port + "/" + database
                + "?sslMode=REQUIRED";

        return DriverManager.getConnection(url, user, password);
    }
}
