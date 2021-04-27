package pl.matkoc.appManager;

import pl.matkoc.dao.UserDao;
import pl.matkoc.model.User;

import java.util.List;

public class UserManager {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        displayAllUser(userDao);
        Menu.display();
        Menu.getChoiceMenu();

    }

    public static void displayAllUser(UserDao userDao){

        List<User> userList = userDao.findAll();
        System.out.println("===================== LISTA UŻYTKOWNIKÓW =======================");
        System.out.printf("%-6s\t%-18s\t%-24s\t%-18s%n","ID","NAME","EMAIL","GROUP_ID");
        for(int i=1; i<=64; i++){
            System.out.print("-");
        }
        System.out.println();
        for(User user : userList){
            System.out.printf("%-6d\t%-18s\t%-24s\t%-18d%n",
                    user.getId(),user.getUserName(),user.getEmail(),
                    user.getGroupId());
        }
    }
}
