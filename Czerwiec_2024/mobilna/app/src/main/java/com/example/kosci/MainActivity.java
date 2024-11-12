package com.example.kosci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView wynikLosowania, wynikGry;
    Button rzucKoscmi, resetuj;
    ImageView kosc1, kosc2, kosc3, kosc4, kosc5;
    int wynikGryInt, wynikLosowaniaInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wynikLosowania = findViewById(R.id.wynik_tego_losowania);
        wynikGry = findViewById(R.id.wynik_gry);
        rzucKoscmi = findViewById(R.id.rzuc_koscmi);
        resetuj = findViewById(R.id.reset);
        kosc1 = findViewById(R.id.kosc1);
        kosc2 = findViewById(R.id.kosc2);
        kosc3 = findViewById(R.id.kosc3);
        kosc4 = findViewById(R.id.kosc4);
        kosc5 = findViewById(R.id.kosc5);
        wynikGryInt = 0;
        wynikLosowaniaInt = 0;
        int[] kosciResIds = {
                R.drawable.kosc1,
                R.drawable.kosc2,
                R.drawable.kosc3,
                R.drawable.kosc4,
                R.drawable.kosc5,
                R.drawable.kosc6
        };

        rzucKoscmi.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Random random = new Random();
                        int[] wylosowane = new int[5];
                        for (int i = 0; i < 5; i++) {
                            wylosowane[i] = random.nextInt(6)+1;
                        }
                        wynikLosowaniaInt = 0;
                        int[] iloscWystapien = {0,0,0,0,0,0};

                        for(int i=0; i<6; i++){
                            for (int j=0; j< wylosowane.length; j++){
                                if(wylosowane[j] == i+1){
                                    iloscWystapien[i]++;
                                }
                            }
                            if(iloscWystapien[i] > 1){
                                wynikLosowaniaInt += (i+1)*iloscWystapien[i];
                            }
                        }
                        wynikGryInt += wynikLosowaniaInt;

                        kosc1.setImageResource(kosciResIds[wylosowane[0] - 1]);
                        kosc2.setImageResource(kosciResIds[wylosowane[1] - 1]);
                        kosc3.setImageResource(kosciResIds[wylosowane[2] - 1]);
                        kosc4.setImageResource(kosciResIds[wylosowane[3] - 1]);
                        kosc5.setImageResource(kosciResIds[wylosowane[4] - 1]);

                        wynikLosowania.setText("Wynik tego losowania: "+wynikLosowaniaInt);
                        wynikGry.setText("Wynik gry: "+wynikGryInt);
                    }
                }
        );
        resetuj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        kosc1.setImageResource(R.drawable.question);
                        kosc2.setImageResource(R.drawable.question);
                        kosc3.setImageResource(R.drawable.question);
                        kosc4.setImageResource(R.drawable.question);
                        kosc5.setImageResource(R.drawable.question);
                        wynikLosowaniaInt = 0;
                        wynikGryInt = 0;
                        wynikLosowania.setText("Wynik tego losowania: "+wynikLosowaniaInt);
                        wynikGry.setText("Wynik gry: "+wynikGryInt);
                    }
                }
        );
    }
}