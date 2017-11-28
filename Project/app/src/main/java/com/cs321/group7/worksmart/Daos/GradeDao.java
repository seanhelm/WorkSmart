package com.cs321.group7.worksmart.Daos;

import android.arch.persistence.room.*;

import com.cs321.group7.worksmart.Entities.Grade;

import java.util.List;

/**
 * Created by seanhelm on 11/18/17.
 */

@Dao
public interface GradeDao {
    @Query("SELECT * FROM grade WHERE class_id = :class_id")
    public List<Grade> getAll(long class_id);

    @Query("SELECT * FROM grade WHERE id = :id")
    public Grade get(long id);

    @Insert
    public long insert(Grade grade);

    @Update
    public void update(Grade grade);

    @Delete
    public void delete(Grade grade);
}
