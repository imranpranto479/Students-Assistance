package com.example.studentassistant.Aiub;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.studentassistant.Adapters.BookAdapter;
import com.example.studentassistant.Book;
import com.example.studentassistant.MainActivity;
import com.example.studentassistant.R;

import java.util.Vector;

public class AiubTextile extends MainActivity implements BookAdapter.ClickListner{
    RecyclerView recyclerView;
    Vector<Book> booksInfo;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aiub_textile);




        adapter=new BookAdapter(this,booksInfo,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView=findViewById(R.id.aiubTextileResycle);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnClick(int position) {

    }
}