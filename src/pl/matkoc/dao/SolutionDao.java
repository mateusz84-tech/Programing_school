package pl.matkoc.dao;

import pl.matkoc.connection.DBUtil;
import pl.matkoc.model.Solution;

import java.sql.*;

public class SolutionDao {

    private final String CREATED_SOLUTION_QUERY =
            "INSERT INTO solution(created,updated,description,exercise_id,user_id) VALUES(?,?,?,?,?)";



    public Solution create(Solution solution){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement =
                    connection.prepareStatement(CREATED_SOLUTION_QUERY,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setDate(1, Date.valueOf(solution.getCreated()));
            statement.setDate(2,Date.valueOf(solution.getUpdated()));
            statement.setString(3,solution.getDescription());
            statement.setInt(4,solution.getExerciseId());
            statement.setInt(5,solution.getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            solution.setId(resultSet.getInt(1));
            return solution;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }
}
