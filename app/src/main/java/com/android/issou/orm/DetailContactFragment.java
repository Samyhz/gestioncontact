package com.android.issou.orm;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailContactFragment extends Fragment implements View.OnClickListener {

    EditText tel_text;

    public DetailContactFragment() {
    }

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.details_fragment, container, false);

        final EditText nom = (EditText) view.findViewById(R.id.nom);
        final EditText prenom = (EditText) view.findViewById(R.id.prenom);
        final EditText tel_text = (EditText) view.findViewById(R.id.tel);

        Button button_modifier_contact = view.findViewById(R.id.modifier);
        button_modifier_contact.setOnClickListener((View.OnClickListener) this);

        Button button_supprimer_contact = view.findViewById(R.id.remove);
        button_supprimer_contact.setOnClickListener((View.OnClickListener) this);

        long id = getArguments().getLong("id");
        Contact contact = Contact.findById(Contact.class, id);
        String nomContact = contact.getNom();
        String prenomContact = contact.getPrenom();
        int tel = contact.getTelephone();

        nom.setText(nomContact);
        prenom.setText(prenomContact);
        tel_text.setText(Integer.toString(tel));

        final Button button =
                (Button) view.findViewById(R.id.modifier);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                long id = getArguments().getLong("id");
                Contact contact = Contact.findById(Contact.class, id);

                String string_tel = tel_text.getText().toString();
                String string_nom = nom.getText().toString();
                String string_prenom = prenom.getText().toString();

                if (tel_text.length() > 9) {
                    Toast.makeText(getActivity(), "Format de numéro incompatible (+33) max:9", Toast.LENGTH_SHORT).show();
                }
                if (string_tel.matches("") || string_nom.matches("") || string_prenom.matches("")) {
                    Toast.makeText(getActivity(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    contact.prenom = prenom.getText().toString();
                    contact.nom = nom.getText().toString();
                    contact.telephone = Integer.parseInt(tel_text.getText().toString());
                    contact.save();
                    getActivity().recreate();
                }
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.remove) {
            long id = getArguments().getLong("id");
            Contact contact = Contact.findById(Contact.class, id);
            contact.delete();
            Toast.makeText(getActivity(), "Contact supprimé", Toast.LENGTH_SHORT).show();
            getActivity().getFragmentManager().beginTransaction().remove(this).commit();
            getActivity().recreate();
        }
    }
}
