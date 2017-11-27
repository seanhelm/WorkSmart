package com.cs321.group7.worksmart;

import com.cs321.group7.worksmart.Daos.*;
import com.cs321.group7.worksmart.Entities.*;


/**
 * Created by Lord Mendoza on 11/15/2017.
 */

public class SystemUtilities
{
        //------------------------------------------------------------------------------------------
        //---------------------------Semester  Related----------------------------------------------
        //------------------------------------------------------------------------------------------
        public void addSemester(String semesterName)
        {
                Semester newSemester = new Semester(semesterName);
                
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


}
