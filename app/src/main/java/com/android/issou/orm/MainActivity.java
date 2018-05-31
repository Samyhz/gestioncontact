package com.android.issou.orm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ajouter_contact_button = (Button) findViewById(R.id.addContact);
        Button recherche_button = (Button) findViewById(R.id.recherche_contact);

        ajouter_contact_button.setOnClickListener((View.OnClickListener) this);
        recherche_button.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.addContact) {
            Intent intent = new Intent(this, AjoutContactActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.recherche_contact) {
            Intent intent = new Intent(this, RechercheContactActivity.class);
            startActivity(intent);
        }
    }
}
