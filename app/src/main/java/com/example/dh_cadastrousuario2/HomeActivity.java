package com.example.dh_cadastrousuario2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import static com.example.dh_cadastrousuario2.MainActivity.AGE_KEY;
import static com.example.dh_cadastrousuario2.MainActivity.NAME_KEY;
import static com.example.dh_cadastrousuario2.MainActivity.SURNAME_KEY;

public class HomeActivity extends AppCompatActivity {
    private TextView texto1;
    private TextView texto2;
    private TextView texto3;
    private TextView texto4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        texto1 = findViewById(R.id.textView1);
        texto2 = findViewById(R.id.textView2);
        texto3 = findViewById(R.id.textView3);
        texto4 = findViewById(R.id.textView4);

        Intent intent = getIntent();

        if(getIntent() != null && intent.getExtras() != null){
            Bundle bundle = intent.getExtras();
            String name = bundle.getString(NAME_KEY);
            String surname = bundle.getString(SURNAME_KEY);
            String age = bundle.getString(AGE_KEY);

            texto1.setText("Olá, " + name + "! Seja bem vindo(a)!");
            texto2.setText("Nome: " + name);
            texto3.setText("Sobrenome: " + surname);
            texto4.setText("Idade: " + age);
        } else {
            Snackbar.make(texto1,"Náo há dados", Snackbar.LENGTH_LONG).show();
        }


    }
}
