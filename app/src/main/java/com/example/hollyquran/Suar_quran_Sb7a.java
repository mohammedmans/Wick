package com.example.hollyquran;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Suar_quran_Sb7a extends AppCompatActivity {

    Fragment fragment= null;
 BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
         =new BottomNavigationView.OnNavigationItemSelectedListener() {
     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
         if(menuItem.getItemId()==R.id.navigation_home)
         {
             fragment= new Quran_Fragment();
         }
         else if (menuItem.getItemId()==R.id.navigation_dashboard)
         {
             fragment= new Sb7a_Fragment();
         }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer,fragment).commit();

         return true;
     }
 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suar_quran_sb7a);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);



    }

}
