package com.cs321.group7.worksmart;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cs321.group7.worksmart.Entities.Class;
import com.cs321.group7.worksmart.Entities.Grade;
import com.cs321.group7.worksmart.Entities.Semester;
import com.cs321.group7.worksmart.Entities.Task;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lord Mendoza
 */

public class SystemUtilities
{
    //For properly welcoming the user in the navigation menu header
    private String userName = "";

    /*
    Initializing variables to be used throughout the program run. currentSemesterID and
    currentClassID will be used to reference where the user is currently looking at within the
    app, to make sure they access only classes in a specific semester, or grades in a specific
    class vs. others, etc.
    */
    private AppDatabase appDB;

    private long currentSemesterId = -1;
    private long currentClassId = -1;

    public SystemUtilities(Context context) {
        this.appDB = AppDatabase.getDB(context);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Semester  Related----------------------------------------------
    //------------------------------------------------------------------------------------------
    public Semester getSemesterById(long semesterId) {
        return appDB.semesterDao().get(semesterId);
    }

    public List<Semester> getAllSemesters() {
        return appDB.semesterDao().getAll();
    }

    public void addSemester(String semesterName) {
        Semester newSemester = new Semester(semesterName);
        long id = appDB.semesterDao().insert(newSemester);

        // Set new semester to current semester
        this.setCurrentSemester(this.getSemesterById(id));
    }

    public void removeSemester(Semester semester) {
        appDB.semesterDao().delete(semester);
    }

    public void updateSemester(Semester semester) {
        appDB.semesterDao().update(semester);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Class  Related-------------------------------------------------
    //------------------------------------------------------------------------------------------
    public Class getClassById(long classId) {
        return appDB.classDao().get(classId);
    }

    public List<Class> getClassesForSemester(Semester semester) {
        return appDB.classDao().getAll(semester.getId());
    }

    public void addClass(Semester semester, String name, String professor, String email,
                         String location, String time) {
        Class c = new Class(name, professor, email, location, time, semester.getId());
        long id = appDB.classDao().insert(c);

        // Set new class to current class
        this.setCurrentClass(this.getClassById(id));
    }

    public void removeClass(Class c) {
        appDB.classDao().delete(c);
    }

    public void updateClass(Class c) {
        appDB.classDao().update(c);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Grade Related--------------------------------------------------
    //------------------------------------------------------------------------------------------
    public Grade getGradeById(long gradeId) {
        return appDB.gradeDao().get(gradeId);
    }

    public List<Grade> getGradesForClass(Class c) {
        return appDB.gradeDao().getAll(c.getId());
    }

    //Retrieves class from database using className, and returns the current grade
    public double calculateGrade(Class c) {
        List<Grade> grades = appDB.gradeDao().getAll(c.getId());
        double currentGrade = 0.0;

        for (Grade grade : grades) {
            currentGrade += grade.getValue() * grade.getWeight();
        }

        return currentGrade;
    }

    //Adds grade to the list of grades for a class
    public void addGrade(Class c, String gradeName, float score, float classification) {
        Grade grade = new Grade(gradeName, score, classification, c.getId());
        appDB.gradeDao().insert(grade);
    }

    //Removes grade from list
    public void removeGrade(Grade grade) {
        appDB.gradeDao().delete(grade);
    }

    public void updateGrade(Grade grade) {
        appDB.gradeDao().update(grade);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Task Related---------------------------------------------------
    //------------------------------------------------------------------------------------------
    public Task getTaskById(long taskId) {
        return appDB.TaskDao().get(taskId);
    }

    public List<Task> getTasksForClass(Class c)
    {
        List<Task> list = appDB.TaskDao().getAll(c.getId());
        Collections.sort(list);

        return list;
    }

    public void addTask(Class c, String taskName, String dueDate, String dueTime,
                        int priorityLevel) {
        Task task = new Task(taskName, dueDate, dueTime, priorityLevel, c.getId());
        appDB.TaskDao().insert(task);
    }

    public void removeTask(Task task) {
        appDB.TaskDao().delete(task);
    }

    public void updateTask(Task task) {
        appDB.TaskDao().update(task);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Options Related------------------------------------------------
    //------------------------------------------------------------------------------------------
    public void addProfileName(String userName)
    {
        this.userName = userName;
    }

    public String getProfileName(String userName)
    {
        return this.userName;
    }

    public String getEmailInfo(Class className)
    {
        setCurrentClass(className);
        return appDB.classDao().get(currentClassId).getEmail();
    }

    public void closeApplication()
    {
        System.exit(1);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Utilities Related----------------------------------------------
    //------------------------------------------------------------------------------------------
    public Semester getCurrentSemester() {
        if (this.currentSemesterId >= 0) {
            return appDB.semesterDao().get(this.currentSemesterId);
        } else {
            return null;
        }
    }

    public void setCurrentSemester(Semester s) {
        this.currentSemesterId = s.getId();
    }

    public Class getCurrentClass() {
        if (this.currentClassId >= 0) {
            return appDB.classDao().get(this.currentClassId);
        } else {
            return null;
        }
    }

    public void setCurrentClass(Class c) {
        this.currentClassId = c.getId();
    }
}
