package com.example.studentassistant.Buet;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentassistant.Adapters.BookAdapter;
import com.example.studentassistant.Book;
import com.example.studentassistant.MenuActivity;
import com.example.studentassistant.PdfView;
import com.example.studentassistant.R;

import java.util.Vector;

public class BuetCse extends MenuActivity implements BookAdapter.ClickListner{
    RecyclerView recyclerView;
    Vector<Book>booksInfo;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buet_cse);
booksInfo=new Vector<>();
//booksInfo.add(new Book("CP","programmer",R.drawable.java_how_to_program_book,"cp_rating_tips"));
//booksInfo.add(new Book("how to program java","akhter sir",R.drawable.java_how_to_program_book,"how_to_java"));


        adapter=new BookAdapter(this,booksInfo,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView=findViewById(R.id.buetCseResycle);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnClick(int position) {
        //booksInfo.get(position).setPdfData();
        //startActivity(new Intent(BuetCse.this,PdfView.class));

    }
}