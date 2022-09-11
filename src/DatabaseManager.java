import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    private static void executeUpdate(PreparedStatement preparedStatement) throws NotFoundIdException, SQLException {
        int nrows = preparedStatement.executeUpdate();

        if (nrows == 0) {
            throw new NotFoundIdException("ID informado não encontrado");
        }
    }

    private static ResultSet executeQuery(PreparedStatement preparedStatement)
            throws NotFoundIdException, SQLException {
        ResultSet rs = preparedStatement.executeQuery();
        if (!rs.next()) {
            throw new NotFoundIdException("ID informado não encontrado");
        } else {
            return rs;
        }
    }

    // GENRE
    public static void AddGenre(String name) {
        connect();
        String sql = "INSERT INTO genres(name) VALUES (?)";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static void UpdateGenre(int id, String name) {
        connect();
        String sql = "UPDATE genres SET name=? WHERE id=?";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            executeUpdate(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static int DeleteGenre(int id) {
        connect();
        String sql = "DELETE FROM genres WHERE id=?";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setInt(1, id);
            executeUpdate(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        close();
        return 1;
    }

    public static ArrayList<Genre> GetAllGenres() {
        connect();
        String sql = "SELECT id, name FROM genres";
        ArrayList<Genre> genres = new ArrayList<Genre>();
        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                genres.add(new Genre(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
        return genres;
    }

    public static Genre GetGenreById(int id) {
        connect();
        String sql = "SELECT name FROM genres WHERE id=?";
        Genre genre = new Genre();
        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = executeQuery(preparedStatement);
            do {
                genre.setId(id);
                genre.setName(resultSet.getString("name"));
            } while (resultSet.next());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
        return genre;
    }

    // ARTIST
    public static void AddArtist(String name) {
        connect();
        String sql = "INSERT INTO artists(name) VALUES (?)";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static void UpdateArtist(int id, String name) {
        connect();
        String sql = "UPDATE artists SET name=? WHERE id=?";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            executeUpdate(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static void DeleteArtist(int id) {
        connect();
        String sql = "DELETE FROM artists WHERE id=?";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setInt(1, id);
            executeUpdate(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static ArrayList<Artist> GetAllArtists() {
        connect();
        String sql = "SELECT id, name FROM artists";
        ArrayList<Artist> artists = new ArrayList<Artist>();
        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                artists.add(new Artist(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
        return artists;
    }

    public static Artist GetArtistById(int id) {
        connect();
        String sql = "SELECT name FROM artists WHERE id=?";
        Artist artist = new Artist();
        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = executeQuery(preparedStatement);
            do {
                artist.setId(id);
                artist.setName(resultSet.getString("name"));
            } while (resultSet.next());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
        return artist;
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static void UpdateAlbum(int id, String title, int artist_id) {
        connect();
        String sql = "UPDATE albums SET title=?, artist_id=? WHERE id=?";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, artist_id);
            preparedStatement.setInt(3, id);
            executeUpdate(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static void DeleteAlbum(int id) {
        connect();
        String sql = "DELETE FROM albums WHERE id=?";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setInt(1, id);
            executeUpdate(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static ArrayList<Album> GetAllAlbums() {
        connect();
        String sql = "SELECT id, title, artist_id FROM albums";
        ArrayList<Album> albums = new ArrayList<Album>();
        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                albums.add(
                        new Album(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getInt("artist_id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
        return albums;
    }

    public static Album GetAlbumById(int id) {
        connect();
        String sql = "SELECT title, artist_id FROM albums WHERE id=?";
        Album album = new Album();
        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = executeQuery(preparedStatement);
            do {
                album.setId(id);
                album.setTitle(resultSet.getString("title"));
                album.setArtistId(resultSet.getInt("artist_id"));
            } while (resultSet.next());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
        return album;
    }

    // TRACK
    public static void AddTrack(String name, int albumId, int genreId, int duration) {
        connect();
        String sql = "INSERT INTO tracks(name, album_id, genre_id, duration) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, albumId);
            preparedStatement.setInt(3, genreId);
            preparedStatement.setInt(4, duration);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static void UpdateTrack(int id, String name, int albumId, int genreId, int duration) {
        connect();
        String sql = "UPDATE tracks SET name=?, duration=?, album_id=?, genre_id=? WHERE id=?";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, duration);
            preparedStatement.setInt(3, albumId);
            preparedStatement.setInt(4, genreId);
            preparedStatement.setInt(5, id);
            executeUpdate(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static void DeleteTrack(int id) {
        connect();
        String sql = "DELETE FROM tracks WHERE id=?";

        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setInt(1, id);
            executeUpdate(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
    }

    public static ArrayList<Track> GetAllTracks() {
        connect();
        String sql = "SELECT id, name, album_id, genre_id, duration FROM tracks";
        ArrayList<Track> tracks = new ArrayList<Track>();
        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tracks.add(
                        new Track(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("album_id"),
                                resultSet.getInt("genre_id"),
                                resultSet.getInt("duration")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        close();
        return tracks;
    }

    public static Track GetTrackById(int id) {
        connect();
        String sql = "SELECT id, name, album_id, genre_id duration FROM tracks WHERE id=?";
        Track track = new Track();
        try {
            PreparedStatement preparedStatement = prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = executeQuery(preparedStatement);
            do {
                track.setId(id);
                track.setName(resultSet.getString("name"));
                track.setAlbumId(resultSet.getInt("album_id"));
                track.setGenreId(resultSet.getInt("genre_id"));
                track.setDuration(resultSet.getInt("duration"));
            } while (resultSet.next());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NotFoundIdException e) {
            System.out.println(e.getMessage());
        }
        close();
        return track;
    }
}
