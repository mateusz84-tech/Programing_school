package pl.matkoc.dao;

import pl.matkoc.connection.DBUtil;
import pl.matkoc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private final String CREATE_USER_QUERY =
            "INSERT INTO users(username,email,password,user_group_id)VALUES(?,?,?,?)";
    private final String READ_USER_QUERY =
            "SELECT * FORM users WHERE id = ?";
    private final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? user_group_id = ? WHERE id = ?";
    private final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";
    private final String FIND_ALL_USERS =
            "SELECT * FROM users";

    public User create(User user){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(CREATE_USER_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            statement.setInt(4,user.getGroup().getId());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                user.setId(resultSet.getInt(1));
            }
            return user;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

}
