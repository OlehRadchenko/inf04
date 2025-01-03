package com.example.mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected int likes;
    protected TextView polubieniaText;
    protected Button polub, usun, zapisz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        likes = 0;
        polubieniaText = findViewById(R.id.polubienia);
        polub = findViewById(R.id.polub);
        usun = findViewById(R.id.usun);
        zapisz = findViewById(R.id.zapisz);
        polub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likes++;
                polubieniaText.setText(likes+" polubień");
            }
        });
        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(likes > 0){
                    likes--;
                    polubieniaText.setText(likes+" polubień");
                }
            }
        });
    }
}