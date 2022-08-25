package com.example.azka.noreen.portal.teacher;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.azka.noreen.portal.R;
import com.example.azka.noreen.portal.appDatabase;

import java.util.List;


public class ViewAllStudents extends Fragment {

    Button show;
    RecyclerView d;

    public ViewAllStudents() {
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
        View view= inflater.inflate(R.layout.fragment_view_all_students, container, false);

        show=view.findViewById(R.id.showAll);
        d=view.findViewById(R.id.show);
        appDatabase db=
                Room.databaseBuilder(requireContext(), appDatabase.class,
               "my_database").allowMainThreadQueries().build();

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> allStudents=db.studentDAO().getAll();
                StudentRecyclerAdapter fra=new StudentRecyclerAdapter();

                d.setAdapter(fra);
                d.setLayoutManager(new LinearLayoutManager(requireContext()));

                    fra.setData(allStudents);


            }
        });


        return view;
    }
}