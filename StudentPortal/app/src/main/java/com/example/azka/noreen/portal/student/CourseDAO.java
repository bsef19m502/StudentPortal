package com.example.azka.noreen.portal.student;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface CourseDAO {
    @Insert
    void insertCourse(Course course);

//    @Delete
//    void deleteCourse(Course course);

    @Query("SELECT * FROM Course")
    List<Course> getAll();

    @Query("DELETE FROM Course")
    void nukeTable();

}
