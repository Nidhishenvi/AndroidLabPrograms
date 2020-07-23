package com.example.movie;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText movienme,movietme;
    TextView txtview;
    db_controller controller;
    String res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movienme=findViewById(R.id.moviename);
        movietme=findViewById(R.id.movietime);
        txtview=findViewById(R.id.txtview);
        controller=new db_controller(this,"",null,1);

    }


    public void btn_click(View view) {
        switch(view.getId())
        {
            case R.id.btnadd:
                try
                {
                    controller.insert_movie(movienme.getText().toString(),movietme.getText().toString());
                    Toast.makeText(this,"!!Movie Ticket Booked Sucessfully!!",Toast.LENGTH_LONG).show();
                }
                catch(SQLiteException e)
                {
                    Toast.makeText(MainActivity.this,"!!Alredy Booked Movie!!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btndelete:
                controller.delete_movie(movienme.getText().toString());
                Toast.makeText(MainActivity.this,"!!Movie Cancled!!",Toast.LENGTH_LONG).show();

                break;
            case R.id.btnupdate:
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("!!ENTER NEW_MOVIENAME!!");
                final EditText new_moviename=new EditText(this);
                dialog.setView(new_moviename);
                dialog.setPositiveButton("!OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        controller.update_movie(movienme.getText().toString(),new_moviename.getText().toString());
                    }
                });
                dialog.show();
                break;
            case R.id.btnlist:
                controller.list_all_movie(txtview);
                break;

        }

    }
}
