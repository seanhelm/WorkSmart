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

public class SystemUtilities
{
        //For properly welcoming the user in the navigation menu header
        private String userName = "";

        //Initializing variables to be used throughout the program run. currentSemesterID and
        //currentClassID will be used to reference where the user is currently looking at within the
        //app, to make sure they access only classes in a specific semester, or grades in a specific
        //class vs. others, etc.
        private Context context;
        private AppDatabase appDB = AppDatabase.getDB(context);
        private long currentSemesterID = 0;
        private long currentClassID = 0;

        private Semester currentSemester = appDB.semesterDao().get(currentSemesterID);
        private Class currentClass = appDB.classDao().get(currentClassID);

        public SystemUtilities(Context context)
        {
                this.context = context;
        }

        //------------------------------------------------------------------------------------------
        //---------------------------Semester  Related----------------------------------------------
        //------------------------------------------------------------------------------------------
        public void addSemester(String semesterName)
        {
                Semester newSemester = new Semester(semesterName, currentSemesterID);
                appDB.semesterDao().insert(newSemester);
                currentSemesterID++;
        }

        public void removeSemester(long semesterID)
        {
                appDB.semesterDao().delete(appDB.semesterDao().get(semesterID));
        }

        public List<Semester> getAllSemesters()
        {
                return appDB.semesterDao().getAll();
        }

        public void updateSemesterName(long semesterID, String semesterName)
        {
                Semester newSemester = new Semester(semesterName, semesterID);
                appDB.semesterDao().update(newSemester);
        }

        //------------------------------------------------------------------------------------------
        //---------------------------Grade Related--------------------------------------------------
        //------------------------------------------------------------------------------------------

        //Retrieves class from database using className, and returns the current grade
        public double getCurrentGrade(String className)
        {
            return -1;
        }

        //Updates the currentGrade variable of specified class
        public void calculateGrade(String className)
        {

        }

        //Adds grade to the list of grades for a class
        public void addGrade(String className, String gradeName, double score, String classification)
        {

        }

        //Removes grade from list
        public void removeGrade(String className, String gradeName)
        {

        }

        public void addWeight(String className, String classificationName, double weight)
        {

        }

        public void removeWeight(String className, String classificationName)
        {

        }

        //------------------------------------------------------------------------------------------
        //---------------------------Task Related---------------------------------------------------
        //------------------------------------------------------------------------------------------
        public List<Task> getTaskList(String className)
        {
            List<Task> taskList = new ArrayList<Task>();
            //Import the list of tasks to the taskList variable from database
            return null;
        }

        public void addTask(String className, String taskName, String dueDate, String dueTime,
                            int priorityLevel, String notes)
        {

        }

        //------------------------------------------------------------------------------------------
        //---------------------------Access Related-------------------------------------------------
        //------------------------------------------------------------------------------------------
        public String getEmailInfo(String className, int facultyIndex)
        {

        }

        public void toggleHighContrast()
        {

        }

        public void toggleTextSize()
        {

        }

        public void closeApplication()
        {
            System.exit(1);
        }

        //------------------------------------------------------------------------------------------
        //---------------------------Options Related------------------------------------------------
        //------------------------------------------------------------------------------------------
        public void addProfileName(String userName)
        {
            this.profileName = userName;
        }
}
