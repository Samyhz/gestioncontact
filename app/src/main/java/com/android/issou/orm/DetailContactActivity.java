package com.android.issou.orm;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailContactActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);


        Intent intent = getIntent();
        Long id = intent.getLongExtra("contact_id",0);
        Contact contact = Contact.findById(Contact.class,id);



        String nomContact = contact.getNom();
        String prenomContact = contact.getPrenom();
        int tel = contact.getTelephone();

        EditText text_prenom =  findViewById(R.id.prenom);
        EditText text_nom =  findViewById(R.id.nom);
        EditText text_tel =  findViewById(R.id.telephone);

        text_prenom.setText(prenomContact);
        text_nom.setText(nomContact);
        text_tel.setText(Integer.toString(tel));


        Button button_modifier_contact = (Button)findViewById(R.id.modifier);
        button_modifier_contact.setOnClickListener((View.OnClickListener)this);

        Button button_supprimer_contact = (Button)findViewById(R.id.remove);
        button_supprimer_contact.setOnClickListener((View.OnClickListener)this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.modifier) {
            Intent intent = getIntent();
            Long id = intent.getLongExtra("contact_id",0);
            Contact contact = Contact.findById(Contact.class,id);

            EditText text_prenom =  findViewById(R.id.prenom);
            EditText text_nom =  findViewById(R.id.nom);
            EditText text_tel =  findViewById(R.id.telephone);
            String string_tel = text_tel.getText().toString();

            if(text_tel.length() > 9){
                Toast.makeText(getApplicationContext(),"Format de numéro incompatible (+33) max:9",Toast.LENGTH_SHORT).show();
            }
            else{
                contact.prenom = text_prenom.getText().toString();
                contact.nom = text_nom.getText().toString();
                contact.telephone=Integer.parseInt(text_tel.getText().toString());
                contact.save();
                finish();
            }
        }
        if (view.getId() == R.id.remove)
        {
            Intent intent = getIntent();
            Long id = intent.getLongExtra("contact_id",0);
            Contact contact = Contact.findById(Contact.class,id);
            contact.delete();
            Toast.makeText(getApplicationContext(),"Contact supprimé",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
