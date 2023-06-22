package com.usmanejaz.hafiz_records;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentActivity extends AppCompatActivity {


    List<Progress> progressList= new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        db = new DBHelper(getApplicationContext());
        progressList = db.selectAllProgress();

        recyclerView = findViewById(R.id.recylerViewprogress);



        recyclerView.setHasFixedSize(true);


        //LinearLayoutManager GridLayoutManager
        layoutManager = new LinearLayoutManager(StudentActivity.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                false);
        recyclerView.setLayoutManager(layoutManager);


        adapter = new myProgressViewAdapter(progressList) ;

        recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();


    }
}