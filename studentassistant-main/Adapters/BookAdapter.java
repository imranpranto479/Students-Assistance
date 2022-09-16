package com.example.studentassistant.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentassistant.Colors;
import com.example.studentassistant.Home;
import com.example.studentassistant.R;
import com.example.studentassistant.Book;

import java.util.Vector;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
int p;

    LayoutInflater inflater;
    ClickListner clickListner;
Vector<Book> booksInfo;
Context context;


int love[];
    public BookAdapter(Context context, Vector<Book>booksInfo, ClickListner clickListner){

        this.booksInfo=booksInfo;
        this.clickListner=clickListner;
        this.context=context;
        inflater=LayoutInflater.from(context);
love =new int[2];
love[0]=R.drawable.black_love;
love[1]=R.drawable.red_love;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.book_adapter,parent,false);
        return new ViewHolder(view,clickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardView.setCardBackgroundColor(Color.parseColor(Colors.getBookColor()));
holder.title.setText(booksInfo.get(position).getBookName());
holder.author.setText(booksInfo.get(position).getBookAuthor());
holder.imageView.setImageResource(booksInfo.get(position).getBookImage());

boolean con=true;

if (Home.favBooks!=null){
for (int i=0;i<Home.favBooks.size();i++){
    if (Home.favBooks.get(i).getBookName().equals(booksInfo.get(position).getBookName())){

        holder.fav.setBackgroundResource(love[1]);


        p=0;
        con=false;
    }


}
if (con){
    holder.fav.setBackgroundResource(love[0]);
    p=1;
}

}
else{

    holder.fav.setBackgroundResource(love[0]);

    p=1;


}

/*if (Home.diuCseFav[position]){

    holder.fav.setBackgroundResource(love[1]);


    p=0;

}
else {
    holder.fav.setBackgroundResource(love[0]);

p=1;
}*/



    }

    @Override
    public int getItemCount() {
        return booksInfo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title,author;
        ImageView imageView,fav;
        ClickListner listner;
        CardView cardView;



        public ViewHolder(@NonNull View itemView,final ClickListner click) {
            super(itemView);
            imageView=itemView.findViewById(R.id.favBookImage);
            title=itemView.findViewById(R.id.favBookTitle);
            author=itemView.findViewById(R.id.favAuthorName);
            cardView=itemView.findViewById(R.id.bookCard);
fav=itemView.findViewById(R.id.favBtn);
listner=click;
            itemView.setOnClickListener(this);
fav.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        if (click!=null){
            int pos=getAdapterPosition();
            if (pos!=RecyclerView.NO_POSITION){
        fav.setBackgroundResource(love[p%2]);
        if (p==1) {

            Home.favBooks.add(booksInfo.get(pos));
            Toast.makeText(context,"Book is added on your favorite list.",Toast.LENGTH_SHORT).show();
        }
        else {

            String temp=booksInfo.get(pos).getBookName();

            for (int i=0;i<Home.favBooks.size();i++){
                Book a=Home.favBooks.get(i);
                if (a.getBookName().equals(temp)){
                    Home. favBooks.remove(i);
                    Toast.makeText(context,"Book is removed from your favorite list.",Toast.LENGTH_SHORT).show();
                }
            }

        }
        p++;

    }
        }
    }
});


        }

        @Override
        public void onClick(View v) {

            listner.OnClick(getAdapterPosition());
        }
    }

   public interface ClickListner{
        void OnClick(int position);


    }

}
