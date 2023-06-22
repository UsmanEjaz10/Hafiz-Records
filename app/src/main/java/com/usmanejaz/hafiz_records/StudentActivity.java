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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Progress f0 = new Progress(1, 23, 35, 20, 19, 2);
        Progress f1 = new Progress(2, 50, 55, 15, 14, 9);
        Progress f2 = new Progress(3, 102, 105, 2, 1, 1);
        Progress f3 = new Progress(4, 23, 78, 21, 20, 6);

        progressList.addAll(Arrays.asList(new Progress[]{f0,f1,f2,f3}));
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