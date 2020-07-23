package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Size;
import android.util.TypedValue;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout layout=findViewById(R.id.layout);
        TextView tview=new TextView(this);
        layout.addView(tview);
        tview.setText("WELCOME TO RV COLLEGE");
        tview.setTextColor(Color.RED);
        tview.setBackgroundColor(Color.CYAN);
        tview.setTextSize(TypedValue.COMPLEX_UNIT_SP,35f);






    }
}
