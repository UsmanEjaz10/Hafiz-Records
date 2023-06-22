package com.usmanejaz.hafiz_records;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    TextView editStudent;
    EditText sabaq_para, sabaq_start, sabaq_end, sabaqi, manzil;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("id"));
        sabaq_para  = findViewById(R.id.sabaq_para);
        sabaq_start = findViewById(R.id.sabaq_start);
        sabaq_end = findViewById(R.id.sabaq_end);
        sabaqi = findViewById(R.id.editparasabqi);
        manzil = findViewById(R.id.editmanzilpara);
        save = findViewById(R.id.save);
        editStudent = findViewById(R.id.EditStudent);
        editStudent.setText("Student ID: " + id);

    }
}