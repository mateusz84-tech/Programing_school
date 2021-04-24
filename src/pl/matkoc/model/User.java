package pl.matkoc.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {

    private int id;
    private String userName;
    private String email;
    private String password;
    private Group group;

    public void hashPassword(String password){
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    public User(String userName, String email, String password, Group group) {
        if(group == null){
            throw new NullPointerException("Grupa nie może być pusta.");
        }
        if(userName.isEmpty() || userName.isBlank()){
            throw new IllegalArgumentException("Nazwa nie może być pusta.");
        }
        if(email.isBlank() || email.isEmpty()){
            throw new IllegalArgumentException("Email nie może być pusty.");
        }
        this.userName = userName;
        this.email = email;
        this.group = group;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        if(group == null){
            throw new NullPointerException("Grupa nie może być typu null");
        }
        this.group = group;
    }

    public void setPassword(String password) {
        if(password.isBlank() || password.isEmpty()){
            throw new IllegalArgumentException("Hasło nie może być puste.");
        }
        this.password = BCrypt.hashpw(password,BCrypt.gensalt());
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s: %s"
                ,getId(),getUserName(),getEmail(),"Grupa",group.toString());
    }
}