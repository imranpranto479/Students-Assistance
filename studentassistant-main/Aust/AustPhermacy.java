package com.example.studentassistant.Aust;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.studentassistant.Adapters.BookAdapter;
import com.example.studentassistant.Book;
import com.example.studentassistant.MenuActivity;
import com.example.studentassistant.R;

import java.util.Vector;

public class AustPhermacy extends MenuActivity implements BookAdapter.ClickListner{
    RecyclerView recyclerView;
    Vector<Book> booksInfo;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aust_phermacy);
booksInfo=new Vector<>();



        adapter=new BookAdapter(this,booksInfo,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView=findViewById(R.id.austPhermacyResycle);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnClick(int position) {

    }
}