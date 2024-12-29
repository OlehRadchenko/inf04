package com.example.czcionki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected TextView rozmiar, cytat;
    protected SeekBar rozmiarSeekBar;
    protected Button nastepnyCytat;
    static protected String[] cytaty = {"Dzień dobry", "Good morning", "Buenos dias"};
    protected int aktualnyCytat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rozmiar = findViewById(R.id.rozmiar);
        cytat = findViewById(R.id.cytat);
        rozmiarSeekBar = findViewById(R.id.rozmiarSeekBar);
        nastepnyCytat = findViewById(R.id.przycisk);
        aktualnyCytat = 0;
        cytat.setText(cytaty[aktualnyCytat]);
        nastepnyCytat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aktualnyCytat++;
                if(aktualnyCytat > 2){
                    aktualnyCytat = 0;
                }
                cytat.setText(cytaty[aktualnyCytat]);
            }
        });
        rozmiarSeekBar.setMax(40);
        rozmiarSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                rozmiar.setText("Rozmiar: "+i);
                cytat.setTextSize(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}