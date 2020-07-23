package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuselect,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        ConstraintLayout cl=findViewById(R.id.clayout);

        switch(menuItem.getItemId())
        {
            case R.id.red:
                cl.setBackgroundColor(Color.RED);
                return true;

            case R.id.blue:
                cl.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.green:
                cl.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.yellow:
                cl.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.black:
                cl.setBackgroundColor(Color.BLACK);
                return true;

            default:
                    super.onOptionsItemSelected(menuItem);

        }
        return false;
    }


}
