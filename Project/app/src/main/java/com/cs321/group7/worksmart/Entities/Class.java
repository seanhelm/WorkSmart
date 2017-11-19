package com.cs321.group7.worksmart.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
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
    public int id;

    public String name;
    public String professor;

    @NonNull
    public String email;
    public String location;
    public int time;

    @ColumnInfo(name = "semester_id")
    public int semesterId;
}
