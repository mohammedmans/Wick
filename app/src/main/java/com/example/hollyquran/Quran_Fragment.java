package com.example.hollyquran;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hollyquran.Adapter.Quran_Adapter;
import com.example.hollyquran.Model.Quran_Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Quran_Fragment extends Fragment {
    public static  String []ArSuras={"الفاتحه","البقرة","آل عمران","النساء","المائدة","الأنعام","الأعراف","الأنفال","التوبة","يونس","هود"
            ,"يوسف","الرعد","إبراهيم","الحجر","النحل","الإسراء","الكهف","مريم","طه","الأنبياء","الحج","المؤمنون"
            ,"النّور","الفرقان","الشعراء","النّمل","القصص","العنكبوت","الرّوم","لقمان","السجدة","الأحزاب","سبأ"
            ,"فاطر","يس","الصافات","ص","الزمر","غافر","فصّلت","الشورى","الزخرف","الدّخان","الجاثية","الأحقاف"
            ,"محمد","الفتح","الحجرات","ق","الذاريات","الطور","النجم","القمر","الرحمن","الواقعة","الحديد","المجادلة"
            ,"الحشر","الممتحنة","الصف","الجمعة","المنافقون","التغابن","الطلاق","التحريم","الملك","القلم","الحاقة","المعارج"
            ,"نوح","الجن","المزّمّل","المدّثر","القيامة","الإنسان","المرسلات","النبأ","النازعات","عبس","التكوير","الإنفطار"
            ,"المطفّفين","الإنشقاق","البروج","الطارق","الأعلى","الغاشية","الفجر","البلد","الشمس","الليل","الضحى","الشرح"
            ,"التين","العلق","القدر","البينة","الزلزلة","العاديات","القارعة","التكاثر","العصر",
            "الهمزة","الفيل","قريش","الماعون","الكوثر","الكافرون","النصر","المسد","الإخلاص","الفلق","الناس"};
    RecyclerView recyclerView;
    Quran_Adapter quran_adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Quran_Model> items;



    public Quran_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quran_, container, false);
        create_Quran_Fragment();
        recyclerView=view.findViewById(R.id.recyclerview);
        quran_adapter=new Quran_Adapter(items);
        layoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(quran_adapter);
        recyclerView.setLayoutManager(layoutManager);
        quran_adapter.setImageOnItemClick(new Quran_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, Quran_Model Quran) {

                Intent i=new Intent(getActivity(),Read_Quran.class );
                i.putExtra("file_name",(pos+1)+".txt");
                //Log.e("position", ""+(pos+1)+".txt");


                startActivity(i);

            }
        });




        return view;
    }


    public void  create_Quran_Fragment()
    {
        items=new ArrayList<>();
        for(int i=0;i<ArSuras.length;i++)
        {
            items.add(new Quran_Model(R.drawable.back1,ArSuras[i]));
        }


    }


}
