package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    int [] zdjecia = new int[] {R.drawable.kot1, R.drawable.kot2, R.drawable.kot3, R.drawable.kot4};
    Button prev;
    Button next;
    ImageView obrazek;
    Switch tlo;
    LinearLayout main;
    EditText pozycja;
    int obecnyObrazek = 0;
    int [] wartosci = new int[] {0, 1, 2, 3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        prev = findViewById(R.id.button);
        next = findViewById(R.id.button2);
        obrazek = findViewById(R.id.imageView2);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(obecnyObrazek==0){
                    obecnyObrazek=3;
                    obrazek.setImageResource(zdjecia[obecnyObrazek]);
                }
                else {
                    obecnyObrazek--;
                    obrazek.setImageResource(zdjecia[obecnyObrazek]);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(obecnyObrazek==3){
                    obecnyObrazek=0;
                    obrazek.setImageResource(zdjecia[obecnyObrazek]);
                }
                else {
                    obecnyObrazek++;
                    obrazek.setImageResource(zdjecia[obecnyObrazek]);
                }
            }
        });

        tlo = findViewById(R.id.switch1);
        main = findViewById(R.id.main);
        tlo.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            main.setBackgroundColor(Color.parseColor("#0000FF"));
                        }
                        else{
                            main.setBackgroundColor(Color.parseColor("#00796B"));
                        }
                    }
                }
        );

        pozycja = findViewById(R.id.editTextNumber);
        pozycja.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                int a = Integer.parseInt(charSequence.toString());
                obrazek.setImageResource(zdjecia[a]);


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}