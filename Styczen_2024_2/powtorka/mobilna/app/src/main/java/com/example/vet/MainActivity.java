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
    protected EditText daneWlasciciela, celWizyty, godzinaWizyty;
    protected SeekBar ileMaLatSeekBar;
    protected ListView listaGatunkow;
    protected TextView ileMaLat, komunikat;
    protected Button przyciskOK;
    protected String aktualnyZwierzak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daneWlasciciela = findViewById(R.id.imieWlasciciela);
        celWizyty = findViewById(R.id.celWizyty);
        godzinaWizyty = findViewById(R.id.czasWizyty);
        ileMaLat = findViewById(R.id.ileMaLat);
        komunikat = findViewById(R.id.komunikat);
        ileMaLatSeekBar = findViewById(R.id.ileLatSeekBar);
        listaGatunkow = findViewById(R.id.gatunekLista);
        String[] elementy = {"Pies", "Kot", "Świnka morska"};
        int[] wiekMax = {18, 20, 9};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.support.constraint.R.layout.support_simple_spinner_dropdown_item, elementy);
        listaGatunkow.setAdapter(adapter);
        listaGatunkow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int indexMax, long l) {
                aktualnyZwierzak = elementy[indexMax];
                ileMaLatSeekBar.setProgress(0);
                ileMaLat.setText("0");
                ileMaLatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        seekBar.setMax(wiekMax[indexMax]);
                        ileMaLat.setText(""+i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
            }
        });
        przyciskOK = findViewById(R.id.okButton);
        przyciskOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                komunikat.setText(daneWlasciciela.getText()+", "+ aktualnyZwierzak+", "+ileMaLat.getText()+", "+celWizyty.getText()+", "+godzinaWizyty.getText());
            }
        });
    }
}