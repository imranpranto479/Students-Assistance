package com.example.studentassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.studentassistant.Adapters.favBookAdapter;

public class FavoriteList extends AppCompatActivity implements favBookAdapter.BookClick{

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);



        favBookAdapter adapter=new favBookAdapter(this,this);
        recyclerView=findViewById(R.id.favResycle);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCllick(int position) {
        if (Home.favBooks.size()!=0){
            Home.favBooks.get(position).setPdfData();
            startActivity(new Intent(FavoriteList.this,PdfView.class));
        }
        else {
            Toast.makeText(FavoriteList.this,"There is no favorite book!",Toast.LENGTH_SHORT).show();
        }

    }
}