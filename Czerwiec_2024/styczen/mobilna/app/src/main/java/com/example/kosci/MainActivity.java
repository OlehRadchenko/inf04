package com.example.kosci;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    protected TextView wynikLosowania, wynikGry;
    protected Button rzut, reset;
    protected int[] wyrzuconeKosci = new int[5];
    protected int wynikGryInt;
    protected int wynikRundy;
    protected ImageView[] zdjeciaKostek = new ImageView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wynikLosowania = findViewById(R.id.wynikLosowania);
        wynikGry = findViewById(R.id.wynikGry);
        rzut = findViewById(R.id.rzucKoscmi);
        reset = findViewById(R.id.reset);
        zdjeciaKostek[0] = findViewById(R.id.kosc1);
        zdjeciaKostek[1] = findViewById(R.id.kosc2);
        zdjeciaKostek[2] = findViewById(R.id.kosc3);
        zdjeciaKostek[3] = findViewById(R.id.kosc4);
        zdjeciaKostek[4] = findViewById(R.id.kosc5);
        wynikGryInt = 0;

        rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                wynikRundy = 0;
                int[] oczka = new int[6];
                for(int i=0; i<wyrzuconeKosci.length; i++){
                    wyrzuconeKosci[i] = random.nextInt(6)+1;
                    switch (wyrzuconeKosci[i]){
                        case 1:
                            zdjeciaKostek[i].setImageResource(R.drawable.kosc1);
                            break;
                        case 2:
                            zdjeciaKostek[i].setImageResource(R.drawable.kosc2);
                            break;
                        case 3:
                            zdjeciaKostek[i].setImageResource(R.drawable.kosc3);
                            break;
                        case 4:
                            zdjeciaKostek[i].setImageResource(R.drawable.kosc4);
                            break;
                        case 5:
                            zdjeciaKostek[i].setImageResource(R.drawable.kosc5);
                            break;
                        case 6:
                            zdjeciaKostek[i].setImageResource(R.drawable.kosc6);
                            break;
                        default:
                            zdjeciaKostek[i].setImageResource(R.drawable.question);
                    }
                    oczka[wyrzuconeKosci[i]-1]++;
                }
                for (int i=0; i<oczka.length; i++){
                    if(oczka[i] > 1){
                        wynikRundy+=(i+1)*oczka[i];
                        wynikGryInt+=(i+1)*oczka[i];
                    }
                }
                wynikLosowania.setText("Wynik tego losowania: "+wynikRundy);
                wynikGry.setText("Wynik gry: "+wynikGryInt);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i< zdjeciaKostek.length; i++){
                    zdjeciaKostek[i].setImageResource(R.drawable.question);
                }
                wynikRundy = 0;
                wynikGryInt = 0;
                wynikLosowania.setText("Wynik tego losowania: "+wynikRundy);
                wynikGry.setText("Wynik gry: "+wynikGryInt);
            }
        });
    }
}