package com.cs321.group7.worksmart.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;

import java.util.List;

/**
 * Created by seanhelm on 11/14/17.
 */

@Entity
public class Semester {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
}
