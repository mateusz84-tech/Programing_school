package pl.matkoc.dao;

import pl.matkoc.connection.DBUtil;
import pl.matkoc.model.Exercise;
import pl.matkoc.service.CrudManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao implements CrudManager<Exercise, Integer> {

    private final String CREATE_EXERCISE_QUERY =
            "INSERT INTO exercise(title, description) VALUES(?,?)";
    private final String READ_EXERCISE_QUERY =
            "SELECT * FROM exercise WHERE id_exercise = ?";
    private final String UPDATE_EXERCISE_QUERY =
            "UPDATE exercise SET title = ?, description = ? WHERE id_exercise = ?";
    private final String DELETE_EXERCISE_QUERY =
            "DELETE FROM exercise WHERE id_exercise = ?";
    private final String GET_ALL_EXERCISE =
            "SELECT * FROM exercise";

    @Override
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
            System.out.println("Zapisano w bazie danych.");
            return exercise;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    @Override
    public Exercise read(Integer exercise_id){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(READ_EXERCISE_QUERY);
            statement.setInt(1,exercise_id);
            ResultSet resultSet = statement.executeQuery();
            Exercise exercise = new Exercise();
            while(resultSet.next()){
                exercise.setId(resultSet.getInt("id_exercise"));
                exercise.setTitle(resultSet.getString("title"));
                exercise.setDescription(resultSet.getString("description"));
            }
            return exercise;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Exercise exercise){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(UPDATE_EXERCISE_QUERY);
            statement.setString(1,exercise.getTitle());
            statement.setString(2, exercise.getDescription());
            statement.setInt(3,exercise.getId());
            statement.executeUpdate();
            System.out.println("Dane uaktualniono.");
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(DELETE_EXERCISE_QUERY);
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("Dane zostały usunięte z bazy.");
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    @Override
    public List<Exercise> findAll() {
        List<Exercise> exerciseList = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(GET_ALL_EXERCISE);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Exercise exercise = new Exercise();
                exercise.setId(resultSet.getInt("id_exercise"));
                exercise.setTitle(resultSet.getString("title"));
                exercise.setDescription(resultSet.getString("description"));

                exerciseList.add(exercise);
            }
            System.out.println("Wielkość listy: " + exerciseList.size());
            return exerciseList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }
}
