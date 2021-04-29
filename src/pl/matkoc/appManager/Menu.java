package pl.matkoc.appManager;

import pl.matkoc.model.Exercise;
import pl.matkoc.service.CrudManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void displaySubject(){
        System.out.println();
        System.out.printf("%20s%n\t","====== MENU =======");
        System.out.printf("\t%-20s%n\t","1. Ćwiczenie");
        System.out.printf("\t%-20s%n\t","2. Grupa");
        System.out.printf("\t%-20s%n\t","3. Urzytkownik");
        System.out.printf("\t%-20s%n\t","4. Rozwiązanie");
    }

    public static void displayActionOptions(){
        System.out.println();
        System.out.printf("%20s%n\t","====== MENU =======");
        System.out.printf("\t%-20s%n\t","1. Dodaj");
        System.out.printf("\t%-20s%n\t","2. Wczytaj");
        System.out.printf("\t%-20s%n\t","3. Edytuj");
        System.out.printf("\t%-20s%n\t","4. Usuń");
        System.out.printf("\t%-20s%n\t","4. Pokaż listę");
    }

    public static <T, V> void getChoiceMenu(CrudManager<T,V> crudManager){

        Scanner input = new Scanner(System.in);
        int choice = 0;
        System.out.print("Wybierz: ");
        try {
            choice = input.nextInt();
        }catch (InputMismatchException exc){
            System.out.println("Błędne dane wejściowe.");

        }
        switch(choice){
            case 1:{
                System.out.println("Dodawanie...");

            }break;
            case 2:{
                System.out.println("Edycja...");
            }break;
            case 3:{
                System.out.println("Usuwanie...");
            }break;
            case 4:{
                System.out.println("Dzięki za skorzystanie z programu.");
                System.exit(0);
            }
            default:
                System.out.println("Brak takiej opcji w manu.");
        }
    }
}
