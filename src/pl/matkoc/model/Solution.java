package pl.matkoc.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Solution {

    private int id;
    private LocalDate created;
    private LocalDate updated;
    private String description;
    private Exercise exercise;
    private User user;

    public Solution() {};

    public Solution(LocalDate created, LocalDate updated, String description, Exercise exercise, User user) {
        if(created == null){
            throw new NullPointerException("Data utworzenia nie może być pusta.");
        }
        if(updated == null){
            throw new NullPointerException("Data edycji nie może być pusta.");
        }
        if(description.isEmpty() || description.isBlank()){
            throw new IllegalArgumentException("Opis nie może być pusty.");
        }
        if(exercise == null){
            throw new NullPointerException("Wartość nie może być pusta.");
        }
        if(user == null){
            throw new NullPointerException("Wartość nie może być pusta.");
        }
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.exercise = exercise;
        this.user = user;
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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        if(created == null){
            throw new NullPointerException("Data nie może być pusta.");
        }
        this.created = created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        if(updated == null){
            throw new NullPointerException("Data nie może być pusta.");
        }
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.isBlank() || description.isEmpty()){
            throw new IllegalArgumentException("Opis nie możę być pusty.");
        }
        this.description = description;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        if(exercise == null){
            throw new NullPointerException("Wartość nie może być pusta.");
        }
        this.exercise = exercise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if(user == null){
            throw new NullPointerException("Wartość nie może być pusta.");
        }
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("%d %tB %tB %s%n%s: %s%n%s %s"
                ,getId(),getCreated(),getUpdated(),getDescription(),
                "Użytkownik",user.toString(),"Ćwiczenie",exercise.toString());
    }
}
