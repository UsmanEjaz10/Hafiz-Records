package com.usmanejaz.hafiz_records;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    TextView editStudent;
    EditText sabaq_para, sabaq_start, sabaq_end, sabaqi, manzil;
    Button save;
    Progress p;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

       Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        sabaq_para  = findViewById(R.id.sabaq_para);
        sabaq_start = findViewById(R.id.sabaq_start);
        sabaq_end = findViewById(R.id.sabaq_end);
        sabaqi = findViewById(R.id.editparasabqi);
        manzil = findViewById(R.id.editmanzilpara);
        save = findViewById(R.id.save);
        editStudent = findViewById(R.id.EditStudent);
       editStudent.setText("Student ID: " + id);

       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int ide = Integer.parseInt(id);
               int sabaq = Integer.parseInt(sabaq_para.getText().toString());
               int s_start = Integer.parseInt(sabaq_start.getText().toString());
               int s_end = Integer.parseInt(sabaq_end.getText().toString());
               int sabqi = Integer.parseInt(sabaqi.getText().toString());
               int mnzil = Integer.parseInt(manzil.getText().toString());
               p = new Progress(ide, s_start, s_end, sabaq, sabqi, mnzil);
               db = new DBHelper(EditActivity.this);

               db.editDetails(p);
               Intent intent = new Intent(EditActivity.this, StudentActivity.class);
               startActivity(intent);
               ((Activity)v.getContext()).finish();
           }
       });

    }
}