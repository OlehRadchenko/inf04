package com.example.zad_21_10;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int likesCounter;
    private TextView likesText;
    private Button likeButton, deleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        likesText = findViewById(R.id.textView2);
        likeButton = findViewById(R.id.button3);
        deleteButton = findViewById(R.id.button4);

        likeButton.setOnClickListener(v -> LikeClick());
        deleteButton.setOnClickListener(v -> DeleteClick());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    protected void LikeClick(){
        likesCounter++;
        likesText.setText(likesCounter+" LIKES");
    }
    protected void DeleteClick(){
        if(likesCounter > 0){
            likesCounter--;
            likesText.setText(likesCounter+" LIKES");
        }
    }
}