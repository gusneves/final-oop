import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.Statement;

public class DatabaseManager {
    private static Connection connection;

    private static void connect() {
        String url = "jdbc:sqlite:database.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void close() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    /*
     * private void insert(String sql) {
     * connect();
     * try {
     * Statement statement = connection.createStatement();
     * statement.execute(sql);
     * } catch (SQLException e) {
     * System.out.println(e.getMessage());
     * } finally {
     * close();
     * }
     * }
     * 
     * private ResultSet select(PreparedStatement stmt) {
     * connect();
     * ResultSet resultSet = null;
     * try {
     * resultSet = stmt.executeQuery();
     * close();
     * return resultSet;
     * } catch (Exception e) {
     * System.out.println(e.getMessage());
     * }
     * return resultSet;
     * }
     */

    // GENRE
    public static void AddGenre(String name) {
        connect();
        String sql = "INSERT INTO genres(name) VALUES (?)";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    // ARTIST
    public static void AddArtist(String name) {
        connect();
        String sql = "INSERT INTO artists(name) VALUES (?)";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    // ALBUM
    public static void AddAlbum(String title, int artistId) {
        connect();
        String sql = "INSERT INTO albums(title, artist_id) VALUES (?, ?)";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, artistId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    // TRACK
    public static void AddTrack(String name, int album_id, int duration) {
        connect();
        String sql = "INSERT INTO tracks(name, album_id, duration) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, album_id);
            preparedStatement.setInt(3, duration);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        close();
    }
}
