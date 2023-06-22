package com.usmanejaz.hafiz_records;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Profile> friendsList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Button button, editbutton;
    FloatingActionButton f_button;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editbutton = findViewById(R.id.button2);
        f_button = findViewById(R.id.fbutton);

        Profile f0 = new Profile(1, "Usman", "A1");
        Profile f1 = new Profile(2,"Zubair",  "A2");
        Profile f2 = new Profile("Musa", 1980, "Quetta");
        Profile f3 = new Profile("Nadeem",1987,"Peshawar");
        Profile f4 = new Profile("Shahid", 1980, "Karachi");
        Profile f5 = new Profile("Zia",1987,"Faisalabad ");
        Profile f6 = new Profile("Badar", 1980, "Rawalpindi");
        Profile f7 = new Profile("Hashim",1997,"Karachi");
        Profile f8 = new Profile("Salman",1980,"Quetta");
        Profile f9 = new Profile("Rizwan",1982,"Kasur");
        Profile f10 = new Profile("Junaid",1977,"Islamabad");
        Profile f11 = new Profile("Waseem",1967,"Rawalpindi");
        db = new DBHelper(getApplicationContext());
        db.insertStudent(f0);
        db.insertStudent(f1);

        friendsList = db.selectAllStudents();
        recyclerView = findViewById(R.id.recylerViewStudent);


        recyclerView.setHasFixedSize(true);

        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(MainActivity.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(friendsList) ;
        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });

        editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("id", String.valueOf(1));
                startActivity(intent);
            }
        });



    }
}