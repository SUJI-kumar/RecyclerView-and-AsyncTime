package com.example.student_time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class p1_details extends AppCompatActivity {
    TextView texttitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p1_details);
        texttitle = findViewById(R.id.title);

        Intent i = getIntent();
        String title=i.getStringExtra("title");
        texttitle.setText(title);
    }
}