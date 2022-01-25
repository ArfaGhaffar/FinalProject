package com.example.libraryonline;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login_activity extends Activity {
    SharedPreferences sharedpreferences;
    DatabaseHelper  registerUser;
    public static final String mypreference = "mypref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Start page");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        registerUser = new DatabaseHelper(this);
    }

    public void login(View view)
    {
        EditText userName = (EditText) findViewById(R.id.user_login);
        EditText password = (EditText) findViewById(R.id.pass_login);
        Button signOn = (Button) findViewById(R.id.login_btn);

        String s_userName = userName.getText().toString();
        String s_password = password.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();

        Cursor res=registerUser.getStudent(s_userName, s_password);

        if(userName.getText().toString().isEmpty() || password.getText().toString().isEmpty() ){
            Toast.makeText(Login_activity.this, "All fields are mandatory!", Toast.LENGTH_LONG).show();
        }

        if(res.getCount() == 1 ) {
            editor.putString("userType","student");
            String username = "";
            while (res.moveToNext()) {
                editor.putString("regn", res.getString(0));
                editor.putString("dept", res.getString(2));
                username = res.getString(1);
                editor.putString("name", username);
            }
            editor.commit();
            Intent i = new Intent(this, Student_Profile_Activity.class);
            startActivity(i);
           
            Toast.makeText(Login_activity.this, "Welcome "+username, Toast.LENGTH_LONG).show();

        }

        else {
            setContentView(R.layout.activity_login);
            Toast.makeText(Login_activity.this, "Sorry, you entered wrong credentials", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("text", userName.getText().toString());
        outState.putString("text2", password.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        userName.setText(savedInstanceState.getString("text"));
        password.setText(savedInstanceState.getString("text2"));
        super.onRestoreInstanceState(savedInstanceState);
    }

  @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}

