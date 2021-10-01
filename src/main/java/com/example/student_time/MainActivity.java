package com.example.student_time;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<p1modelclass> userList;
    p1adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecylerData();

    }

    private void initData() {
        userList=new ArrayList<>();
        userList.add(new p1modelclass(R.drawable.ss,"SUJIT","K18KH","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.mm,"MANISH","K18NS","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.pp,"PRASAN","K18KH","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.bb,"RAHUL","K18QW","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.aa,"VARSA","K18QW","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.ss,"SUJIT","K18KH","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.mm,"MANISH","K18NS","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.ss,"SUJIT","K18KH","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.mm,"MANISH","K18NS","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.pp,"PRASAN","K18KH","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.bb,"RAHUL","K18QW","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.aa,"VARSA","K18QW","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.ss,"SUJIT","K18KH","2018-2022","_____________________________"));
        userList.add(new p1modelclass(R.drawable.mm,"MANISH","K18NS","2018-2022","_____________________________"));
    }

    private void initRecylerData() {
        recyclerView=findViewById(R.id.recyclerView);
        layoutManager =new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new p1adapter(userList);
        recyclerView.setAdapter(adapter);

    }
}