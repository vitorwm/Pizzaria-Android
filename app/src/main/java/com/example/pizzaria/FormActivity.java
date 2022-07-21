package com.example.pizzaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pizzaria.database.PizzaDAO;
import com.example.pizzaria.database.PizzasDB;
import com.example.pizzaria.entity.Pizza;

public class FormActivity extends AppCompatActivity {

    EditText etNome;
    EditText etQtde;
    EditText etIngrediente1;
    EditText etIngrediente2;
    EditText etIngrediente3;

    Button bSalvar;

    PizzaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etNome  = findViewById(R.id.etNome);
        etQtde  = findViewById(R.id.etQtde);
        etIngrediente1 = findViewById(R.id.etIngrediente1);
        etIngrediente2 = findViewById(R.id.etIngrediente2);
        etIngrediente3 = findViewById(R.id.etIngrediente3);

        bSalvar = findViewById(R.id.bSalvar);

        dao = PizzasDB.getInstance(this).getPizzaDAO();

        // receber intent
        Intent formItent = getIntent();

        Pizza edtPizza;
        if (formItent.hasExtra("pizza"))
        {
            edtPizza = (Pizza) formItent.getSerializableExtra("pizza");
            etNome.setText(edtPizza.getNome());
            etQtde.setText(edtPizza.getQtde() + "");
            etIngrediente1.setText(edtPizza.getIngrediente1());
            etIngrediente2.setText(edtPizza.getIngrediente2());
            etIngrediente3.setText(edtPizza.getIngrediente3());

        }
        else
        {
            edtPizza = null;
        }

        bSalvar.setOnClickListener(v->{

            if
            (etNome.getText().toString().isEmpty() || etQtde.getText().toString().isEmpty() || etIngrediente1.getText().toString().isEmpty() || etIngrediente2.getText().toString().isEmpty() || etIngrediente3.getText().toString().isEmpty()  ) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else {

                Pizza pizza = new Pizza(0,
                        etNome.getText().toString(),
                        Integer.parseInt( etQtde.getText().toString() ),
                        etIngrediente1.getText().toString() ,
                        etIngrediente2.getText().toString(),
                        etIngrediente3.getText().toString() );

                if(edtPizza == null)
                {
                    dao.salvar(pizza);
                    Toast.makeText(this, "A nova pizza foi cadastrada com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    pizza.setId(edtPizza.getId());
                    dao.editar(pizza);
                    Toast.makeText(this, "O sabor de pizza foi editado com sucesso!!!", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }

        });


    }
}