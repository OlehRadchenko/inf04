package com.example.loginappas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected EditText email, password, password2;
    protected Button zatwierdz;
    protected TextView komunikat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.haslo);
        password2 = findViewById(R.id.haslo2);
        zatwierdz = findViewById(R.id.zatwierdz);
        komunikat = findViewById(R.id.komunikat);
        komunikat.setText("Autor: Oleh Radchenko");
        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(String.valueOf(email.getText()).matches(".*@.*") == false){
                    komunikat.setText("Nieprawidłowy adres e-mail");
                }else if(String.valueOf(password.getText()).equals(String.valueOf(password2.getText())) == false){
                    komunikat.setText("Hasła się różnią");
                }else{
                    komunikat.setText("Witaj "+email.getText());
                }
            }
        });
    }
}