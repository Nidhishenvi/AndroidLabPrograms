package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText opr1,opr2,txtresult;
    Button btnadd,btnsub,btnmul,btndiv,clear;
    double oper1,oper2,res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opr1=(EditText)findViewById(R.id.editText1);
        opr2=(EditText)findViewById(R.id.editText2);
        btnadd=(Button)findViewById(R.id.button1);
        btnsub=(Button)findViewById(R.id.button2);
        btnmul=(Button)findViewById(R.id.button3);
        btndiv=(Button)findViewById(R.id.button4);
        clear=(Button)findViewById(R.id.button5);
        txtresult=(EditText)findViewById(R.id.editText3) ;

        opr1.setInputType(InputType.TYPE_CLASS_NUMBER);
        opr2.setInputType(InputType.TYPE_CLASS_NUMBER);
       btnadd.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               if((opr1.getText().length()>0)&&(opr2.getText().length()>0))
               {
                   fetch();
                   res=oper1+oper2;
                   txtresult.setText(Double.toString(res));
               }
               else {
                   toastCreate();
               }
               }

       });


        btnsub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if((opr1.getText().length()>0)&&(opr2.getText().length()>0))
                {
                    fetch();
                    res=oper1-oper2;
                    txtresult.setText(Double.toString(res));
                }
                else {
                    toastCreate();
                }
            }

        });

        btnmul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if((opr1.getText().length()>0)&&(opr2.getText().length()>0))
                {
                    fetch();
                    res=oper1*oper2;
                    txtresult.setText(Double.toString(res));
                }
                else {
                    toastCreate();
                }
            }

        });


        btndiv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if((opr1.getText().length()>0)&&(opr2.getText().length()>0))
                {
                    fetch();
                    res=oper1/oper2;
                    txtresult.setText(Double.toString(res));
                }
                else {
                    toastCreate();
                }
            }

        });
        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                opr1.setText("");
                opr2.setText("");
                txtresult.setText("");
                opr1.requestFocus();
            }

        });

    }
    public void fetch()
    {
        oper1=Double.parseDouble(opr1.getText().toString());
        oper2=Double.parseDouble(opr2.getText().toString());
    }
    public void toastCreate()
    {
        Toast.makeText(MainActivity.this,"enter required number!",Toast.LENGTH_LONG).show();
    }
}
