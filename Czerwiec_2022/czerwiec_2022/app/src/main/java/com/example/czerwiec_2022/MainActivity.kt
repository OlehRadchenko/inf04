package com.example.czerwiec_2022

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private lateinit var counterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        counterTextView = findViewById(R.id.polubienia);
        var button_like : Button = findViewById(R.id.button_polub);
        var button_dislike : Button = findViewById(R.id.button_usun);
        button_like.setOnClickListener{like()};
        button_dislike.setOnClickListener{dislike()};
    }
    fun updateView(){
        counterTextView.text = "$counter polubień";
    }
    fun dislike(){
        if(counter > 0 ){
            counter--;
            updateView();
        }
    }
    fun like(){
        counter++;
        updateView();
    }
}