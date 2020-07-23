package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button login;
    TextView info;
    int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        info=findViewById(R.id.tvinfo);
        username.setInputType(InputType.TYPE_CLASS_TEXT);
        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        info.setText("No of attempts remaining:3");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(),password.getText().toString());
            }
        });
    }

    private void validate(String userName,String userPassword){
        if((userName.equals("admin"))&&(userPassword.equals("123"))){
            //Toast.makeText(MainActivity.this,"Successfully logged in",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else{
            counter--;
            info.setText("No of attempts remaining:"+String.valueOf(counter));
            Toast.makeText(MainActivity.this,"Invalid user",Toast.LENGTH_LONG).show();
            if(counter==0){
                login.setEnabled(false);
            }
        }
    }
}
