package pl.matkoc.appManager;

import pl.matkoc.dao.ExerciseDao;
import pl.matkoc.dao.UserDao;
import pl.matkoc.model.Exercise;
import pl.matkoc.model.User;
import pl.matkoc.service.CrudFacade;
import pl.matkoc.service.CrudManager;

import java.util.List;
import java.util.Scanner;

public class UserManager {

    public static void main(String[] args) {

        CrudFacade facade = new CrudFacade();
        System.out.println("Zarządzanie użytkownikami.");
        for(;;) {
            displayAllUser(facade);
            Menu.displayActionOptions();
            selectUserAction(facade);
        }
    }

    public static void userManagement(){
        CrudFacade crudFacade = new CrudFacade();
        while (true){
            displayAllUser(crudFacade);
            Menu.displayActionOptions();
            selectUserAction(crudFacade);
        }
    }

    public static void displayAllUser(CrudFacade allUser){

        List<User> userList = allUser.findAllUser();
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

    public static void selectUserAction(CrudFacade crudFacade){
        Scanner input = new Scanner(System.in);
        System.out.print("Wybierz: ");
        int choice = input.nextInt();
        switch (choice){
            case 1: {
                Scanner scanner = new Scanner(System.in);
                User user = new User();
                System.out.println("Dodawanie nowego użtkonika.");
                System.out.print("Podaj nazwę użytkownika: ");
                user.setUserName(scanner.nextLine());
                System.out.print("Podaj email: ");
                user.setEmail(scanner.nextLine());
                System.out.print("Podaj hasło: ");
                user.setPassword(scanner.nextLine());
                System.out.print("Podaj id grupy do któtej ma należeć: ");
                user.setGroupId(scanner.nextInt());
                crudFacade.createUser(user);
                System.out.println("Dodano nowego użytkownika.");
            }break;
            case 2: {
                System.out.println("Pobierz użytkownika z bazy.");
                System.out.print("Podaj id użytkownika: ");
                int idUser = input.nextInt();
                System.out.println(crudFacade.readUser(idUser));
            }break;
            case 3:{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Edycja użytkownika.");
                System.out.print("Podaj id użytkownika: ");
                int idUser = scanner.nextInt();
                User userEdit = crudFacade.readUser(idUser);
                System.out.print("Wpisz nową nazwę: ");
                String name = scanner.next();
                userEdit.setUserName(name);
                System.out.print("Wpisz nowy email: ");
                String email = scanner.next();
                userEdit.setEmail(email);
                System.out.print("Wpisz nowe hasło: ");
                String password = scanner.next();
                userEdit.setPassword(password);
                System.out.print("Przypisz nową grupę: ");
                int group = scanner.nextInt();
                userEdit.setGroupId(group);
                System.out.print("Potwierdź id użytkownika: ");
                int id = scanner.nextInt();
                userEdit.setId(id);
                crudFacade.updateUser(userEdit);
                System.out.println("Dane zostały zaktualizowane.");
            }break;
            case 4:{
                System.out.println("Usuwanie użytkownika.");
                System.out.print("Wpisz id użytkownika do usunięcia: ");
                int deleteIdUser = input.nextInt();
                crudFacade.deleteUser(deleteIdUser);
                System.out.println("Użytkownik został usunięty z bazy.");
            }break;
            case 5: {
                System.out.println("Dziękuje za skorzystanie z programu.");
                System.exit(0);
            }break;
            default:
                System.out.println("Nie ma takiej opcji w menu.");
        }
    }

}
