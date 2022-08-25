package com.example.azka.noreen.portal.teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.azka.noreen.portal.R;

public class StudentDetail extends AppCompatActivity {
    TextView cn,cd,ct,cy,cc,cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        cn=findViewById(R.id.cn);
        cd=findViewById(R.id.cd);
        ct=findViewById(R.id.ct);
        cy=findViewById(R.id.cy);
        cc=findViewById(R.id.cc);
        cc=findViewById(R.id.cc);
        cid=findViewById(R.id.cid);




        String CourseName=getIntent().getStringExtra("StudentName");
        String CourseDep=getIntent().getStringExtra("StudentEmail");
        String CourseTecaher=getIntent().getStringExtra("StudentPhone");
        String CourseYear=getIntent().getStringExtra("StudentTeacher");
        String CourseCode=getIntent().getStringExtra("StudentYear");
        String CourseID=getIntent().getStringExtra("StudentID");


        cn.setText("Student Name: "+CourseName);
        cd.setText("Student Email: "+CourseDep);
        ct.setText("Student Phone: "+CourseTecaher);
        cy.setText("Student Teacher: "+CourseYear);
        cc.setText("Student Year: "+CourseCode);
        cid.setText("Student ID: " + CourseID);

    }
}