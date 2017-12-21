import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

    private Connection connection;


    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            System.out.println("Error accessing mySQL");
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            String queryString = "SELECT * FROM ads";
            ResultSet rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                Ad ad = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );

                ads.add(ad);
            }
            return ads;

        } catch (SQLException e) {
            System.out.println("error while retrieving ads");
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        try {
//            String title = ad.getTitle();
//            String description = ad.getDescription();
//            System.out.println(title + description);
//            String query = "INSERT INTO ads(user_id, title, description) VALUE (""'"1'," + title + ", " + description + ")";
//            System.out.println(query);

            Statement stmt = connection.createStatement();

            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            return rs.getLong(1);
        } catch (SQLException e) {
            System.out.println("problem");
//            throw new RuntimeException("error with insert method");
        }
        return null;
    }

    private String createInsertQuery(Ad ad) {
        return "INSERT INTO ads(user_id, title, description) VALUES "
                + "(" + ad.getUserId() + ", "
                + "'" + ad.getTitle() +"', "
                + "'" + ad.getDescription() + "')";
    }
}
