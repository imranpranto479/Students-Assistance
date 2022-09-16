package com.example.studentassistant;

public class Book {
    public String bookName,bookAuthor;
    public int bookImage;
    public String pdfName;
    public Book(String bookName, String authorName, int bookImage,String pdfName){
        this.bookName=bookName;
        this.bookAuthor=authorName;
        this.bookImage=bookImage;
        this.pdfName=pdfName;

    }
    public String getBookName(){
        return bookName;
    }
    public String getBookAuthor(){
        return bookAuthor;
    }
    public int getBookImage(){
        return bookImage;
    }
    public String getPdfName(){
        return pdfName;
    }

    public void setPdfData(){

        PdfView.pdfName=pdfName+".pdf";
        PdfView.bookTitle=bookName;

    }

}
