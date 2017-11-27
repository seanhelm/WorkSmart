package com.cs321.group7.worksmart;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cs321.group7.worksmart.Entities.Class;

import java.lang.*;
import java.util.List;

/**
 * Created by seanhelm on 11/18/17.
 */

@Dao
public interface ClassDao {
    @Query("SELECT * FROM class WHERE semester_id = :semester_id")
    public List<java.lang.Class> getAll(long semester_id);

    @Query("SELECT * FROM class WHERE id = :id")
    public java.lang.Class get(long id);

    @Insert
    public long insert(java.lang.Class c);

    @Update
    public void update(java.lang.Class c);
}
