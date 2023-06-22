package com.usmanejaz.hafiz_records;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddProfile extends AppCompatActivity {

    EditText id, name, section;
    DBHelper db;
    AppCompatButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        id = findViewById(R.id.editTextTextPersonName);
        name = findViewById(R.id.editTextTextPersonName2);
        section = findViewById(R.id.editTextTextPersonName3);
        button = findViewById(R.id.addHafiz);
        db = new DBHelper(getApplicationContext());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ide = Integer.parseInt(id.getText().toString());
                String name1 = name.getText().toString();
                String sec1 = section.getText().toString();


                Profile p = new Profile(ide, name1, sec1);
                db.insertStudent(p);

                Intent intent = new Intent(AddProfile.this, MainActivity.class);
                startActivity(intent);

                ((Activity)v.getContext()).finish();
            }
        });

    }
}