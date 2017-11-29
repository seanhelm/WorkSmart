package com.cs321.group7.worksmart;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.cs321.group7.worksmart.Entities.Semester;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class SemesterTest
{
    private AppDatabase appDB;

    @Before
    public void setUp() throws Exception
    {
        // Don't use this in actual code because it only stores in memory (used for testing)
        // Use GetDB instead
        appDB = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase.class).build();
    }

    @After
    public void shutDown() throws Exception
    {
        appDB.close();
    }

    @Test
    public void createAndVerifySemester()
    {
        Semester semester = new Semester("Fall 2016");
        long id = appDB.semesterDao().insert(semester);

        Semester retrieved = appDB.semesterDao().get(id);
        assertEquals("Fall 2016", retrieved.getName());
    }

    @Test
    public void updateAndVerifySemester()
    {
        Semester semester = new Semester("Fall 2016");
        long id = appDB.semesterDao().insert(semester);

        semester = appDB.semesterDao().get(id);
        assertEquals("Fall 2016", semester.getName());
        semester.setName("Spring 2017");
        appDB.semesterDao().update(semester);

        semester = appDB.semesterDao().get(id);
        assertEquals("Spring 2017", semester.getName());
    }
}
