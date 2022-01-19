package com.example.libraryonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
    }


    public void login(View view)
    {
        EditText userName = (EditText) findViewById(R.id.admin_login);
        EditText password = (EditText) findViewById(R.id.admin_pass_login);
        Button signOn = (Button) findViewById(R.id.admin_login_btn);

        String s_userName = userName.getText().toString();
        String s_password = password.getText().toString();

        if(userName.getText().toString().isEmpty() || password.getText().toString().isEmpty() ){
            Toast.makeText(Admin_login.this, "All fields are mandatory!", Toast.LENGTH_LONG).show();
        }


        if(s_userName.compareTo("admin")==0 && s_password.compareTo("admin@1234")==0) {


            Intent i = new Intent(this, Admin_profile_activity.class);
            startActivity(i);
            

        }
        else {
            setContentView(R.layout.activity_login);
            Toast.makeText(Admin_login.this, "Sorry, you entered wrong credentials", Toast.LENGTH_LONG).show();
        }
    }

  


}
