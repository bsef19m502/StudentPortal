package com.example.azka.noreen.portal.student;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.azka.noreen.portal.R;

import java.util.List;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Course> ls;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.course,parent,false);
        return new CourseRecyclerAdapter.CourseNCViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Course st=ls.get(position);
        CourseRecyclerAdapter.CourseNCViewHolder courseNCViewHolder= (CourseRecyclerAdapter.CourseNCViewHolder) holder;

        courseNCViewHolder.courseName.setText(st.getCourseName());
        courseNCViewHolder.courseDep.setText(st.getCourseDapartment());
        courseNCViewHolder.courseID.setText("Course ID: "+String.valueOf(position));

        courseNCViewHolder.image.setImageResource(R.drawable.ic_subject);
//        Context item=studentNCViewHolder.image.getContext();


        courseNCViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(view.getContext(), CourseDetail.class);
                in.putExtra("CourseName",st.getCourseName());
                in.putExtra("CourseDep",st.getCourseDapartment());
                in.putExtra("CourseTeacher",st.getCourseTeacher());
                in.putExtra("CourseYear",st.getCourseYear());
                in.putExtra("CourseCode",st.getCourseCode());
                in.putExtra("CourseID",String.valueOf(position));
                view.getContext().startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ls.size();

    }
    public void setData(List<Course> StudentArrayList){
        this.ls=StudentArrayList;
        notifyDataSetChanged();

    }
    //to find views of single list xml file
    public static class CourseNCViewHolder extends RecyclerView.ViewHolder{

        TextView courseName;
        TextView courseDep;
        TextView courseID;
        ImageView image;
        public CourseNCViewHolder(@NonNull View itemView) {
            super(itemView);

            courseName=itemView.findViewById(R.id.naam);
            courseDep=itemView.findViewById(R.id.course);
            courseID=itemView.findViewById(R.id.cid);

            image=itemView.findViewById(R.id.dp);

        }
    }
}
