package com.cs321.group7.worksmart.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cs321.group7.worksmart.Entities.Semester;

import java.util.List;

/**
 * Created by seanhelm on 11/18/17.
 */

@Dao
public interface SemesterDao {
    @Query("SELECT * FROM semester")
    public List<Semester> getAll();

    @Query("SELECT * FROM semester WHERE id = :id")
    public Semester get(long id);

    @Insert
    public long insert(Semester semester);

    @Update
    public void update(Semester semester);
}
