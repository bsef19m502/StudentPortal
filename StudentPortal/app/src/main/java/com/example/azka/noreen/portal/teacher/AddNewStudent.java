package com.example.azka.noreen.portal.teacher;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.azka.noreen.portal.R;
import com.example.azka.noreen.portal.appDatabase;

public class AddNewStudent extends Fragment {
    Button save;
    EditText cn,cd,ct,cy,cc;

    public AddNewStudent() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_new_student, container, false);

        appDatabase db=
                Room.databaseBuilder(requireContext(), appDatabase.class,
                        "my_database").allowMainThreadQueries().build();


        cn=view.findViewById(R.id.courseName);
        cd=view.findViewById(R.id.courseDep);
        ct=view.findViewById(R.id.courseTeacher);
        cy=view.findViewById(R.id.courseYear);
        cc=view.findViewById(R.id.courseCode);

        save=view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student studentAdded=new Student(cn.getText().toString(),cd.getText().toString(),ct.getText().toString(),cy.getText().toString(),cc.getText().toString());
                db.studentDAO().insertStudent(studentAdded);
                Toast.makeText(getContext(), "Student Added", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}