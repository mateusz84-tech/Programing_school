package pl.matkoc.appManager;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        AdminManager adminManager = new AdminManager();

        Menu.displaySubject();
        Scanner input = new Scanner(System.in);
        System.out.print("Wybierz: ");
        int option = input.nextInt();
        switch (option){
            case 1: {
                System.out.println("Zarządzanie ćwiczeniami.");
                adminManager.runExerciseAppManagement();
            }break;
            case 2: {
                System.out.println("Zarządzanie grupami.");
                adminManager.runGroupAppManagement();
            }break;
            case 3:{
                System.out.println("Zarządzanie użytkownikami.");
                adminManager.runUserAppManagement();
            }break;
            case 4:{
                System.out.println("Zarządzanie rozwiązaniami.");
                adminManager.runSolutionAppManagement();
            }break;
            case 5:{
                System.out.println("Dziękuje za skorzystanie z programu.");
                System.exit(0);
            }break;
            default:
                System.out.println("Niewłaściwy wybór");
        }

    }
}
