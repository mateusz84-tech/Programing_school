package pl.matkoc.dao;

import pl.matkoc.connection.DBUtil;
import pl.matkoc.model.Exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public Exercise create(Exercise exercise){
        try(Connection connection = DBUtil.getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_EXERCISE_QUERY,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, exercise.getTitle());
            statement.setString(2,exercise.getDescription());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while(resultSet.next()){
                exercise.setId(resultSet.getInt(1));
            }
            return exercise;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }
}
