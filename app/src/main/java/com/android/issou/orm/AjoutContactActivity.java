package com.android.issou.orm;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AjoutContactActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_contact);



        Button button_ajout_contact = (Button)findViewById(R.id.ajoutContact);
        button_ajout_contact.setOnClickListener((View.OnClickListener)this);



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ajoutContact) {

            EditText text_telephone=(EditText)findViewById(R.id.telephone);
            EditText text_prenom=(EditText)findViewById(R.id.prenom);
            EditText text_nom=(EditText)findViewById(R.id.nom);

            int telephone = Integer.parseInt(text_telephone.getText().toString());
            String prenom = text_prenom.getText().toString();
            String nom = text_nom.getText().toString();


            Contact contact = new Contact(telephone,prenom, nom);

            Log.i("DEBUG:",String.valueOf(contact.getTelephone()));
            Log.i("DEBUG:",contact.getPrenom());
            Log.i("DEBUG:",contact.getPrenom());

            contact.save();
            Toast.makeText(this, "Ajout éffectuer", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}
