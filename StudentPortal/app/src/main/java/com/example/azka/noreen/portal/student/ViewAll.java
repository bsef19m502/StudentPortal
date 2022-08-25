package com.example.azka.noreen.portal.student;

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
import com.example.azka.noreen.portal.student.Course;
import com.example.azka.noreen.portal.student.CourseRecyclerAdapter;

import java.util.List;

public class ViewAll extends Fragment {
Button show;
RecyclerView d;

    public ViewAll() {
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
        View view= inflater.inflate(R.layout.fragment_view_all, container, false);
        appDatabase db=
                Room.databaseBuilder(requireContext(), appDatabase.class,
                        "my_database").allowMainThreadQueries().build();

        show=view.findViewById(R.id.showAll);
        d=view.findViewById(R.id.show);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Course> allCourses=db.courseDAO().getAll();
//                ArrayAdapter<Course> as=new ArrayAdapter<Course>(getContext(),android.R.layout.simple_list_item_1,allCourses);
//                d.setAdapter(as);
                CourseRecyclerAdapter fra=new CourseRecyclerAdapter();

                d.setAdapter(fra);
                d.setLayoutManager(new LinearLayoutManager(requireContext()));

                fra.setData(allCourses);



            }
        });

        return view;
    }
}