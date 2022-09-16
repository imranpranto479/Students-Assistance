package com.example.studentassistant.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentassistant.Colors;
import com.example.studentassistant.Home;
import com.example.studentassistant.R;
import com.example.studentassistant.Book;

public class favBookAdapter extends RecyclerView.Adapter<favBookAdapter.holder> {
LayoutInflater inflater;
BookClick bookClick;
public favBookAdapter(Context context,BookClick bookClick){
    this.bookClick=bookClick;
    inflater=LayoutInflater.from(context);
}

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view=inflater.inflate(R.layout.fav_book,parent,false);

        return new holder(view,bookClick);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
    if (Home.favBooks.size()!=0){
        holder.cardView.setCardBackgroundColor(Color.parseColor(Colors.getBookColor()));

        Book temp=Home.favBooks.get(position);
holder.author.setText(temp.getBookAuthor());
holder.title.setText(temp.getBookName());
holder.image.setImageResource(temp.getBookImage());

    }
    else {
        holder.cardView.setCardBackgroundColor(Color.parseColor(Colors.getBookColor()));

        holder.author.setText(" ");
        holder.title.setText("There is no favorite Books!");
        holder.image.setImageResource(R.drawable.black_love);

    }
}

    @Override
    public int getItemCount() {
    if (Home.favBooks.size()==0)
        return 1;
    else return Home.favBooks.size();
    }

    public interface BookClick{
        void onCllick(int position);

    }

    public class holder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView image;
    TextView title,author;
    BookClick click;
    CardView cardView;


        public holder(@NonNull View itemView,BookClick boiClick) {
            super(itemView);
            image=itemView.findViewById(R.id.favBookImage);
            title=itemView.findViewById(R.id.favBookTitle);
            author=itemView.findViewById(R.id.favAuthorName);
            cardView=itemView.findViewById(R.id.favBookCard);
            click=boiClick;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           click.onCllick(getAdapterPosition());
        }
    }
}
