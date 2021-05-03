package pl.matkoc.appManager;

import pl.matkoc.model.Exercise;
import pl.matkoc.model.Solution;
import pl.matkoc.model.User;
import pl.matkoc.service.CrudFacade;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class SolutionManager {

    public static void main(String[] args) {
        CrudFacade crudFacade = new CrudFacade();
        for(;;) {
            displaySolution(crudFacade);
            Menu.displaySolutionAction();
            selectSolutionAction(crudFacade);
        }

    }

    public static void displaySolution(CrudFacade crudFacade){
        List<Solution> solutionList = crudFacade.findAllSolution();
        System.out.println("======================================================== LISTA ĆWICZEŃ ============================================================");
        System.out.printf("%-6s\t%-24s\t%-24s\t%-38s\t%-18s\t%-18s%n","ID","CREATED","UPDATED","DESCRIPTION","EXERCISE ID","USER_ID");
        for(int i=1; i<=131; i++){
            System.out.print("-");
        }
        System.out.println();
        for(Solution solution : solutionList){
            System.out.printf("%-6d\t%-24s\t%-24s\t%-38s\t%-18d\t%-18d%n",
                    solution.getId(),solution.getCreated(),solution.getUpdated(),
                    solution.getDescription(),solution.getExerciseId(),solution.getUserId());
        }
    }

    public static void selectSolutionAction(CrudFacade crudFacade){
        System.out.print("Wybierz: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:{
                UserManager.displayAllUser(crudFacade);
                System.out.print("Wybierz id użytkownika: ");
                Scanner input = new Scanner(System.in);
                int idUser = input.nextInt();
                User user = crudFacade.readUser(idUser);
                ExerciseManager.displayAllExercise();
                System.out.print("Wybierz id zadania: ");
                int idExercise = input.nextInt();
                Exercise exercise = crudFacade.readExercise(idExercise);
                Solution solution = new Solution();
                solution.setExerciseId(exercise.getId());
                solution.setUserId(user.getId());
                solution.setCreated(Timestamp.valueOf(LocalDateTime.now()));
                solution.setUpdated(Timestamp.valueOf(LocalDateTime.now()));
                solution.setDescription("-");
                crudFacade.createSolution(solution);
                System.out.println("Do rozwiązania przypisano użytkownika i grupę.");
            }break;
            case 2:{
                System.out.println("Rozwiązanie danego użytkownika.");
                System.out.print("Wpisz id użytkownika: ");
                Scanner scanner = new Scanner(System.in);
                int id = scanner.nextInt();
                List<Solution> solutions = crudFacade.findAllSolutionByUserId(id);
                for(Solution solution : solutions){
                    System.out.print(solution.toString());
                }

            }break;
            case 3:{
                System.out.println("Dziekuje za skorzystanie z programu.");
                System.exit(0);
            }break;
            default:
                System.out.println("Brak takiej opcji.");
        }
    }
}
