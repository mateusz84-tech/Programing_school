package pl.matkoc.service;

import pl.matkoc.dao.ExerciseDao;
import pl.matkoc.dao.GroupDao;
import pl.matkoc.dao.SolutionDao;
import pl.matkoc.dao.UserDao;
import pl.matkoc.model.Exercise;
import pl.matkoc.model.Group;
import pl.matkoc.model.Solution;
import pl.matkoc.model.User;

import java.util.List;

public class CrudFacade {

    private ExerciseDao exerciseDao;
    private GroupDao groupDao;
    private UserDao userDao;
    private SolutionDao solutionDao;



    public CrudFacade(){
        this.exerciseDao = new ExerciseDao();
        this.groupDao = new GroupDao();
        this.solutionDao = new SolutionDao();
        this.userDao = new UserDao();
    }

    public Exercise createExercise(Exercise exercise){
        return exerciseDao.create(exercise);
    }
    public Exercise readExercise(Integer id){
        return exerciseDao.read(id);
    }
    public void updateExercise(Exercise exercise){
        exerciseDao.update(exercise);
    }
    public void deleteExercise(Integer id){
        exerciseDao.delete(id);
    }
    public List<Exercise> findAllExercise(){
        return exerciseDao.findAll();
    }

    public Group createGroup(Group group){
        return groupDao.create(group);
    }
    public Group readGroup(Integer id){
        return groupDao.read(id);
    }
    public void updateGroup(Group group){
        groupDao.update(group);
    }
    public void deleteGroup(Integer id){
        groupDao.delete(id);
    }
    public List<Group> findAllGroup(){
        return groupDao.findAll();
    }

    public User createUser(User user){
        return userDao.create(user);
    }
    public User readUser(Integer id){
        return userDao.read(id);
    }
    public void updateUser(User user){
        userDao.update(user);
    }
    public void deleteUser(Integer id){
        userDao.delete(id);
    }
    public List<User> findAllUser(){
        return userDao.findAll();
    }
    public List<User> findAllUserByGroupId(Integer id){
        return userDao.findAllByGroupId(id);
    }

    public Solution createSolution(Solution solution){
        return solutionDao.create(solution);
    }
    public Solution readSolution(Integer id){
        return solutionDao.read(id);
    }
    public void updateSolution(Solution solution){
        solutionDao.update(solution);
    }
    public void deleteSolution(Integer id){
        solutionDao.delete(id);
    }
    public List<Solution> findAllSolution(){
        return solutionDao.findAll();
    }
    public List<Solution> findAllSolutionByUserId(Integer id){
        return solutionDao.findAllByUserId(id);
    }
    public List<Solution> findAllSolutionByExerciseId(Integer id){
       return  solutionDao.findAllByExerciseId(id);
    }
}
