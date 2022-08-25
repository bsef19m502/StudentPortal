package com.example.azka.noreen.portal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Signup extends AppCompatActivity {

    Button signup;
    EditText namee,emaile,phonee,passe,repasse;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initSharedPref();

        signup=findViewById(R.id.signup);

        namee=findViewById(R.id.nameee);
        emaile=findViewById(R.id.emaileee);
        phonee=findViewById(R.id.phoneNO);
        passe=findViewById(R.id.pass);
        repasse=findViewById(R.id.passRe);

        signup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String name = namee.getText().toString();
                String email = emaile.getText().toString();
                String phone = phonee.getText().toString();
                String pass = passe.getText().toString();
                String repass = repasse.getText().toString();
                if(!name.equals("")){
                    if(!email.equals("")){
                        if(!phone.equals("")){
                            if(!pass.equals("")){
                                if(!repass.equals("")){
                                    appDatabase db=
                                            Room.databaseBuilder(getApplicationContext(), appDatabase.class,
                                                    "my_database").allowMainThreadQueries().build();
                                  db.courseDAO().nukeTable();


                                    Toast.makeText(getApplicationContext(), "Signup Complete", Toast.LENGTH_SHORT).show();
//                                    Constants.studentName=name;
//                                    Constants.studentEmail=email;
//                                    Constants.studentPhone=phone;
//                                    Constants.studentPassword=pass;
                                    putPrefernceValues(name,email,phone,pass);


                                    finish();

                                }else{
                                    Toast.makeText(getApplicationContext(), "PLease Re-Enter password ", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(getApplicationContext(), "PLease Enter Password ", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "PLease Enter Phone ", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "PLease Enter Email ", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "PLease Enter Name ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void initSharedPref(){
        sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);
        sharedPreferencesEditor=sharedPreferences.edit();

    }
    public void putPrefernceValues(String n, String p,String q, String r){
        sharedPreferencesEditor.putString("Name",n);
        sharedPreferencesEditor.putString("Email",p);
        sharedPreferencesEditor.putString("Phone",q);
        sharedPreferencesEditor.putString("Password",r);
        sharedPreferencesEditor.apply();
    }

}