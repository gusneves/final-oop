public class Track extends BaseEntity {
    private String name;
    private int albumId;
    private int genreId;

    private int duration;

    public Track() {
    }

    public Track(int id, String name, int albumId, int duration) {
        super(id);
        this.name = name;
        this.albumId = albumId;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "Track [id=" + id + ", name=" + name + ", albumId=" + albumId + ", duration=" + duration + "]";
    }
}
