package com.example.libraryonline;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    Button btn;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.user);
        btn.setOnClickListener(this);
        btn2 = (Button)findViewById(R.id.registerpage);
        btn2.setOnClickListener(this);
        btn1 = (Button)findViewById(R.id.admin);
        btn1.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public void onClick(View v) {
        if(v.equals(btn)){
            Intent i = new Intent(this, Login_activity.class);
            startActivity(i);
        }
        if(v.equals(btn1)){
            Intent i = new Intent(this, Admin_login.class);
            startActivity(i);
        }

        if(v.equals(btn2)){
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        }

    }


}
