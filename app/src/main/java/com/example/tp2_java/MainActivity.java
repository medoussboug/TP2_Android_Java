package com.example.tp2_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView l;
    private EditText etNom;
    private EditText etDescription;
    private List<Fruit> fruits = new ArrayList<>();
    private FruitAdapter fruitAdapter;
    private Button btAjouter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = findViewById(R.id.list);
        btAjouter = findViewById(R.id.btAjouter);
        fruits.add(new Fruit("banane", "banananana", "banana"));
        fruits.add(new Fruit("banane", "banananananana", "banana"));
        fruits.add(new Fruit("banane", "bananananana", "banana"));
        fruits.add(new Fruit("banane", "banananananananan", "banana"));
        fruitAdapter = new FruitAdapter(this, fruits);
        l.setAdapter(fruitAdapter);
        btAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAjouterClicked();
                fruitAdapter.notifyDataSetChanged();
            }
        });
    }

    private void onAjouterClicked() {
        etDescription = findViewById(R.id.etDescription);
        String description = etDescription.getText().toString();
        etNom = findViewById(R.id.etNom);
        String nom = etNom.getText().toString();
        if(description.isEmpty() || nom.isEmpty()) {
            if(description.isEmpty()) {
                etDescription.setError("can't be empty");
            }
            if(nom.isEmpty()) {
                etNom.setError("can't be empty");
            }
        } else {
            fruits.add(new Fruit(nom, description, nom));
        }
    }
}