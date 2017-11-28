package com.cs321.group7.worksmart.Daos;

import android.arch.persistence.room.*;

import com.cs321.group7.worksmart.Entities.Task;

import java.util.List;

/**
 * Created by seanhelm on 11/18/17.
 */

@Dao
public interface TaskDao {
    @Query("SELECT * FROM task WHERE class_id = :class_id")
    public List<Task> getAll(long class_id);

    @Query("SELECT * FROM task WHERE id = :id")
    public Task get(long id);

    @Insert
    public long insert(Task task);

    @Update
    public void update(Task task);

    @Delete
    public void delete(Task task);
}
