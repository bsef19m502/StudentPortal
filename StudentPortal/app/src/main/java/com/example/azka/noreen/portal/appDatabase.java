package com.example.azka.noreen.portal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.azka.noreen.portal.student.Course;
import com.example.azka.noreen.portal.student.CourseDAO;
import com.example.azka.noreen.portal.teacher.Student;
import com.example.azka.noreen.portal.teacher.StudentDAO;


@Database(entities = {Student.class,
        Course.class},version = 3)
public abstract class appDatabase extends RoomDatabase {
    public static appDatabase dataBase;


    public abstract CourseDAO courseDAO();
    public abstract StudentDAO studentDAO();

    public static appDatabase getDatabase(Context context) {
        if (dataBase == null) {
            dataBase = Room.databaseBuilder(context.getApplicationContext(),
                    appDatabase.class, "my_database")
                    .build();
        }
        return dataBase;
    }
}
