package pl.matkoc.appManager;

import pl.matkoc.dao.ExerciseDao;
import pl.matkoc.model.Exercise;
import pl.matkoc.model.User;
import pl.matkoc.service.CrudFacade;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ExerciseManager {

    public static void main(String[] args) {

        CrudFacade exerciseManage = new CrudFacade();

        for(;;) {
            displayAllExercise();
            Menu.displayActionOptions();
            selectExerciseAction(exerciseManage);
        }
    }

    public static void exerciseManagement(){
        CrudFacade crudFacade = new CrudFacade();
        while(true){
            displayAllExercise();
            Menu.displayActionOptions();
            selectExerciseAction(crudFacade);
        }
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

    public static void selectExerciseAction(CrudFacade crudFacade){
        Scanner input = new Scanner(System.in);
        System.out.print("Wybierz: ");
        int choice = input.nextInt();
        switch (choice){
            case 1: {
                Scanner scanner = new Scanner(System.in);
                Exercise exercise = new Exercise();
                System.out.println("Dodawanie nowego użtkonika.");
                System.out.print("Podaj tytuł ćwiczenia: ");
                exercise.setTitle(scanner.nextLine());
                System.out.print("Podaj opis ćwiczenia: ");
                exercise.setDescription(scanner.nextLine());
                crudFacade.createExercise(exercise);
                System.out.println("Dodano nowe ćwiczenie.");
            }break;
            case 2: {
                System.out.println("Pobierz ćwiczenie z bazy.");
                System.out.print("Podaj id ćwiczenia: ");
                int idExercise = input.nextInt();
                System.out.println(crudFacade.readExercise(idExercise));
            }break;
            case 3:{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Edycja ćwiczenia.");
                System.out.print("Podaj id ćwiczenia: ");
                int idExercise = scanner.nextInt();
                Exercise exercise = crudFacade.readExercise(idExercise);
                Scanner sc = new Scanner(System.in);
                System.out.print("Wpisz nowy tytuł: ");
                String title = scanner.next();
                exercise.setTitle(title);
                System.out.print("Wpisz nowy opis: ");
                String description = "";
                description = sc.nextLine();
                exercise.setDescription(description);
                System.out.print("Potwierdź id ćwiczenia: ");
                int id = sc.nextInt();
                exercise.setId(id);
                crudFacade.updateExercise(exercise);
                System.out.println("Dane zostały zaktualizowane.");
            }break;
            case 4:{
                System.out.println("Usuwanie ćwiczenia.");
                System.out.print("Wpisz id ćwiczenia do usunięcia: ");
                int deleteExercise = input.nextInt();
                crudFacade.deleteExercise(deleteExercise);
                System.out.println("Ćwiczenie zostało usuniete z bazy.");
            }break;
            case 5: {
                System.out.println("Wyjście do menu głównego.");
                String[] str = new String[0];
                Application.main(str);
            }break;
            default:
                System.out.println("Nie ma takiej opcji w menu.");
        }
    }
}
