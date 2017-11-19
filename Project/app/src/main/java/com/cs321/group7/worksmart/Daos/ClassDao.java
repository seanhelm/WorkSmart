package com.cs321.group7.worksmart.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cs321.group7.worksmart.Entities.Class;

import java.util.List;

/**
 * Created by seanhelm on 11/18/17.
 */

@Dao
public interface ClassDao {
    @Query("SELECT * FROM class WHERE semester_id = :semester_id")
    public List<Class> getAll(int semester_id);

    @Query("SELECT * FROM class WHERE id = :id")
    public Class get(int id);

    @Insert
    public void add(Class c);

    @Update
    public void update(Class c);
}
