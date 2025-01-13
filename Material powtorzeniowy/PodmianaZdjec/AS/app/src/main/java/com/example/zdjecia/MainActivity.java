package com.example.zdjecia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected Button prev, next, reset;
    protected ImageView pies;
    protected int[] psy = {R.drawable.pies1, R.drawable.pies2, R.drawable.pies3, R.drawable.pies4, R.drawable.pies5, R.drawable.pies6, R.drawable.pies7, R.drawable.pies8, R.drawable.pies9, R.drawable.pies10};
    protected int aktualnyPies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        pies = findViewById(R.id.piesZdj);
        prev = findViewById(R.id.leftButton);
        next = findViewById(R.id.rightButton);
        reset = findViewById(R.id.randomButton);
        aktualnyPies = random.nextInt(10);
        pies.setImageResource(psy[aktualnyPies]);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aktualnyPies = random.nextInt(10);
                pies.setImageResource(psy[aktualnyPies]);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aktualnyPies--;
                if(aktualnyPies < 0){
                    aktualnyPies = 9;
                }
                pies.setImageResource(psy[aktualnyPies]);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aktualnyPies++;
                if(aktualnyPies > 9){
                    aktualnyPies = 0;
                }
                pies.setImageResource(psy[aktualnyPies]);
            }
        });
    }
}