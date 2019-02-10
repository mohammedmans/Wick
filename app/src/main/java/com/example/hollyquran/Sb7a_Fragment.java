package com.example.hollyquran;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sb7a_Fragment extends Fragment {

    Button buttoncounter;
    Button   button12;
    ImageView refreash;
    public Sb7a_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,


                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_sb7a_, container, false);
          buttoncounter=view.findViewById(R.id.counter);
          refreash=view.findViewById(R.id.refreash);
          button12=view.findViewById(R.id.button12);
            buttoncounter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   String text;
                           text= (String) buttoncounter.getText();
                    int result = Integer.parseInt(text);
                    result++;
                    text= String.valueOf(result);
                    buttoncounter.setText(text);

                }
            });
            refreash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text;
                    text= (String) buttoncounter.getText();
                    buttoncounter.setText("0");
                    button12.setText(text);
                }
            });




         return view;
    }

}
