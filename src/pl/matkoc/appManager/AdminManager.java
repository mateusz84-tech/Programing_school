package pl.matkoc.appManager;

import pl.matkoc.model.Group;

public class AdminManager {

    private ExerciseManager exerciseManager;
    private GroupManger groupManger;
    private UserManager userManager;
    private SolutionManager solutionManager;

    public AdminManager(){
        exerciseManager = new ExerciseManager();
        groupManger = new GroupManger();
        userManager = new UserManager();
        solutionManager = new SolutionManager();
    }

    public void runExerciseAppManagement(){
        ExerciseManager.exerciseManagement();
    }
    public void runGroupAppManagement(){
        GroupManger.groupManagement();
    }
    public void runUserAppManagement(){
        UserManager.userManagement();
    }
    public void runSolutionAppManagement(){
        SolutionManager.solutionManagement();
    }
}
