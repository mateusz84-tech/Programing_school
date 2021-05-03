package pl.matkoc.appManager;

import pl.matkoc.dao.GroupDao;
import pl.matkoc.model.Group;
import pl.matkoc.service.CrudFacade;

import java.util.List;
import java.util.Scanner;

public class GroupManger {

    public static void main(String[] args) {

        CrudFacade groupFacade = new CrudFacade();
        for(;;) {
            displayAllGroup();
            Menu.displayActionOptions();
            selectGroupAction(groupFacade);
            displayAllGroup();
        }
    }

    public static void displayAllGroup(){
        GroupDao groupDao = new GroupDao();
        List<Group> groupList = groupDao.findAll();
        System.out.println("================ LISTA GRUP ==================");
        System.out.printf("%-16s\t%s%n","ID","NAME");
        for(int i=1; i<=46; i++){
            System.out.print("-");
        }
        System.out.println();
        for(Group group : groupList){
            System.out.printf("%-16d\t%s%n",group.getId(),group.getName());
        }
    }

    public static void selectGroupAction(CrudFacade crudFacade){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wybierz: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                Group group = new Group();
                System.out.println("Dodawanie nowej grupy.");
                System.out.print("Wpisz nazwę grupy: ");
                Scanner inputAdd = new Scanner(System.in);
                String name = inputAdd.nextLine();
                group.setName(name);
                crudFacade.createGroup(group);
                System.out.println("Dodano nową grupę.");
            }break;
            case 2:{
                System.out.println("Odczyt danych z bazy.");
                System.out.print("Wyszukaj grupy po id: ");
                Scanner sc = new Scanner(System.in);
                int idEdit = sc.nextInt();
                System.out.println(crudFacade.readGroup(idEdit));
            }break;
            case 3:{
                System.out.println("Edycja danych.");
                System.out.print("Wyszukaj grupy po id: ");
                Scanner sc = new Scanner(System.in);
                int idEdit = sc.nextInt();
                Group editGroup = crudFacade.readGroup(idEdit);
                System.out.print("Wpisz nową nazwę grupy: ");
                Scanner inputEdit = new Scanner(System.in);
                String name = inputEdit.nextLine();
                editGroup.setName(name);
                crudFacade.updateGroup(editGroup);
                System.out.println("Zaktualizowao dane.");
            }break;
            case 4:{
                System.out.println("Usuwanie danych.");
                System.out.print("Wpisz id grupy do usunięcia.");
                Scanner inputDelete = new Scanner(System.in);
                int id = inputDelete.nextInt();
                crudFacade.deleteGroup(id);
                System.out.println("Dane zostały usunięte.");
            }break;
            case 5:{
                System.out.println("Dziękuje za skorzystanie z programu.");
                System.exit(0);
            }break;
            default:
                System.out.println("Brak takiej opcji w menu.");
        }
    }
}
