package com.example.azka.noreen.portal.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.azka.noreen.portal.R;

public class CourseDetail extends AppCompatActivity {
    TextView cn,cd,ct,cy,cc,cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        cn=findViewById(R.id.cn);
        cd=findViewById(R.id.cd);
        ct=findViewById(R.id.ct);
        cy=findViewById(R.id.cy);
        cc=findViewById(R.id.cc);
        cid=findViewById(R.id.cid);


        String CourseName=getIntent().getStringExtra("CourseName");
        String CourseDep=getIntent().getStringExtra("CourseDep");
        String CourseTeacher=getIntent().getStringExtra("CourseTeacher");
        String CourseYear=getIntent().getStringExtra("CourseYear");
        String CourseCode=getIntent().getStringExtra("CourseCode");
        String CourseID=getIntent().getStringExtra("CourseID");


        cn.setText("Course Name: "+CourseName);
        cd.setText("Course Department: "+CourseDep);
        ct.setText("Course Teacher: "+CourseTeacher);
        cy.setText("Course Year: "+CourseYear);
        cc.setText("Course Code: "+CourseCode);
        cid.setText("Course ID: "+CourseID);

    }
}