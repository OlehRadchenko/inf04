package com.example.zad_04_11_2024;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private GridLayout gridLayout;
    private Button resetButton;
    private TextView matchesFoundTextView;
    private ArrayList<ImageView> imageViews;
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8};
    private int[] board;
    private int matchesFound = 0;
    private ImageView firstSelected;
    private ImageView secondSelected;
    private boolean isChecking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.gridLayout);
        resetButton = findViewById(R.id.resetButton);
        matchesFoundTextView = findViewById(R.id.matchesFound);
        imageViews = new ArrayList<>();
        board = new int[16];

        setupGame();
        resetButton.setOnClickListener(v -> resetGame());
    }

    private void setupGame() {
        ArrayList<Integer> tempImages = new ArrayList<>();
        for (int img : images) {
            tempImages.add(img);
            tempImages.add(img);
        }
        Collections.shuffle(tempImages);
        for (int i = 0; i < 16; i++) {
            board[i] = tempImages.get(i);
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.question);
            imageView.setTag(i);

            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 0;
            params.height = 0;
            params.columnSpec = GridLayout.spec(i % 4, 1f);
            params.rowSpec = GridLayout.spec(i / 4, 1f);
            imageView.setLayoutParams(params);

            imageView.setOnClickListener(v -> onImageClick(imageView));
            gridLayout.addView(imageView);
            imageViews.add(imageView);
        }
    }

    private void onImageClick(ImageView imageView) {
        if (isChecking) return;

        int index = (int) imageView.getTag();
        imageView.setImageResource(board[index]);

        if (firstSelected == null) {
            firstSelected = imageView;
        } else {
            secondSelected = imageView;
            isChecking = true;
            checkForMatch();
        }
    }

    private void checkForMatch() {
        if (board[(int) firstSelected.getTag()] == board[(int) secondSelected.getTag()]) {
            matchesFound++;
            matchesFoundTextView.setText("Matches Found: " + matchesFound);
            firstSelected = null;
            secondSelected = null;
            isChecking = false;
        } else {
            new Handler().postDelayed(() -> {
                firstSelected.setImageResource(R.drawable.question);
                secondSelected.setImageResource(R.drawable.question);
                firstSelected = null;
                secondSelected = null;
                isChecking = false;
            }, 1000);
        }
    }

    private void resetGame() {
        matchesFound = 0;
        matchesFoundTextView.setText("Matches Found: 0");
        gridLayout.removeAllViews();
        setupGame();
    }
}