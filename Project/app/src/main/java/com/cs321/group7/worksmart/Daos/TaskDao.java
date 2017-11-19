package com.cs321.group7.worksmart.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cs321.group7.worksmart.Entities.Task;

import java.util.List;

/**
 * Created by seanhelm on 11/18/17.
 */

@Dao
public interface TaskDao {
    @Query("SELECT * FROM task WHERE class_id = :class_id")
    public List<Task> getAll(int class_id);

    @Query("SELECT * FROM task WHERE id = :id")
    public Task get(int id);

    @Insert
    public void add(Task semester);

    @Update
    public void update(Task semester);
}
