package com.example.pizzaria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.pizzaria.adapter.PizzaAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {


    RecyclerView rvPizzas;
    FloatingActionButton fabAdd;
    PizzaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPizzas = findViewById(R.id.rvPizzas);
        fabAdd = findViewById(R.id.fabAdd);

        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new PizzaAdapter(this);

        rvPizzas.setLayoutManager(layout);
        rvPizzas.setAdapter(adapter);

        fabAdd.setOnClickListener(v->{ startActivity(new Intent(this, FormActivity.class)); });


    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateDataSet();
    }
}