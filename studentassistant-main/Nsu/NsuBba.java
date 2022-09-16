package com.example.studentassistant.Nsu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentassistant.Adapters.BookAdapter;
import com.example.studentassistant.Book;
import com.example.studentassistant.MenuActivity;
import com.example.studentassistant.PdfView;
import com.example.studentassistant.R;

import java.util.Vector;

public class NsuBba extends MenuActivity implements BookAdapter.ClickListner {

    RecyclerView recyclerView;
    Vector<Book> bookList;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nsu_bba);
        bookList=new Vector<>();

        bookList.add(new Book("International Finance","Maurice D. Levi",R.drawable.book_nsu_international_finance,"International Finance ( nsu bbs)"));
bookList.add(new Book("Analysis of Financial Statement","Prof.Dr. Saoud Chayed",R.drawable.book_nsu_financial_statment,"analysis_of_financial_statements"));
bookList.add(new Book("Mathematical Economics","Vasily E. Tarasov",R.drawable.book_nsu_mathematical_economics,"Mathematical_Economics"));
bookList.add(new Book("Strategic Management","Neil Ritson",R.drawable.book_nsu_strategic_menagement,"Strategic Management Book"));


        adapter=new BookAdapter(this,bookList,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView=findViewById(R.id.nsuBbaResycle);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnClick(int position) {

        bookList.get(position).setPdfData();
        startActivity(new Intent(NsuBba.this, PdfView.class));

    }
}