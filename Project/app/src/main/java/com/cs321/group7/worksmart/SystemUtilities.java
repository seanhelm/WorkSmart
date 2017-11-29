package com.cs321.group7.worksmart;

import com.cs321.group7.worksmart.Daos.*;
import com.cs321.group7.worksmart.Entities.*;
import com.cs321.group7.worksmart.Entities.Class;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lord Mendoza on 11/15/2017.
 */

public class SystemUtilities {
    //For properly welcoming the user in the navigation menu header
    private String userName = "";

    //Initializing variables to be used throughout the program run. currentSemesterID and
    //currentClassID will be used to reference where the user is currently looking at within the
    //app, to make sure they access only classes in a specific semester, or grades in a specific
    //class vs. others, etc.
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
        this.currentSemesterId = id;
    }

    public void removeSemester(Semester semester) {
        appDB.semesterDao().delete(semester);
    }

    public void updateSemester(Semester semester) {
        appDB.semesterDao().update(semester);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Grade Related--------------------------------------------------
    //------------------------------------------------------------------------------------------

    public Grade getGradeById(long gradeId) {
        return appDB.gradeDao().get(gradeId);
    }

    public List<Grade> getGradesForClass(long classId) {
        return appDB.gradeDao().getAll(classId);
    }

    //Retrieves class from database using className, and returns the current grade
    public double getCurrentGrade(long classId) {
        List<Grade> grades = appDB.gradeDao().getAll(classId);
        double currentGrade = 0.0;

        for (Grade grade : grades) {
            currentGrade += grade.getValue() * grade.getWeight();
        }

        return currentGrade;
    }

    //Updates the currentGrade variable of specified class
    public void calculateGrade(String className) {
        // I don't know what this does
    }

    //Adds grade to the list of grades for a class
    public void addGrade(long classId, String gradeName, float score, float classification) {
        Grade grade = new Grade(gradeName, score, classification, classId);
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
        return appDB.taskDao().get(taskId);
    }

    public List<Task> getTasksForClass(long classId) {
        return appDB.taskDao().getAll(classId);
    }

    public void addTask(long classId, String taskName, String dueDate, String dueTime,
                        int priorityLevel, String notes) {
        Task task = new Task(taskName, dueDate, dueTime, priorityLevel, classId);
        appDB.taskDao().insert(task);
    }

    public void removeTask(Task task) {
        appDB.taskDao().delete(task);
    }

    public void updateTask(Task task) {
        appDB.taskDao().update(task);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Access Related-------------------------------------------------
    //------------------------------------------------------------------------------------------
    public String getEmailInfo(String className, int facultyIndex) {
        return null;
    }

    public void toggleHighContrast() {

    }

    public void toggleTextSize() {

    }

    public void closeApplication() {
        System.exit(1);
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Options Related------------------------------------------------
    //------------------------------------------------------------------------------------------
    public void addProfileName(String userName) {
        //this.profileName = userName;
    }

    //------------------------------------------------------------------------------------------
    //---------------------------Utilities Related------------------------------------------------
    //------------------------------------------------------------------------------------------
    public Semester getCurrentSemester() {
        if(this.currentSemesterId >= 0) {
            return appDB.semesterDao().get(this.currentSemesterId);
        } else {
            return null;
        }
    }

    public Class getCurrentClass() {
        if(this.currentClassId >= 0) {
            return appDB.classDao().get(this.currentClassId);
        } else {
            return null;
        }
    }
}
