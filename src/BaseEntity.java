

public abstract class BaseEntity { // classe Abstrata
    protected int id;

    public BaseEntity(int id) {
        this.id = id;
    }

    public BaseEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public abstract String toString();
}
