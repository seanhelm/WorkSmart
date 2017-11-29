package com.cs321.group7.worksmart.Daos;

import android.arch.persistence.room.*;

import com.cs321.group7.worksmart.Entities.Class;

import java.util.List;

/**
 * Created by seanhelm on 11/18/17.
 */

@Dao
public interface ClassDao {
    @Query("SELECT * FROM class WHERE semester_id = :semester_id")
    public List<Class> getAll(long semester_id);

    @Query("SELECT * FROM class WHERE id = :id")
    public Class get(long id);

    @Insert
    public long insert(Class c);

    @Update
    public void update(Class c);

    @Delete
    public void delete(Class c);
}
