package com.example.studentassistant;

import android.os.Bundle;
import android.widget.Toast;

import com.example.studentassistant.MenuActivity;
import com.example.studentassistant.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class PdfView extends MenuActivity {
PDFView pdf;
public static String bookTitle;
public static String pdfName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_book);



        setTitle(bookTitle);
        pdf=findViewById(R.id.pdfView);
       pdf.fromAsset(pdfName).defaultPage(0).enableAnnotationRendering(true).scrollHandle(new DefaultScrollHandle(this))
               .spacing(2).load();

    }


}