package com.example.studentassistant.Buet;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentassistant.Adapters.Adapter;
import com.example.studentassistant.MenuActivity;
import com.example.studentassistant.R;

import java.util.ArrayList;
import java.util.List;

public class BuetDepartments extends MenuActivity implements Adapter.onCardClick {

    List<String> names;
    List<Integer>images;
    Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buet_departments);
        names=new ArrayList<>();
        images=new ArrayList<>();
        names.add("CSE");
        images.add(R.drawable.cse_icon);




        adapter=new Adapter(this,names,images,this);
        recyclerView=findViewById(R.id.buetDep);
        GridLayoutManager layout=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDepClick(int position) {

        if (position==0)startActivity(new Intent(BuetDepartments.this, BuetCse.class));


    }
}