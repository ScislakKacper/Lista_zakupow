package com.kacper.listazadan;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private EditText nazwa_produktu;
    private EditText cena_produktu;
    private EditText opis_produktu;
    private Button przycisk_dodaj;
    private TextView suma_ceny;
    private ListView lista_produktow;
    private ArrayList<Produkt> produkty_lista;
    private ArrayAdapter<Produkt> arrayAdapter;
    float cena = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2); // wazne - ustala layout
        // java - camelcase, xml - snakecase
        nazwa_produktu = findViewById(R.id.nazwa_produktu);
        cena_produktu = findViewById(R.id.cena_produktu);
        opis_produktu = findViewById(R.id.opis_produktu);
        przycisk_dodaj = findViewById(R.id.dodaj);
        suma_ceny = findViewById(R.id.suma_ceny);
        lista_produktow = findViewById(R.id.lista_produktow);
        produkty_lista = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produkty_lista);
        lista_produktow.setAdapter(arrayAdapter);
        przycisk_dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nazwa_produktu.getText().toString().isEmpty() && !opis_produktu.getText().toString().isEmpty() && !cena_produktu.getText().toString().isEmpty()) {
                    produkty_lista.add(new Produkt(nazwa_produktu.getText().toString(), opis_produktu.getText().toString(), Float.parseFloat(cena_produktu.getText().toString())));
                    cena += Float.parseFloat(cena_produktu.getText().toString());
                    suma_ceny.setText("Cena: " + cena);
                    arrayAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity2.this, "Uzupełnij formularz", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}