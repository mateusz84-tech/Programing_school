package pl.matkoc.dao;

import pl.matkoc.connection.DBUtil;
import pl.matkoc.model.Solution;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {

    private final String CREATED_SOLUTION_QUERY =
            "INSERT INTO solution(created,updated,description,exercise_id,user_id) VALUES(?,?,?,?,?)";
    private final String READ_SOLUTION_QUERY =
            "SELECT * FROM solution JOIN users ON users.id_user = solution.user_id JOIN exercise ON exercise.id_exercise = solution.exercise_id WHERE id_solution = ?";
    private final String UPDATE_SOLUTION_QUERY =
            "UPDATE solution SET created = ?, updated = ?, description = ?, exercise_id = ?, user_id = ? WHERE id_solution = ?";
    private final String DELETE_SOLUTION_QUERY =
            "DELETE FROM solution WHERE id_solution = ?";
    private final String FIND_ALL_SOLUTION_QUERY =
            "SELECT * FROM solution";

    public Solution create(Solution solution){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement =
                    connection.prepareStatement(CREATED_SOLUTION_QUERY,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setDate(1, (Date) solution.getCreated());
            statement.setDate(2,(Date) (solution.getUpdated()));
            statement.setString(3,solution.getDescription());
            statement.setInt(4,solution.getExerciseId());
            statement.setInt(5,solution.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while(resultSet.next()) {
                solution.setId(resultSet.getInt(1));
            }
            return solution;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    // todo zmienić w klasie solution pola na LocalDateTime a w metodzie read zastosować resultSet.getTimestamp zamiast getDate
    public Solution read(int id_solution){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1,id_solution);
            ResultSet resultSet = statement.executeQuery();
            Solution solution = new Solution();
            while(resultSet.next()){
               solution.setCreated(resultSet.getDate("created"));
               solution.setUpdated(resultSet.getDate("updated"));
               solution.setDescription(resultSet.getString("description"));
               solution.setUserId(resultSet.getInt("user_id"));
               solution.setExerciseId(resultSet.getInt("exercise_id"));
               solution.setId(resultSet.getInt("id_solution"));
            }
            return solution;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    public void update(Solution solution){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(UPDATE_SOLUTION_QUERY);
            statement.setDate(1, (Date) solution.getCreated());
            statement.setDate(2,(Date) solution.getUpdated());
            statement.setString(3,solution.getDescription());
            statement.setInt(4,solution.getExerciseId());
            statement.setInt(5,solution.getUserId());
            statement.setInt(6,solution.getId());
            statement.executeUpdate();
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    public void delete(int solutionId){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(DELETE_SOLUTION_QUERY);
            statement.setInt(1,solutionId);
            statement.executeUpdate();
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    public List<Solution> findAll(){
        List<Solution> solutionList = new ArrayList<>();
        Solution solution = new Solution();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_SOLUTION_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                solution.setId(resultSet.getInt("id_solution"));
                solution.setCreated(resultSet.getDate("created"));
                solution.setUpdated(resultSet.getDate("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setUserId(resultSet.getInt("user_id"));

                solutionList.add(solution);
            }
            return solutionList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

}
