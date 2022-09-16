package com.example.studentassistant.Aiub;

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

public class AiubCse extends MenuActivity implements BookAdapter.ClickListner{
    RecyclerView recyclerView;
   Vector<Book>booksInfo;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aiub_cse);
        booksInfo=new Vector<>();

        booksInfo.add(new Book("Algorithms and Data Structure","Kurt Mehlhorn and Peter Sanders",R.drawable.book_aiub_datastructure_and_algorithm,
                "algorithms_and_data_structures"));
        booksInfo.add(new Book("C++ Primer Plus","Stephen Prata",R.drawable.book_aiub_cpp_primer,"cpp_primer_plus"));
        booksInfo.add(new Book("Object Oriented Programming","Dr Robert Harle",R.drawable.book_aiub_oop,"oop"));
        booksInfo.add(new Book("Software design","David Budgen",R.drawable.book_aiub_software_design,"software_design"));




        adapter=new BookAdapter(this,booksInfo,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView=findViewById(R.id.aiubCseResycle);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnClick(int position) {
        booksInfo.get(position).setPdfData();
        startActivity(new Intent(AiubCse.this, PdfView.class));

    }
}