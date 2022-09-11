public class Album extends BaseEntity {
    private String title;
    private int artistId;

    public Album() {
    }

    public Album(int id, String title, int artistId) {
        super(id);
        this.title = title;
        this.artistId = artistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return " ID: " + id + " - Título: " + title + " - ID do artista: " + artistId;
    }
}
