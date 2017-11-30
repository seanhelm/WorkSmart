package com.cs321.group7.worksmart.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by seanhelm on 11/14/17.
 */

@Entity(foreignKeys = @ForeignKey(
        entity = Class.class,
        parentColumns = "id",
        childColumns = "class_id",
        onDelete = CASCADE))
public class Task implements Comparable
{
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private String date;
    private String time;
    private int priority;

    @ColumnInfo(name = "class_id")
    private long classId;

    public Task(String name, String date, String time, int priority, long classId)
    {
        this.name = name;
        this.date = date;
        this.time = time;
        this.priority = priority;
        this.classId = classId;
    }

    // Getters and Setters

    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDate()
    {
        return this.date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getTime()
    {
        return this.time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public int getPriority()
    {
        return this.priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public long getClassId()
    {
        return this.classId;
    }

    public void setClassId(long classId)
    {
        this.classId = classId;
    }

    public int compareTo(Task comparesTu)
    {
        int priorityLevel = comparesTu.getPriority();
        return this.getPriority() - priorityLevel;
    }

    public int compareTo(Object o)
    {
        int priorityLevel = ((Task)o).getPriority();
        return this.getPriority() - priorityLevel;
    }
}
