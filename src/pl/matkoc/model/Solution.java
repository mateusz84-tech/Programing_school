package pl.matkoc.model;

import java.time.LocalDate;

public class Solution {

    private int id;
    private LocalDate created;
    private LocalDate updated;
    private String description;
    private int exercise_id;
    private int user_id;

    public Solution() {};

    public Solution(LocalDate created, LocalDate updated, String description, int exercise_id, int user_id) {
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
            throw new NullPointerException("Wartość nie może być mniejsza od zera.");
        }
        if(user_id < 0){
            throw new NullPointerException("Wartość nie może być mniejsza od zera.");
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

    public int getExerciseId() {
        return exercise_id;
    }

    public void setExerciseId(int exerciseId) {
        if(exerciseId < 0){
            throw new NullPointerException("Wartość nie może być mniejsza od zera.");
        }
        this.exercise_id = exerciseId;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        if(userId < 0){
            throw new NullPointerException("Wartość nie może być mniejsza od zera.");
        }
        this.user_id = userId;
    }

    @Override
    public String toString() {
        return String.format("%d %tB %tB %s%n%s: %s%n%s %s"
                ,getId(),getCreated(),getUpdated(),getDescription(),
                "Użytkownik nr",getUserId(),"Ćwiczenie nr",getExerciseId());
    }
}
