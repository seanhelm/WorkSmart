package com.cs321.group7.worksmart;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.cs321.group7.worksmart.Daos.*;
import com.cs321.group7.worksmart.Entities.*;
import com.cs321.group7.worksmart.Entities.Class;

/**
 * Created by seanhelm on 11/14/17.
 *
 * Reference:
 * http://blog.iamsuleiman.com/android-architecture-components-tutorial-room-livedata-viewmodel/
 */

/**
 * Tutorial:
 * This is the main class that will be used to interact with the database
 * GetDB() enforces the Singleton design pattern to ensure only one DB helper is ever instantiated
 * Dao's are used to query the database
 *
 * For example - retrieve all semesters:
 *      appDB = AppDatabase.getDB(this.getApplicationContext());
 *      List<Semester> = appDB.SemesterDao.getAll();
 *
 * Or, retrieve all tasks for class id = 1:
 *      Class currClass = appDB.ClassDao.get(1);
 *      int class_id = currClass.id;
 *      List<Task> = appDB.TaskDao.getAll(class_id)
 */

@Database(entities = {Semester.class, Class.class, Grade.class, Task.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public static AppDatabase getDB(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "worksmart_db").allowMainThreadQueries().build();
        }

        return instance;
    }

    public abstract SemesterDao semesterDao();
    public abstract ClassDao classDao();
    public abstract GradeDao gradeDao();
    public abstract TaskDao TaskDao();
}