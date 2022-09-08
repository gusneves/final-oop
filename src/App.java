import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Genre> genres = DatabaseManager.GetAllGenres();

        for (Genre genre : genres) {
            System.out.println(genre.toString());
        }
    }
}
