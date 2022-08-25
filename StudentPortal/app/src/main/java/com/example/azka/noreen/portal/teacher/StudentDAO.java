package com.example.azka.noreen.portal.teacher;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.azka.noreen.portal.teacher.Student;

import java.util.List;
@Dao
public interface StudentDAO {

    @Insert
    void insertStudent(Student student);

//    @Delete
//    void deleteStudent(StudentEntity student);

    @Query("SELECT * FROM Student")
    List<Student> getAll();

    @Query("DELETE FROM Student")
    void nukeTable();
}
