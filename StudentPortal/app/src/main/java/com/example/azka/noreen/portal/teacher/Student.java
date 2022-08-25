package com.example.azka.noreen.portal.teacher;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="student_name")
    public String studentName;

    @ColumnInfo(name="student_email")
    public String studentEmail;

    @ColumnInfo(name="student_phone")
    public String studentPhone;

    @ColumnInfo(name="student_teacher")
    public String studentTeacher;

    @ColumnInfo(name="student_year")
    public String studentYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentTeacher() {
        return studentTeacher;
    }

    public void setStudentTeacher(String studentTeacher) {
        this.studentTeacher = studentTeacher;
    }

    public String getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(String studentYear) {
        this.studentYear = studentYear;
    }

    public Student() {
    }

    public Student(String studentName, String studentEmail, String studentPhone, String studentTeacher, String studentYear) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.studentTeacher = studentTeacher;
        this.studentYear = studentYear;
    }
}
