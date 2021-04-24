package pl.matkoc.dao;

public class UserDao {

    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username,email,password,user_group_id)VALUES(?,?,?,?)";
    private static final String READ_USER_QUERY =
            "SELECT * FORM users WHERE id = ?";
    private static final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? user_group_id = ? WHERE id = ?";
    private static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";
    private static final String FIND_ALL_USERS =
            "SELECT * FROM users";

}
