package com.kacper.listazadan;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button przyciskDodaj;
    private EditText produkt;
    private ListView listaZakupow;
    private ArrayList<String> listaProduktow;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        przyciskDodaj = findViewById(R.id.dodajProdukt);
        produkt = findViewById(R.id.produkt);
        listaZakupow = findViewById(R.id.listaZakupow);
        listaProduktow = new ArrayList<>();
        listaProduktow.add("Mleko");
        listaProduktow.add("Woda");
        listaProduktow.add("Sok");
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listaProduktow);
        listaZakupow.setAdapter(arrayAdapter);
        przyciskDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dodawanyProdukt = produkt.getText().toString();
                listaProduktow.add(dodawanyProdukt);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        listaZakupow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //listaProduktow.remove(i);
                TextView textview = (TextView) view;
                if(textview.getPaintFlags()== Paint.STRIKE_THRU_TEXT_FLAG){
                    textview.setPaintFlags(0);
                    textview.setBackgroundColor(Color.WHITE);

                }
                else{
                    textview.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    textview.setBackgroundColor(Color.BLUE);
                }
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}