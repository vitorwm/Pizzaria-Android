package com.example.pizzaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzaria.database.PizzasDB;
import com.example.pizzaria.entity.Pizza;
import com.example.pizzaria.database.PizzaDAO;

public class DetalhesActivity extends AppCompatActivity {


    TextView tvNome;
    TextView tvQtde;
    TextView tvIngrediente1;
    TextView tvIngrediente2;
    TextView tvIngrediente3;


    PizzaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);


        tvNome  = findViewById(R.id.tvNome);
        tvQtde  = findViewById(R.id.tvQtde);
        tvIngrediente1  = findViewById(R.id.tvIngrediente1);
        tvIngrediente2  = findViewById(R.id.tvIngrediente2);
        tvIngrediente3  = findViewById(R.id.tvIngrediente3);


        dao = PizzasDB.getInstance(this).getPizzaDAO();

        Intent detalheItent = getIntent();

        Pizza edtPizza;

        if (detalheItent.hasExtra("pizza"))
        {
            edtPizza = (Pizza) detalheItent.getSerializableExtra("pizza");
            tvNome.setText(edtPizza.getNome());
            tvQtde.setText(edtPizza.getQtde() + "");
            tvIngrediente1.setText(edtPizza.getIngrediente1());
            tvIngrediente2.setText(edtPizza.getIngrediente2());
            tvIngrediente3.setText(edtPizza.getIngrediente3());


        } else {
            Toast.makeText(this, "Erro ao tentar carregar os detalhes da pizza...", Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}