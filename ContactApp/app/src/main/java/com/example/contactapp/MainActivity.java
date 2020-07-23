package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.LinkedHashSet;


public class MainActivity extends AppCompatActivity {


    ArrayList<String> alist=new ArrayList<>();
    ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver cr=getContentResolver();
        Cursor cur=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,ContactsContract.Contacts.HAS_PHONE_NUMBER+"=1",null,"UPPER("+ContactsContract.Contacts.DISPLAY_NAME+")ASC");

        if(cur.getCount()>0)
        {
            while(cur.moveToNext())
            {

                String id=cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));

                String name=cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if((Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0 )) {

                    Cursor pcur1=cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI,null,ContactsContract.CommonDataKinds.Email.CONTACT_ID+"=?",new String[]{id},null);

                    while(pcur1.moveToNext())
                    {

                        String phoneNo=pcur1.getString(pcur1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        String email=pcur1.getString(pcur1.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        alist.add("Name:" + name + "\nPhone No:" + phoneNo+"\n Email :"+email);

                    }
                    pcur1.close();}}}
        lv=findViewById(R.id.listview1);
        alist=new ArrayList<String>(new LinkedHashSet<String>(alist));
        ArrayAdapter<String> adt=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alist);
        lv.setAdapter(adt);
    }

}
