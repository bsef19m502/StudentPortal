package com.example.azka.noreen.portal.teacher;

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

public class StudentRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Student> ls;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.student,parent,false);
        return new StudentRecyclerAdapter.StudentNCViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Student st=ls.get(position);
        StudentRecyclerAdapter.StudentNCViewHolder studentNCViewHolder= (StudentRecyclerAdapter.StudentNCViewHolder) holder;

        studentNCViewHolder.studentName.setText(st.getStudentName());
        studentNCViewHolder.studentCourse.setText(st.getStudentEmail());
        studentNCViewHolder.studentID.setText("Student ID: " + String.valueOf(position));

        studentNCViewHolder.image.setImageResource(R.drawable.ic_student);
//        Context item=studentNCViewHolder.image.getContext();


        studentNCViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(view.getContext(), StudentDetail.class);
                in.putExtra("StudentName",st.getStudentName());
                in.putExtra("StudentEmail",st.getStudentEmail());
                in.putExtra("StudentPhone",st.getStudentPhone());
                in.putExtra("StudentTeacher",st.getStudentTeacher());
                in.putExtra("StudentYear",st.getStudentYear());
                in.putExtra("StudentID",String.valueOf(position));

                view.getContext().startActivity(in);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public void setData(List<Student> StudentArrayList){
        this.ls=StudentArrayList;
        notifyDataSetChanged();

    }

    //to find views of single list xml file
    public static class StudentNCViewHolder extends RecyclerView.ViewHolder{

        TextView studentName;
        TextView studentCourse;
        TextView studentID;

        ImageView image;
        public StudentNCViewHolder(@NonNull View itemView) {
            super(itemView);

            studentName=itemView.findViewById(R.id.naam);
            studentCourse=itemView.findViewById(R.id.course);
            studentID=itemView.findViewById(R.id.cid);

            image=itemView.findViewById(R.id.dp);

        }
    }
}
