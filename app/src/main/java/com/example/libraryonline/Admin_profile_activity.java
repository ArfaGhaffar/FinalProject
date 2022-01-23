package com.example.libraryonline;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class Admin_profile_activity extends Activity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_profile_activity);
        
         ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Admin Login");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        
        DatabaseHelper myDb = new DatabaseHelper(Admin_profile_activity.this);

        List<String> c1 = new ArrayList<>();
        List<String> c2 = new ArrayList<>();
        List<String> c3 = new ArrayList<>();
        List<String> c4 = new ArrayList<>();
        List<String> c5 = new ArrayList<>();
        listView = findViewById(R.id.listView);

        List<Record> res = myDb.getAllData();
        for(Record contact: res){

            c1.add(contact.getId());
            c2.add(contact.getName());
            c3.add(contact.getDepartment());
            c4.add(contact.getBook_name());
            c5.add(contact.getUsn());
        }

        String[] id = new String[ c1.size() ];
        c1.toArray(id);
        String[] name = new String[ c2.size() ];
        c2.toArray(name);
        String[] dep = new String[ c3.size() ];
        c3.toArray(dep);
        String[] book_name = new String[ c4.size() ];
        c4.toArray(book_name);
        String[] usn = new String[ c5.size() ];
        c5.toArray(usn);


        MyAdapter adapter = new MyAdapter(Admin_profile_activity.this, id, name,dep,book_name,usn);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
