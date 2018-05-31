package com.android.issou.orm;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutContactActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_contact);
        Button button_ajout_contact = (Button) findViewById(R.id.ajoutContact);
        button_ajout_contact.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ajoutContact) {

            EditText text_telephone = (EditText) findViewById(R.id.telephone);
            EditText text_prenom = (EditText) findViewById(R.id.prenom);
            EditText text_nom = (EditText) findViewById(R.id.nom);

            String prenom = text_prenom.getText().toString();
            String nom = text_nom.getText().toString();
            String string_tel = text_telephone.getText().toString();

            if (string_tel.matches("") || nom.matches("") || prenom.matches("")) {
                Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            } else {
                int telephone = Integer.parseInt(text_telephone.getText().toString());
                Contact contact = new Contact(telephone, prenom, nom);
                contact.save();
                Toast.makeText(this, "Ajout éffectuer", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

}
