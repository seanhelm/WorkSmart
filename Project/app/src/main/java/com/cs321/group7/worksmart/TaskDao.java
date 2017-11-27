package com.cs321.group7.worksmart;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cs321.group7.worksmart.Task;

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
    public long insert(Task semester);

    @Update
    public void update(Task semester);
}
