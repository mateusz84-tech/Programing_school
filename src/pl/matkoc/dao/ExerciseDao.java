package pl.matkoc.dao;

public class ExerciseDao {

    private final String CREATE_EXERCISE_QUERY =
            "INSERT INTO exercise(title, description) VALUES(?,?)";
    private final String READ_EXERCISE_QUERY =
            "SELECT * FROM exercise WHERE id = ?";
    private final String UPDATE_EXERCISE_QUERY =
            "UPDATE exercise SET title = ?, description = ? WHERE id = ?";
    private final String DELETE_EXERCISE_QUERY =
            "DELETE FROM exercise WHERE id = ?";
    private final String GET_ALL_EXERCISE =
            "SELECT * FORM exercise";
}
