package com.example.hollyquran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.hollyquran.Adapter.Quran_Adapter;
import com.example.hollyquran.Adapter.Read_adapter;
import com.example.hollyquran.Model.Quran_Model;
import com.example.hollyquran.Model.Read_model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Read_Quran extends AppCompatActivity {
    RecyclerView recyclerView;
    Read_adapter read_adapter;
    RecyclerView.LayoutManager layoutManager;
    //List<Read_model> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read__quran);
       // ReadQuran();
        String fileName = getIntent().getStringExtra("file_name");
        Log.e("position", fileName);
         ArrayList<String> allVerses =  ReadSura(fileName);
        Log.e("content", ""+allVerses.get(0));
        recyclerView=findViewById(R.id.recyclerviewRead);
        read_adapter=new Read_adapter(allVerses);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(read_adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

  public ArrayList<String> ReadSura(String fileName){
        ArrayList<String>arraylist = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                if (!mLine.trim().equals(""))
                    arraylist.add(mLine);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        return arraylist;
    }
//    public void ReadQuran()
//    {
//        items =new ArrayList<>();
//        for(int i=0;i<=50;i++)
//        {
//            items.add(i,new Read_model(R.drawable.lineqa,"بسم الله الرحمن الرحيم"));
//        }
//    }
}
