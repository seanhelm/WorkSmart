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
        entity = Semester.class,
        parentColumns = "id",
        childColumns = "semester_id",
        onDelete = CASCADE))
public class Class {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private String professor;
    private String uta;
    private String gta;
    private String email;
    private String location;
    private String time;
    private String days;
    private String class_start_time;
    private String class_end_time;

    @ColumnInfo(name = "semester_id")
    private long semesterId;

    public Class(String name, String professor, String email,
                 String location, String time, long semesterId) {
        this.name = name;
        this.professor = professor;
        this.email = email;
        this.location = location;
        this.time = time;
        this.semesterId = semesterId;
        this.days = "000000";
    }

    // Getters and Setters

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessor() {
        return this.professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getSemesterId() {
        return this.semesterId;
    }

    public void setSemesterId(long semesterId) {
        this.semesterId = semesterId;
    }

    public String getUta() {
        return uta;
    }

    public void setUta(String uta) {
        this.uta = uta;
    }

    public String getGta() {
        return gta;
    }

    public void setGta(String gta) {
        this.gta = gta;
    }

    public void setDay(int day, boolean val) {
        this.days = this.days.substring(0, day) + (val ? "1" : "0") + this.days.substring(day + 1);
    }

    public boolean getDay(int day) {
        return (this.days.charAt(day) == '1');
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getClass_start_time() {
        return class_start_time;
    }

    public void setClass_start_time(String class_start_time) {
        this.class_start_time = class_start_time;
    }

    public String getClass_end_time() {
        return class_end_time;
    }

    public void setClass_end_time(String class_end_time) {
        this.class_end_time = class_end_time;
    }
}

