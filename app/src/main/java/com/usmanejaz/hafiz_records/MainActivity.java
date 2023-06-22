package com.usmanejaz.hafiz_records;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Profile> friendsList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Profile f0 = new Profile("Asad", 1980, "Giglgit");
        Profile f1 = new Profile("Zubair", 1981, "Lahore");
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

        friendsList.addAll(Arrays.asList(new Profile[]{f0,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11}));
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


    }
}