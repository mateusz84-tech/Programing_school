package pl.matkoc.service;

import pl.matkoc.connection.DBUtil;
import pl.matkoc.model.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudManager<T,V> {

    T create(T type);
    T read(V value);
    void update(T type);
    void delete(V type);
    List<T> findAll();

    default public List<T> findAllByUserId(V userId, String query){
        List<T> solutionList = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, (Integer) userId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id_solution"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setUserId(resultSet.getInt("user_id"));

                solutionList.add((T) solution);
            }
            return solutionList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    default  public List<T> findAllByExerciseId(V exerciseId,String query){
        List<T> solutionList = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,(Integer)exerciseId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id_solution"));
                solution.setDescription(resultSet.getString("description"));
                solution.setCreated(resultSet.getTimestamp("created"));
                solution.setUpdated(resultSet.getTimestamp("updated"));
                solution.setExerciseId(resultSet.getInt("exercise_id"));
                solution.setUserId(resultSet.getInt("user_id"));


                solutionList.add((T) solution);
            }
            return solutionList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }
}
