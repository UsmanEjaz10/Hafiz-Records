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
    Progress d;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        db = new DBHelper(EditActivity.this);

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

       Progress p = db.getDetails(Integer.parseInt(id));

       sabaq_para.setText(String.valueOf(p.para_sabaq));
       sabaq_start.setText(String.valueOf(p.starting_sabaq));
       sabaq_end.setText(String.valueOf(p.ending_sabaq));
       sabaqi.setText(String.valueOf(p.sabqi));
       manzil.setText(String.valueOf(p.manzil%p.para_sabaq));

       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int ide = Integer.parseInt(id);
               int sabaq = Integer.parseInt(sabaq_para.getText().toString());
               int s_start = Integer.parseInt(sabaq_start.getText().toString());
               int s_end = Integer.parseInt(sabaq_end.getText().toString());
               int sabqi = Integer.parseInt(sabaqi.getText().toString());
               int mnzil = Integer.parseInt(manzil.getText().toString());
               d = new Progress(ide, s_start, s_end, sabaq, sabqi, mnzil);

               db.editDetails(d);
               Intent intent = new Intent(EditActivity.this, StudentActivity.class);
               startActivity(intent);
               ((Activity)v.getContext()).finish();
           }
       });

    }
}