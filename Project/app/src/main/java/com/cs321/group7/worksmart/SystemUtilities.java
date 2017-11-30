package com.cs321.group7.worksmart;

import android.content.Context;
import com.cs321.group7.worksmart.Entities.Class;
import com.cs321.group7.worksmart.Entities.Grade;
import com.cs321.group7.worksmart.Entities.Semester;
import com.cs321.group7.worksmart.Entities.Task;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lord Mendoza
 */

public class SystemUtilities
{
    //For properly welcoming the user in the navigation menu header
    private String userName = "User";

    /*
    Initializing variables to be used throughout the program run. currentSemesterID and
    currentClassID will be used to reference where the user is currently looking at within the
    app, to make sure they access only classes in a specific semester, or grades in a specific
    class vs. others, etc.
    */
    private AppDatabase appDB;

    /*
    Allows the program to keep track of the current semester and/or class that the user is
    interacting with;
     */
    private long currentSemesterId = -1;
    private long currentClassId = -1;

    /*
    Initializing the database for use
     */
    public SystemUtilities(Context context) {
        this.appDB = AppDatabase.getDB(context);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Semester  Related----------------------------------------------
    //------------------------------------------------------------------------------------------
    /*
    Returns the instance of Semester with the given ID
     */
    public Semester getSemesterById(long semesterId) {
        return appDB.semesterDao().get(semesterId);
    }

    /*
    Returns all instances of Semester of List<Semester> type
     */
    public List<Semester> getAllSemesters() {
        return appDB.semesterDao().getAll();
    }

    /*
    Allows the user to create an instance of Semester given the name, and inserts it to database
     */
    public void addSemester(String semesterName) {
        Semester newSemester = new Semester(semesterName);
        long id = appDB.semesterDao().insert(newSemester);

        // Set new semester to current semester
        this.setCurrentSemester(this.getSemesterById(id));
    }

    /*
    Removes instance of semester from database
     */
    public void removeSemester(Semester semester) {
        appDB.semesterDao().delete(semester);
    }

    /*
    Updates the information for an instance of Semester
     */
    public void updateSemester(Semester semester) {
        appDB.semesterDao().update(semester);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Class  Related-------------------------------------------------
    //------------------------------------------------------------------------------------------
    /*
    Returns instance of Class with the given ID
     */
    public Class getClassById(long classId) {
        return appDB.classDao().get(classId);
    }

    /*
    Returns list of instances of Class of List<Class> type
     */
    public List<Class> getClassesForSemester(Semester semester) {
        return appDB.classDao().getAll(semester.getId());
    }

    /*
    Creates instance of Class with given parameters, and inserts it to database
     */
    public void addClass(Semester semester, String name, String professor, String email,
                         String location, String time) {
        Class c = new Class(name, professor, email, location, time, semester.getId());
        long id = appDB.classDao().insert(c);

        // Set new class to current class
        this.setCurrentClass(this.getClassById(id));
    }

    /*
    Removes instance of Class from database
     */
    public void removeClass(Class c) {
        appDB.classDao().delete(c);
    }

    /*
     Updates instance of Class in database
      */
    public void updateClass(Class c) {
        appDB.classDao().update(c);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Grade Related--------------------------------------------------
    //------------------------------------------------------------------------------------------
    /*
    Returns instance of Grade with the given ID
     */
    public Grade getGradeById(long gradeId) {
        return appDB.gradeDao().get(gradeId);
    }

    /*
    Returns list of grades for a particular class
     */
    public List<Grade> getGradesForClass(Class c) {
        return appDB.gradeDao().getAll(c.getId());
    }

    /*
    Retrieves instance of Class from database, and returns the current grade; auto-calculates it
    for user
     */
    public double calculateGrade(Class c) {
        List<Grade> grades = appDB.gradeDao().getAll(c.getId());
        double currentGrade = 0.0;

        for (Grade grade : grades) {
            currentGrade += grade.getValue() * grade.getWeight();
        }

        return currentGrade;
    }

    /*
    Adds instance of Grade for a class on database
     */
    public void addGrade(Class c, String gradeName, float score, float classification)
    {
        Grade grade = new Grade(gradeName, score, classification, c.getId());
        appDB.gradeDao().insert(grade);
    }

    /*
    Removes instance of Grade from database
     */
    public void removeGrade(Grade grade) {
        appDB.gradeDao().delete(grade);
    }

    /*
    Updates instance of Grade from database
     */
    public void updateGrade(Grade grade) {
        appDB.gradeDao().update(grade);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Task Related---------------------------------------------------
    //------------------------------------------------------------------------------------------
    /*
    Returns instance of Task with the given ID
     */
    public Task getTaskById(long taskId) {
        return appDB.TaskDao().get(taskId);
    }

    /*
    Returns a list of tasks within a class in priority order:
    first ones in list have priority level of 1, the next 2, and last ones of 3.
    */
    public List<Task> getTasksForClass(Class c)
    {
        List<Task> list = appDB.TaskDao().getAll(c.getId());
        Collections.sort(list);
        return list;
    }

    /*
    Adds instance of Task to database for a class
     */
    public void addTask(Class c, String taskName, String dueDate, String dueTime,
                        int priorityLevel) {
        Task task = new Task(taskName, dueDate, dueTime, priorityLevel, c.getId());
        appDB.TaskDao().insert(task);
    }

    /*
    Removes instance of Task from database
     */
    public void removeTask(Task task) {
        appDB.TaskDao().delete(task);
    }

    /*
    Updates instance of Task from database
     */
    public void updateTask(Task task) {
        appDB.TaskDao().update(task);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Options Related------------------------------------------------
    //------------------------------------------------------------------------------------------
    /*
    Revises the username of the user
     */
    public void addProfileName(String userName)
    {
        this.userName = userName;
    }

    /*
    Retrieves the username of user for displaying in the navigation header
     */
    public String getProfileName(String userName)
    {
        return this.userName;
    }

    /*
    Retrieves the email info for professor of a class
     */
    public String getProfessorEmail(Class className)
    {
        setCurrentClass(className);
        return appDB.classDao().get(currentClassId).getEmail();
    }

    /*
    Retrieves the GTA email info of a class
     */
    public String getGTAEmail(Class className)
    {
        setCurrentClass(className);
        return appDB.classDao().get(currentClassId).getGta();
    }

    /*
    Retrieves the UTA email info of a class
     */
    public String getUTAEmail(Class className)
    {
        setCurrentClass(className);
        return appDB.classDao().get(currentClassId).getUta();
    }

    /*
    Closes the application in proper order; ensure to include call to finish() prior to call
     */
    public void closeApplication()
    {
        System.exit(1);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Utilities Related----------------------------------------------
    //------------------------------------------------------------------------------------------
    /*
    Retrieves the instance of Semester that the user is interacting with
     */
    public Semester getCurrentSemester()
    {
        if (this.currentSemesterId >= 0) {
            return appDB.semesterDao().get(this.currentSemesterId);
        } else {
            return null;
        }
    }

    /*
    Assigns the currentSemester ID to the instance of Semester specified
     */
    public void setCurrentSemester(Semester s) {
        this.currentSemesterId = s.getId();
    }

    /*
    Retrieves the instance of Class that the user is interacting with
     */
    public Class getCurrentClass() {
        if (this.currentClassId >= 0) {
            return appDB.classDao().get(this.currentClassId);
        } else {
            return null;
        }
    }

    /*
    Assigns the currentClass ID to the instance of Class specified
    */
    public void setCurrentClass(Class c) {
        this.currentClassId = c.getId();
    }

    public long getCurrentSemesterId()
    {
        return this.currentSemesterId;
    }

    public long getCurrentClassId()
    {
        return this.currentClassId;
    }
}
