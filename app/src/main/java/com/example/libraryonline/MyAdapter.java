package com.example.libraryonline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends ArrayAdapter<String> {

    Context context;
    String id[];
    String name[];
    String department[];
    String book_name[];
    String usn[];



    MyAdapter (Context c, String i[], String n[],String d[],String b[],String u[]) {
        super(c, R.layout.item_list, R.id.textView1, i);
        this.context = c;
        this.id = i;
        this.name = n;
        this.department=d;
        this.book_name=b;
        this.usn=u;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.item_list, parent, false);
        TextView myId = row.findViewById(R.id.textView1);
        TextView myName = row.findViewById(R.id.textView2);
        TextView myDepartment = row.findViewById(R.id.textView3);
        TextView myBook = row.findViewById(R.id.textView4);
        TextView myUsn = row.findViewById(R.id.textView5);


        // now set our resources on views
        myId.setText(id[position]);
        myName.setText(name[position]);
        myDepartment.setText(department[position]);
        myBook.setText(book_name[position]);
        myUsn.setText(usn[position]);

        return row;
    }
}

