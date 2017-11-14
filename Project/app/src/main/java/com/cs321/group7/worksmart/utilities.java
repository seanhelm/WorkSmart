package com.cs321.group7.worksmart;

public class utilities
{
    //Grade Related
    getCurrentGrade(className){}
    calculateGrade(className){}
    addGrade(className, gradeName, score, classification){}
    removeGrade(className, gradeName){}
    addWeight(className, classificationName, weight){}
    removeWeight(className, classificationName){}

    //Task Related
    getTaskList(className){}
    addTask(className, taskName, dueDate, dueTime, priorityLevel, notes){}
    removeTask(className, taskName){}
    setReminder(className, taskName, taskName, remindValue, timeFormat){}

    //Class Related
    getClasses(semesterName){}
    addClass(semesterName, className, facultyInfoOne, facultyInfoTwo, classLocation, classStart, classEnd, daysOfWeek){}
    removeClass(semesterName, className){}

    //Access Related
    getEmailInfo(className, facultyIndex){}
    toggleTextSize(fontSize){}
    toggleColorAdjustment(colorIndex){}
    toggleHighContrast(){}
    closeApplication(){}

    //Options Related
    addProfileName(userName){}
    setTimeFormat(timeSettingIndex){}
    setDateFormat(dateSettingIndex){}

}
