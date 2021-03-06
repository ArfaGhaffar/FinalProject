package com.example.libraryonline;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
    DatabaseHelper  registerUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Start page");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

    }

    public void register(View view)
    {

        EditText registerNumber = (EditText) findViewById(R.id.RegNo);
        EditText userName = (EditText) findViewById(R.id.username);
        EditText department = (EditText) findViewById(R.id.department);
        EditText password = (EditText) findViewById(R.id.password);

        if(registerNumber.getText().toString().isEmpty() || userName.getText().toString().isEmpty() || department.getText().toString().isEmpty()
                || password.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "All fields are mandatory!", Toast.LENGTH_LONG).show();
        }
        else
            if(userName.getText().toString().length()<6 )
            {
                Toast.makeText(RegisterActivity.this, "Username must be at-least 6 characters", Toast.LENGTH_LONG).show();
            }
            else
                if(password.getText().toString().length()<8)
                {
                    Toast.makeText(RegisterActivity.this, "Password must be at-least 8 characters", Toast.LENGTH_LONG).show();
                }
                else {
                    registerUser = new DatabaseHelper(this);
                    Cursor res = registerUser.isUserPresent(registerNumber.getText().toString().trim(), userName.getText().toString().trim());
                    if (res.getCount() == 0) {
                        boolean isInserted = registerUser.insertStudent(registerNumber.getText().toString(), userName.getText().toString(), department.getText().toString(), password.getText().toString());
                        if (isInserted == true) {
                            Toast.makeText(RegisterActivity.this, "Student registered successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(this, Login_activity.class);
                            startActivity(i);
                        } else
                            Toast.makeText(RegisterActivity.this, "Sorry!, some thing went wrong", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this, "Username or Register number must be unique", Toast.LENGTH_LONG).show();
                    }
                }
    }
    
    
     @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("text", userName.getText().toString());
        outState.putString("text2", password.getText().toString());
        outState.putString("text3", registerNumber.getText().toString());
        outState.putString("text4", department.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        userName.setText(savedInstanceState.getString("text"));
        password.setText(savedInstanceState.getString("text2"));
        userName.setText(savedInstanceState.getString("text3"));
        password.setText(savedInstanceState.getString("text4"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
