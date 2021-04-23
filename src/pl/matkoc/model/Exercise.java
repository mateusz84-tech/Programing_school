package pl.matkoc.model;

public class Exercise {

    private int id;
    private String title;
    private String description;

    public Exercise() {};

    public Exercise(String title, String description) {
        if(title.isEmpty() || title.isBlank()){
            throw new IllegalArgumentException("Tytuł nie może być pusty.");
        }
        if(description.isBlank() || description.isEmpty()){
            throw new IllegalArgumentException("Opis nie może być pusty.");
        }
        this.title = title;
        this.description = description;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.isEmpty() || title.isBlank()){
            throw new IllegalArgumentException("Tytuł nie może być pusty.");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.isBlank() || description.isEmpty()){
            throw new IllegalArgumentException("Opis nie może być pusty.");
        }
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s",getId(),getTitle(),getDescription());
    }
}
