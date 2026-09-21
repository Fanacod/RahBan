package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class activity_complate_parent_information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);

        setContentView(R.layout.activity_complate_parent_information);

        Button btnConfirmation = findViewById(R.id.btnConfirmation);

        btnConfirmation.setOnClickListener(v->{
            Intent intent = new Intent(activity_complate_parent_information.this, MainActivity.class);
            startActivity(intent);
            finish();
        });


        AutoCompleteTextView autoComplete = findViewById(R.id.autoCompleteRelation);
        String[] items = new String[] {"مادر", "پدر" , "سرپرست"} ;
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this , android.R.layout.simple_dropdown_item_1line, items);
        autoComplete.setAdapter(adapter);
    }
}