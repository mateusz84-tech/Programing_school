package pl.matkoc.dao;

import pl.matkoc.connection.DBUtil;
import pl.matkoc.model.User;
import pl.matkoc.service.CrudManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements CrudManager<User,Integer> {

    private final String CREATE_USER_QUERY =
            "INSERT INTO users(username,email,password,user_group_id)VALUES(?,?,?,?)";
    private final String READ_USER_QUERY =
            "SELECT * FROM users WHERE id_user = ?";
    private final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ?, user_group_id = ? WHERE id_user = ?";
    private final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id_user = ?";
    private final String FIND_ALL_USERS =
            "SELECT * FROM users";
    private final String FIND_ALL_USERS_BY_GROUP_ID =
            "SELECT * FROM users WHERE user_group_id = ?";

    public String getFIND_ALL_USERS_BY_GROUP_ID() {
        return FIND_ALL_USERS_BY_GROUP_ID;
    }

    @Override
    public User create(User user){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(CREATE_USER_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            statement.setInt(4,user.getGroupId());
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

    @Override
    public User read(Integer userId){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(READ_USER_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            User user = new User();
            while (resultSet.next()){
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setGroupId(resultSet.getInt("user_group_id"));
                user.setId(resultSet.getInt("id_user"));
            }
            return user;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(User user){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_QUERY);
            statement.setString(1,user.getUserName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            statement.setInt(4,user.getGroupId());
            statement.setInt(5,user.getId());
            statement.executeUpdate();
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    @Override
    public void delete(Integer userId){
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_QUERY);
            statement.setInt(1,userId);
            statement.executeUpdate();
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }

    @Override
    public List<User> findAll(){
        List<User> userList = new ArrayList<>();

        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id_user"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setGroupId(resultSet.getInt("user_group_id"));

                userList.add(user);
            }
            return userList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

    public List<User> findAllByGroupId(int groupId){
        List<User> userList = new ArrayList<>();
        try(Connection connection = DBUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_USERS_BY_GROUP_ID);
            statement.setInt(1,groupId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id_user"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setGroupId(resultSet.getInt("user_group_id"));

                userList.add(user);
            }
            return userList;
        }catch (SQLException exc){
            exc.printStackTrace();
            return null;
        }
    }

}
