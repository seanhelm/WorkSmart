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
        entity = Class.class,
        parentColumns = "id",
        childColumns = "class_id",
        onDelete = CASCADE))
public class Grade {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public float value;
    public float weight;

    @ColumnInfo(name = "class_id")
    public int classId;
}
