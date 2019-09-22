package com.example.dh_cadastrousuario2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputName;
    private TextInputLayout inputSurname;
    private TextInputLayout inputAge;
    private Button btnSend;

    public static final String NAME_KEY = "name";
    public static final String SURNAME_KEY = "surname";
    public static final String AGE_KEY = "age";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.textInputLayout);
        inputSurname = findViewById(R.id.textInputLayout2);
        inputAge = findViewById(R.id.textInputLayout3);
        btnSend = findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = inputName.getEditText().getText().toString();
                String surname = inputSurname.getEditText().getText().toString();
                String age = inputAge.getEditText().getText().toString();

                if (!name.isEmpty() && !surname.isEmpty() && !age.isEmpty()){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                    Bundle bundle = new Bundle();

                    bundle.putString(NAME_KEY, name);
                    bundle.putString(SURNAME_KEY, surname);
                    bundle.putString(AGE_KEY, age);
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (name.isEmpty()){
                    inputName.setError("Preencha o campo nome!");
                } else if (surname.isEmpty()){
                    inputSurname.setError("Preencha o campo sobrenome!");
                } else {
                        inputAge.setError("Preencha o campo idade!");
                }
            }
        });
    }
}
