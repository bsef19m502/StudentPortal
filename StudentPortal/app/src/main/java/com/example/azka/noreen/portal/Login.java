package com.example.azka.noreen.portal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.azka.noreen.portal.teacher.Constants;

public class Login extends AppCompatActivity {
    Button signin;
    EditText email,password;
    TextView signup;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initSharedPref();

        signin=findViewById(R.id.signin);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        signup=findViewById(R.id.signup);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();
                String Pass=password.getText().toString();
                String[] SharedPrefValues=getPrefernceValues();
                if(!Email.equals("")){
                    if(!Pass.equals("")){
                        if((Email.equals(SharedPrefValues[0])&&Pass.equals(SharedPrefValues[1])) ||
                        (Email.equals(Constants.firstTeacherEmail)&&Pass.equals(Constants.firstTeacherPassword))
                                || (Email.equals(Constants.secondTeacherEmail)&&Pass.equals(Constants.secondTeacherPassword)))
                        {

                            Intent in=new Intent(Login.this, MainActivity.class);
                            in.putExtra("Email",email.getText().toString());

                            startActivity(in);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Invalid Credentials,Enter Again", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "PLease Enter Pasasword", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "PLease Enter Email", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Login.this, Signup.class);

                startActivity(in);
            }
        });


    }
    public void initSharedPref(){
        sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);

    }
    public String[] getPrefernceValues(){
        String np=sharedPreferences.getString("Email","no Email");
        String nr=sharedPreferences.getString("Password","no Password");

        String[] signupValues={np,nr};
        return signupValues;
    }
}