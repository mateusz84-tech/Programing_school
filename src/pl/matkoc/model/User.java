package pl.matkoc.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {

    private int id;
    private String userName;
    private String email;
    private String password;
    private int userGroupId;

    public void hashPassword(String password){
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public User(String userName, String email, String password, int userGroupId) {
        if(userGroupId < 0){
            throw new IllegalArgumentException("Id nie może być mniejsze od zera.");
        }
        if(userName.isEmpty() || userName.isBlank()){
            throw new IllegalArgumentException("Nazwa nie może być pusta.");
        }
        if(email.isBlank() || email.isEmpty()){
            throw new IllegalArgumentException("Email nie może być pusty.");
        }
        this.userName = userName;
        this.email = email;
        this.userGroupId = userGroupId;
        this.hashPassword(password);
    }

    public User() {};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0){
            throw new IllegalArgumentException("Id nie może być mniesze od zera.");
        }
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(userName.isEmpty() || userName.isBlank()){
            throw new IllegalArgumentException("Nazwa nie może być pusta.");
        }
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email.isBlank() || email.isBlank()){
            throw new IllegalArgumentException("Email nie może być pusty.");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        if(userGroupId < 0){
            throw new IllegalArgumentException("Id nie może być mniejsze od zera.");
        }
        this.userGroupId = userGroupId;
    }

    public void setPassword(String password) {
        if(password.isBlank() || password.isEmpty()){
            throw new IllegalArgumentException("Hasło nie może być puste.");
        }
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s: %d"
                ,getId(),getUserName(),getEmail(),"Id grupy",getUserGroupId());
    }
}