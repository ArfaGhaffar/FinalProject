[0:09 am, 13/01/2022] Arfa: package com.example.libraryonline;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener {

    Button btn;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
        btn1 = (Button)findViewById(R.id.button4);
        btn1.setOnClickListener(this);
    }





    @Override
    public voi…
[0:10 am, 13/01/2022] Arfa: package com.example.libraryonline;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener {

    Button btn;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
        btn1 = (Button)findViewById(R.id.button4);
        btn1.setOnClickListener(this);
    }





    @Override
    public void onClick(View v) {
        if(v.equals(btn)){
            Intent i = new Intent(this, Login_activity.class);
            startActivity(i);
        }
        if(v.equals(btn1)){
            Intent i = new Intent(this, RegisterActivity.class);
            startActivity(i);
        }

    }


}
