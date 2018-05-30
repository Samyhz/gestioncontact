package com.android.issou.orm;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class RechercheContactActivity extends AppCompatActivity {


    SimpleAdapter adapter;
    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_contact);

        final List<Contact> contacts = Contact.listAll(Contact.class);

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            String nomContact = c.getNom();
            String prenomContact = c.getPrenom();
            addItem(nomContact,prenomContact);
        }

        final ListView liste = (ListView) findViewById(R.id.list_contact);


        adapter = new SimpleAdapter(this,
                data,
                R.layout.cell_content,
                new String[]{"name", "firstname"},
                new int[]{R.id.textView_name,
                        R.id.textView_firstname});

        liste.setAdapter(adapter);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getApplicationContext(),"LANDSCAPE",Toast.LENGTH_SHORT).show();
        }
        else
            {
                liste.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View v, int position,
                                            long arg3)
                    {
                        Contact c = contacts.get(position);
                    /*String nomContact = c.getNom();
                    String prenomContact = c.getPrenom();
                    int tel = c.getTelephone();*/

                        long id = c.getId();


                        Intent intent = new Intent(RechercheContactActivity.this, DetailContactActivity.class);
                        intent.putExtra("contact_id",id);
                        startActivity(intent);
                    }
                });

        }



    }



    private void addItem(String record_name, String record_fname) {
        HashMap<String,String> item = new HashMap<String,String>();
        item.put("name", record_name);
        item.put("firstname", record_fname);
        data.add(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }
}
