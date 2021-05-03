package pl.matkoc.appManager;

import pl.matkoc.model.Solution;
import pl.matkoc.service.CrudFacade;

import java.util.List;

public class SolutionManager {

    public static void main(String[] args) {
        CrudFacade crudFacade = new CrudFacade();
        displaySolution(crudFacade);

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
}
