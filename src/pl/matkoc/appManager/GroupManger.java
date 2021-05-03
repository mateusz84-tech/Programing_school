package pl.matkoc.appManager;

import pl.matkoc.dao.GroupDao;
import pl.matkoc.model.Group;
import pl.matkoc.service.CrudFacade;

import java.util.List;

public class GroupManger {

    public static void main(String[] args) {

        CrudFacade groupFacade = new CrudFacade();
        displayAllGroup();
        Menu.displayActionOptions();
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
}
