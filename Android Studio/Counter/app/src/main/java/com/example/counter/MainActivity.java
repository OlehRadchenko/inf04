package com.example.counter;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView message, level_message;
    private SeekBar seekBar;
    private ImageView image;
    private int counter = 0;
    private int level = 1;
    private  int level_counter = 0;
    private int[] xp = {10,20,30,40,50,100};

    private void plus_plus(){
        counter++;
        if(counter%2 == 0){
            image.setImageResource(R.drawable.volume_on);
        }else {
            image.setImageResource(R.drawable.volume_off);//OF
        }
        level_message.setText("Level: "+level+" "+level_counter+"/"+xp[level-1]);
        seekBar.setProgress(level_counter*100/xp[level-1]);
        message.setText("Zmieniłeś głośność już: "+counter+" razy");
    }
    private void click(){
        if(level_counter == xp[level-1]){
            if(level_counter == 100){
                level_message.setText("Skończyłeś grę ;3");
                seekBar.setProgress(100);
            }else{
                level_counter = 1;
                level++;
                plus_plus();
            }
        }else{
            level_counter++;
            plus_plus();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        seekBar = findViewById(R.id.progres);
        seekBar.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        message = findViewById(R.id.counter);
        level_message = findViewById(R.id.level);
        image = findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }
}