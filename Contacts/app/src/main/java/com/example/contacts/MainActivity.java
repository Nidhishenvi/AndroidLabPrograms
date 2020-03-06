package com.example.contacts;
//make it relative layout, choose listview, change the id of listview as listeview1
//give permission in manifest.xml file
//as you install go to settings-> apps ->give permissions
//try to sort it in alphabetical order
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> alist= new ArrayList<>();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver cr=getContentResolver();
        Cursor cur=cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        if(cur.getCount()>0)
        {
            while(cur.moveToNext()) {
                String id = cur.getString(cur.getColumnIndex((ContactsContract.Contacts._ID)));
                String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?", new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                        alist.add("Name" + name + "\nPhone no:" + phoneNo);
                    }
                    pCur.close();
                }
            }

        }
        lv=(ListView)findViewById(R.id.listview1);
        ArrayAdapter<String> adt=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alist);
        lv.setAdapter(adt);

    }

        }



