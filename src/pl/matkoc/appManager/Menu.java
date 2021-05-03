package pl.matkoc.appManager;

import java.io.PrintStream;

public class Menu {

    public static void displaySubject(){
        System.out.println();
        System.out.printf("%20s%n\t","====== MENU =======");
        System.out.printf("\t%-20s%n\t","1. Ćwiczenie");
        System.out.printf("\t%-20s%n\t","2. Grupa");
        System.out.printf("\t%-20s%n\t","3. Urzytkownik");
        System.out.printf("\t%-20s%n\t","4. Rozwiązanie");
        System.out.printf("\t%-20s%n\t","5. Wyjdź");
    }

    public static void displayActionOptions(){
        System.out.println();
        System.out.printf("%20s%n\t","====== MENU =======");
        System.out.printf("\t%-20s%n\t","1. Dodaj");
        System.out.printf("\t%-20s%n\t","2. Wczytaj");
        System.out.printf("\t%-20s%n\t","3. Edytuj");
        System.out.printf("\t%-20s%n\t","4. Usuń");
        System.out.printf("\t%-20s%n\t","5. Wyjdź.");
    }
    public static void displaySolutionAction(){
        System.out.println();
        System.out.printf("%20s%n\t","====== MENU =======");
        System.out.printf("\t%-20s%n\t","1. Dodaj - przypisanie zadań do użytkownika.");
        System.out.printf("\t%-20s%n\t", "2. Widok - przeglądanie rozwiązań danego użytkownika.");
        System.out.printf("\t%-20s%n\t","3. Wyjdź.");
    }
}
