package com.cs321.group7.worksmart;

import com.cs321.group7.worksmart.Daos.*;
import com.cs321.group7.worksmart.Entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lord Mendoza on 11/15/2017.
 */

public class SystemUtilities
{
        private String profileName;
        public long[] classID;
        public long[] gradeID;
        public long[] taskID;

        public void addClassID(String className)
        {

        }

        public long getClassID(String className)
        {
            return 0;
        }


        //------------------------------------------------------------------------------------------
        //---------------------------Semester  Related----------------------------------------------
        //------------------------------------------------------------------------------------------
        public void addSemester(String semesterName)
        {
                Semester newSemester = new Semester(semesterName);
                AppDatabase.getDB().semesterDao().insert(newSemester);
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
