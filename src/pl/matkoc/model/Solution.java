package pl.matkoc.model;

import java.time.LocalDateTime;

public class Solution {

    private int id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String description;
    private int exercise_id;
    private int user_id;

    public Solution() {};

    public Solution(LocalDateTime created, LocalDateTime updated, String description, int exercise_id, int user_id) {
        if(created == null){
            throw new NullPointerException("Data utworzenia nie może być pusta.");
        }
        if(updated == null){
            throw new NullPointerException("Data edycji nie może być pusta.");
        }
        if(description.isEmpty() || description.isBlank()){
            throw new IllegalArgumentException("Opis nie może być pusty.");
        }
        if(exercise_id < 0){
            throw new IllegalArgumentException("Id nie może być puste.");
        }
        if(user_id < 0){
            throw new IllegalArgumentException("Id nie może być puste.");
        }
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.exercise_id = exercise_id;
        this.user_id = user_id;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        if(created == null){
            throw new NullPointerException("Data nie może być pusta.");
        }
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
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

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        if(exercise_id < 0){
            throw new IllegalArgumentException("Id nie może być mniejsze od zera.");
        }
        this.exercise_id = exercise_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        if(user_id < 0){
            throw new IllegalArgumentException("Id nie może być mniejsze od zera.");
        }
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return String.format("%d %tB %tB %s %s: %d %s: %d"
                ,getId(),getCreated(),getUpdated(),getDescription()
                ,"Id ćwiczenia",getExercise_id(),"Id użytkownika",getUser_id());
    }
}
