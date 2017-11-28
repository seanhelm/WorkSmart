package com.cs321.group7.worksmart.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by seanhelm on 11/14/17.
 */

@Entity(foreignKeys = @ForeignKey(
        entity = Course.course,
        parentColumns = "id",
        childColumns = "class_id",
        onDelete = CASCADE))
public class Grade {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private float value;
    private float weight;

    @ColumnInfo(name = "course_id")
    private long courseId;

    public Grade(String name, float value, float weight, long courseId)
    {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.courseId = courseId;
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

    public float getValue()
    {
        return this.value;
    }

    public void setValue(float value)
    {
        this.value = value;
    }

    public float getWeight()
    {
        return this.weight;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    public long getCourseId()
    {
        return this.courseId;
    }

    public void setCourseId(long courseId)
    {
        this.courseId = courseId;
    }
}
