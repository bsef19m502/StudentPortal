package com.example.azka.noreen.portal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.azka.noreen.portal.student.AddNewCourse;
import com.example.azka.noreen.portal.student.ViewAll;
import com.example.azka.noreen.portal.teacher.AddNewStudent;
import com.example.azka.noreen.portal.teacher.Constants;
import com.example.azka.noreen.portal.teacher.ViewAllStudents;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String email=getIntent().getStringExtra("Email");
        if(email.equals(Constants.firstTeacherEmail)||email.equals(Constants.secondTeacherEmail)){


            InitTeacherPagerView();
        }
        else{
            InitStudentPagerView();
        }

    }
    private void InitStudentPagerView() {
        viewPager=findViewById(R.id.generalViewPager);
        tabLayout=findViewById(R.id.generalTabLayout);
        ViewPagerAdapter vpa=new ViewPagerAdapter(getSupportFragmentManager());

        vpa.addFragment(new AddNewCourse(),"Insert New Course");
        vpa.addFragment(new ViewAll(),"View All Courses");

        viewPager.setAdapter(vpa);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void InitTeacherPagerView() {
        viewPager=findViewById(R.id.generalViewPager);
        tabLayout=findViewById(R.id.generalTabLayout);
        ViewPagerAdapter vpa=new ViewPagerAdapter(getSupportFragmentManager());

        vpa.addFragment(new AddNewStudent(),"Insert New Student");
        vpa.addFragment(new ViewAllStudents(),"View All Students");

        viewPager.setAdapter(vpa);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);

    }
}