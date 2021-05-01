package pl.matkoc.appManager;

import pl.matkoc.dao.ExerciseDao;
import pl.matkoc.model.Exercise;
import pl.matkoc.model.User;
import pl.matkoc.service.CrudFacade;

import java.util.List;

public class ExerciseManager {

    public static void main(String[] args) {

        CrudFacade exerciseManage = new CrudFacade();
        displayAllExercise();

    }

    public static void displayAllExercise(){

        ExerciseDao exerciseDao = new ExerciseDao();
        List<Exercise> exerciseList = exerciseDao.findAll();
        System.out.println("======================== LISTA ĆWICZEŃ ==========================");
        System.out.printf("%-6s\t%-38s\t%-24s%n","ID","TITLE","DESCRIPTION");
        for(int i=1; i<=65; i++){
            System.out.print("-");
        }
        System.out.println();
        for(Exercise exercise : exerciseList){
            System.out.printf("%-6d\t%-38s\t%-24s%n",
                    exercise.getId(),exercise.getTitle(),exercise.getDescription());

        }
    }
}
