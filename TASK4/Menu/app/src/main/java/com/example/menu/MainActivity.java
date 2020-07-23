package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
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
        public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;


        }

        public boolean onOptionsItemSelected(MenuItem item){

            ConstraintLayout c1=findViewById(R.id.clayout);
            switch(item.getItemId())
            {
                case R.id.item1 :
                    Intent intent=new Intent(MainActivity.this,item1.class);
                    startActivity(intent);
                    return true;
                case R.id.item2:
                    Intent intent1=new Intent(MainActivity.this,item2.class);
                    startActivity(intent1);
                    return true;
                case R.id.item3:
                    Intent intent3=new Intent(MainActivity.this,item3.class);
                    startActivity(intent3);
                    return true;
                case R.id.subitem1:
                    Intent intent4=new Intent(MainActivity.this,subitem1.class);
                    startActivity(intent4);
                default:
                    return super.onOptionsItemSelected(item);

        }

    }
}
