package com.example.studentassistant;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentassistant.Adapters.HomeAdapter;
import com.example.studentassistant.Aiub.AiubDepartments;
import com.example.studentassistant.Aiub.AiubInfo;
import com.example.studentassistant.Aust.AustDepartments;
import com.example.studentassistant.Aust.AustInfo;
import com.example.studentassistant.Brac.BracDepartments;
import com.example.studentassistant.Brac.BracInfo;
import com.example.studentassistant.Buet.BuetDepartments;
import com.example.studentassistant.Buet.BuetInfo;
import com.example.studentassistant.Diu.DiuInfo;
import com.example.studentassistant.Nsu.NsuDepartments;
import com.example.studentassistant.Diu.DiuDepartments;
import com.example.studentassistant.Nsu.NsuInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Home extends MenuActivity implements HomeAdapter.onVersityClick {
    RecyclerView resycle;
    List<String>names;
    List<Integer>images;
    public static Vector<Book> favBooks;
    public static boolean diuCseFav[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
favBooks=new Vector<>();
diuCseFav=new boolean[100];
        Arrays.fill(diuCseFav,false);
        names= new ArrayList<>();
        images=new ArrayList<>();
        names.add("Bangladesh University of Engineering and Technology");
        names.add("Daffodil International University");
        names.add("BRAC University");
        names.add("North South University");
        names.add("American International University-Bangladesh");
        names.add("Ahsanullah University of Science and Technology");

        images.add(R.drawable.buet_icon);
        images.add(R.drawable.diu_icon);
        images.add(R.drawable.brac_icon);
        images.add(R.drawable.nsu_icon);
        images.add(R.drawable.aiub_icon);
        images.add(R.drawable.aust_icon);




        HomeAdapter adapter=new HomeAdapter(this,names,images,this);
        GridLayoutManager layoutManager=new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        resycle=findViewById(R.id.homeResycle);
        resycle.setLayoutManager(layoutManager);
        resycle.setAdapter(adapter);



    }

    @Override
    public void onClick(int position) {
        if (position==0)startActivity(new Intent(Home.this, BuetDepartments.class));
        if (position==1)startActivity(new Intent(Home.this, DiuDepartments.class));

        if (position==2)startActivity(new Intent(Home.this, BracDepartments.class));
        if (position==3)startActivity(new Intent(Home.this, NsuDepartments.class));

        if (position==4)startActivity(new Intent(Home.this, AiubDepartments.class));
        if (position==5)startActivity(new Intent(Home.this, AustDepartments.class));
    }

    @Override
    public void onInfoClick(int positon) {
        if (positon==0){
            startActivity(new Intent(Home.this, BuetInfo.class));
        }
        if (positon==1)startActivity(new Intent(Home.this, DiuInfo.class));
        if (positon==2)startActivity(new Intent(Home.this, BracInfo.class));
        if (positon==3)startActivity(new Intent(Home.this, NsuInfo.class));
        if (positon==4)startActivity(new Intent(Home.this, AiubInfo.class));
        if (positon==5)startActivity(new Intent(Home.this, AustInfo.class));
    }
}