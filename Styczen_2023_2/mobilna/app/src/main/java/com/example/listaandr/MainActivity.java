package com.example.listaandr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected Button dodaj;
    protected EditText element;
    protected List<String> notatki = new ArrayList<>(Arrays.asList(new String[]{"Zakupy: chleb, masło, ser", "Do zrobienia: obiad, umyć podłogi", "weekend: kino, spacer z psem"}));
    protected ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dodaj = findViewById(R.id.dodaj);
        element = findViewById(R.id.element);
        listView = findViewById(R.id.lista);
        zaaktualizujListe();
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notatki.add(String.valueOf(element.getText()));
                zaaktualizujListe();
            }
        });
    }

    protected void zaaktualizujListe() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.support.constraint.R.layout.support_simple_spinner_dropdown_item, notatki);
        listView.setAdapter(adapter);
    }
}