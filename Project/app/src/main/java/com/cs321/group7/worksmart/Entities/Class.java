package com.cs321.group7.worksmart.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;
import android.support.annotation.NonNull;

import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by seanhelm on 11/14/17.
 */

@Entity(foreignKeys = @ForeignKey(
        entity = Semester.class,
        parentColumns = "id",
        childColumns = "semester_id",
        onDelete = CASCADE))
public class Class {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private String professor;
    private String email;
    private String location;
    private int time;

    @ColumnInfo(name = "semester_id")
    private long semesterId;

    public Class(String name, String professor, String email,
                 String location, int time, long semesterId)
    {
        this.name = name;
        this.professor = professor;
        this.email = email;
        this.location = location;
        this.time = time;
        this.semesterId = semesterId;
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

    public String getProfessor()
    {
        return this.professor;
    }

    public void setProfessor(String professor)
    {
        this.professor = professor;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLocation()
    {
        return this.location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public int getTime()
    {
        return this.time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public long getSemesterId()
    {
        return this.semesterId;
    }

    public void setSemesterId(long semesterId)
    {
        this.semesterId = semesterId;
    }
}

