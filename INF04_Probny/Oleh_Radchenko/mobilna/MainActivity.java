package com.example.timer;

import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    Button start, reset, pause;
    TextView timer;
    CountDownTimer countDownTimer;
    long timeLeftInMillis;
    boolean isPaused = false;

    private void updateTimerText() {
        int hours = (int) (timeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((timeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timer.setText(timeFormatted);
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                timer.setText("00:00:00");
                pause.setVisibility(View.GONE);
            }
        }.start();
        isPaused = false;
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        isPaused = true;
        pause.setText("Resume");
    }

    private void resumeTimer() {
        startTimer();
        pause.setText("Pause");
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void restart(){
        timePicker.setMinute(0);
        timePicker.setHour(0);
        timePicker.setIs24HourView(true);
        pause.setVisibility(View.GONE);
        pause.setText("pause");
        reset.setVisibility(View.GONE);
        timer.setVisibility(View.GONE);
        start.setVisibility(View.VISIBLE);
        timePicker.setVisibility(View.VISIBLE);
        timeLeftInMillis = 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.timer);
        start = findViewById(R.id.start_but);
        reset = findViewById(R.id.reset);
        pause = findViewById(R.id.pause);
        timePicker = findViewById(R.id.timePicker);
        restart();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setVisibility(View.GONE);
                reset.setVisibility(View.VISIBLE);
                pause.setVisibility(View.VISIBLE);
                timer.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.GONE);
                int hours = timePicker.getHour();
                int minutes = timePicker.getMinute();
                timeLeftInMillis = (hours * 3600 + minutes * 60) * 1000;
                startTimer();
            }
        }
        );
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPaused) {
                    pauseTimer();
                } else {
                    resumeTimer();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                restart();
            }
        });
    }
}