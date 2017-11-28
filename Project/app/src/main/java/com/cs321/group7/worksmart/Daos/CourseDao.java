package com.cs321.group7.worksmart.Daos;

import android.arch.persistence.room.*;

import com.cs321.group7.worksmart.Entities.Course;

import java.util.List;

/**
 * Created by seanhelm on 11/18/17.
 */

@Dao
public interface CourseDao {
    @Query("SELECT * FROM course WHERE semester_id = :semester_id")
    public List<Course> getAll(long semester_id);

    @Query("SELECT * FROM course WHERE id = :id")
    public Course get(long id);

    @Insert
    public long insert(Course c);

    @Update
    public void update(Course c);

    @Delete
    public void delete(Course c);
}
