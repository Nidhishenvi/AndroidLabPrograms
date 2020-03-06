package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAlert=findViewById(R.id.btnAlert);

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//select appropriate alertdialog for version below marshmellow the choose android or else androidx
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);

                alertDialog.setTitle("Alert Dialogue");
                alertDialog.setMessage("Welcome");
                alertDialog.setIcon(R.drawable.alert);
                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"user clicked ok",Toast.LENGTH_LONG).show();

                    }
                });




                alertDialog.show();
            }
        });
    }
}
