import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLAdsDao {

    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException{
        this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );
    }
}
