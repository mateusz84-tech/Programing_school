package pl.matkoc.model;

public class Group {

    private int id;
    private String name;

    public Group() {};

    public Group(String name) {
        if(name.isBlank() || name.isEmpty()){
            throw new IllegalArgumentException("Nazwa nie możę być pusta.");
        }
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0){
            throw new IllegalArgumentException("Id nie może być mniejsze od zera.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("Nazwa nie może być pusta");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d - %s",getId(),getName());
    }
}
