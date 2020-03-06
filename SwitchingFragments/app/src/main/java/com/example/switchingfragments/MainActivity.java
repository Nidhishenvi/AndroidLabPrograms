package com.example.switchingfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    Button b1;

    int showingFragment=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentOne=new FragmentOne();
        fragmentTwo=new FragmentTwo();
        b1=(Button)findViewById(R.id.button1);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.clayout,fragmentOne);
        fragmentTransaction.commit();
        showingFragment=1;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                if(showingFragment==1) {
                    fragmentTransaction.replace(R.id.clayout, fragmentTwo);
                    showingFragment = 2;

                }
                else
                {
                    fragmentTransaction.replace(R.id.clayout, fragmentOne);
                    showingFragment = 1;

                }
                fragmentTransaction.commit();
            }
        });

    }
}
