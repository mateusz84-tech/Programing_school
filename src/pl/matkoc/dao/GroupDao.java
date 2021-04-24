package pl.matkoc.dao;

import pl.matkoc.connection.DBUtil;
import pl.matkoc.model.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDao {

    private final String CREATE_GROUP_QUERY =
            "INSERT INTO user_group(name) VALUES(?)";

    public Group create(Group group){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_GROUP_QUERY,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,group.getName());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                group.setId(resultSet.getInt(1));
            }
            return group;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }
}
