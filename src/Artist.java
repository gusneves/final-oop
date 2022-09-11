public class Artist extends BaseEntity {
    private String name;

    public Artist() {
    }

    public Artist(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " ID: " + id + " - Nome: " + name;
    }
}
