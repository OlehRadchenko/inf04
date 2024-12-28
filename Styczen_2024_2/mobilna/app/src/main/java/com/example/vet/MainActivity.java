package com.example.vet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected TextView ileLat, wynik;
    protected SeekBar ileLatSeekBar;
    protected EditText wlasciciel, cel, godzina;
    protected ListView listaGatunek;
    protected Button okPrzycisk;
    protected String zwierzak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ileLat = findViewById(R.id.ileLat);
        wynik = findViewById(R.id.wynik);
        wlasciciel = findViewById(R.id.wlasciciel);
        cel = findViewById(R.id.cel);
        godzina = findViewById(R.id.godzina);
        okPrzycisk = findViewById(R.id.okPrzycisk);
        ileLatSeekBar = findViewById(R.id.ileLatSeekBar);
        listaGatunek = findViewById(R.id.gatunekLista);
        String[] zwierzeta = {"Pies", "Kot", "Świnka morska"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.support.constraint.R.layout.support_simple_spinner_dropdown_item, zwierzeta);
        listaGatunek.setAdapter(arrayAdapter);
        listaGatunek.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                zwierzak = (String) listaGatunek.getItemAtPosition(i);
                switch (zwierzak){
                    case "Pies":
                        ileLatSeekBar.setMax(18);
                        break;
                    case "Kot":
                        ileLatSeekBar.setMax(20);
                        break;
                    default:
                        ileLatSeekBar.setMax(9);
                }
            }
        });
        ileLatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ileLat.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        okPrzycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wynik.setText(wlasciciel.getText() + ", " + zwierzak + ", " + ileLat.getText() + ", " + cel.getText() + ", " + godzina.getText());
            }
        });
    }
}