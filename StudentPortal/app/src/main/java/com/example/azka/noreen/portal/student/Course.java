package com.example.azka.noreen.portal.student;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="course_name")
    public String courseName;

    @ColumnInfo(name="course_department")
    public String courseDapartment;

    @ColumnInfo(name="course_teacher")
    public String courseTeacher;

    public Course() {
    }

    public Course( String courseName, String courseDapartment, String courseTeacher, String courseYear, String courseCode) {
        this.courseName = courseName;
        this.courseDapartment = courseDapartment;
        this.courseTeacher = courseTeacher;
        this.courseYear = courseYear;
        this.courseCode = courseCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDapartment() {
        return courseDapartment;
    }

    public void setCourseDapartment(String courseDapartment) {
        this.courseDapartment = courseDapartment;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @ColumnInfo(name="course_year")
    public String courseYear;

    @ColumnInfo(name="course_code")
    public String courseCode;

}
