package com.example.sms;
//edit text,edit text2,button
//use intent
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button send;
    EditText num,msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        send=(Button)findViewById(R.id.send);
        msg=(EditText)findViewById(R.id.msg);
        num=(EditText)findViewById(R.id.num);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSmsByIntent();
            }
        });
    }
    public void sendSmsByIntent()
    {
        Uri uri=Uri.parse("smsto:" +num.getText().toString());
        Intent smsIntent=new Intent(Intent.ACTION_SENDTO,uri);

        smsIntent.putExtra("sms_body",msg.getText().toString());
        try
        {
            startActivity(smsIntent);
        }
        catch (Exception ex)
        {
            Toast.makeText(MainActivity.this,"your sms has failed",Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
}
