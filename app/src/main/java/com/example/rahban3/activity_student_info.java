package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_student_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_student_info);

        //menu
        DrawerHelper.setup(this);
        //btn save
        Button btnSaveStudent = findViewById(R.id.btnSaveStudent);

        btnSaveStudent.setOnClickListener(v->{
            Intent intent = new Intent(activity_student_info.this, activity_request_status.class);
            startActivity(intent);
            finish();
        });

        AutoCompleteTextView autoComplete = findViewById(R.id.autoCompleteRelation);
        String[] items = new String[] { "اول", "دوم" , "سوم"} ;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_dropdown_item_1line, items);
        autoComplete.setAdapter(adapter);

    }
}