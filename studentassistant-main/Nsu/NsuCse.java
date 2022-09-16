package com.example.studentassistant.Nsu;

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

public class NsuCse extends MenuActivity implements BookAdapter.ClickListner{

    RecyclerView recyclerView;
    Vector<Book>bookList;
    BookAdapter adapter;
    public static String pdfName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nsu_cse);



        bookList=new Vector<>();
        bookList.add(new Book("Competitive Programmers Hand Book","Mr. Programmer",R.drawable.diu_cse_cphb_book,null));





        adapter=new BookAdapter(this,bookList,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView=findViewById(R.id.nsuCseResycle);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnClick(int position) {
        if (position==0){
            pdfName="cp_rating_tips.pdf";
            startActivity(new Intent(NsuCse.this, PdfView.class));

        }


        }


    }
