package com.example.studentassistant.Diu;

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


public class DiuCse extends MenuActivity implements BookAdapter.ClickListner{
BookAdapter adapter;
Vector<Book>booksInfo;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diu_cse);
        setTitle("Diu CSE Department");
        recyclerView=findViewById(R.id.resycle);
booksInfo=new Vector<>();


//booksInfo.add(new Book("Competitive Programmers Hand Book","Mr Kotiyana",R.drawable.diu_cse_cphb_book,null));
//booksInfo.add(new Book("Java Programming","Antti Laaksenon",R.drawable.book_diu_cse_java_programming,null));

        booksInfo.add(new Book("Java how to program","Deitel",R.drawable.java_how_to_program_book,"how_to_java"));
booksInfo.add(new Book("Computer Fundamentals","P.K Sinha",R.drawable.book_diu_computer_fundamental,"computer_fundamentals_by_sinha_and_sinha"));
booksInfo.add(new Book("Data Structures and Algorithm Analysis in C","Mark Allen",R.drawable.book_diu_data_structure_and_algorithm_c,"Data Structures and Algorithm Analysis in C"));
booksInfo.add(new Book("Principles of Data Structures using C and C++","Vinu V Das",R.drawable.book_diu_principle_of_data_structure_using_c_cpp,"Principles of Data Structures using C and C++"));









        adapter=new BookAdapter(this,booksInfo,this);

        GridLayoutManager grid=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(grid);
        recyclerView.setAdapter(adapter);





    }


    @Override
    public void OnClick(int position) {
    booksInfo.get(position).setPdfData();
    startActivity(new Intent(DiuCse.this,PdfView.class));

    }

}