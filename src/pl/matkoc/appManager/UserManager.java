package pl.matkoc.appManager;

import pl.matkoc.dao.ExerciseDao;
import pl.matkoc.dao.GroupDao;
import pl.matkoc.dao.SolutionDao;
import pl.matkoc.dao.UserDao;
import pl.matkoc.model.Exercise;
import pl.matkoc.model.Group;
import pl.matkoc.model.Solution;
import pl.matkoc.model.User;
import pl.matkoc.service.CrudManager;

import java.util.List;

public class UserManager {

    public static void main(String[] args) {

        ExerciseDao exerciseDao = new ExerciseDao();
        CrudManager<Exercise,Integer> crudManager = exerciseDao;
        System.out.println(crudManager.read(1));
        System.out.println(crudManager.findAll());
        CrudManager<Group,Integer> crudManager1 = new GroupDao();
        System.out.println(crudManager1.read(1));
        System.out.println(crudManager1.findAll());
        SolutionDao solutionDao = new SolutionDao();
        CrudManager<Solution,Integer> crudManager2 = solutionDao;
        System.out.println(crudManager2.findAllByUserId(1, solutionDao.getFIND_ALL_BY_USER_ID_QUERY()));
        System.out.println(crudManager2.findAllByExerciseId(1, solutionDao.getFIND_ALL_BY_EXERCISE_ID_QUERY()));

        UserDao userDao = new UserDao();
        CrudManager<User,Integer> crudManager3 = userDao;
        System.out.println("Metoda z USERMANAGER: " + crudManager3.findAllByExerciseId(1,userDao.getFIND_ALL_USERS_BY_GROUP_ID()));


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
