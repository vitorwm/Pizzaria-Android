package com.example.pizzaria.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzaria.DetalhesActivity;
import com.example.pizzaria.FormActivity;
import com.example.pizzaria.R;
import com.example.pizzaria.database.PizzaDAO;
import com.example.pizzaria.database.PizzasDB;
import com.example.pizzaria.entity.Pizza;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Pizza> listaPizzas;
    private PizzaDAO dao;

    public PizzaAdapter(Context context) {
        this.context = context;
        dao = PizzasDB.getInstance(context).getPizzaDAO();
        listaPizzas = dao.todasPizzas();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.pizza_layout, parent, false);

        PizzaHolder pizzaHolder = new PizzaHolder(itemView);

        return pizzaHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Pizza p = listaPizzas.get(position);

        PizzaHolder pizzaHolder = (PizzaHolder) holder;

        pizzaHolder.tvPizzaQtde.setText(p.toString());


        pizzaHolder.ibDetalhes.setOnClickListener(v->{

            Intent detalhesIntent = new Intent(context, DetalhesActivity.class);

            detalhesIntent.putExtra("pizza", p);

            context.startActivity(detalhesIntent);
        });


        pizzaHolder.ibEditar.setOnClickListener(v->{

            Intent editarIntent = new Intent(context, FormActivity.class);

            editarIntent.putExtra("pizza", p);

            context.startActivity(editarIntent);
        });

        pizzaHolder.ibExcluir.setOnClickListener(v->{
            dao.excluir(p);
            updateDataSet();
        });

    }

    @Override
    public int getItemCount() {
        return listaPizzas.size();
    }

    public void updateDataSet()
    {
        listaPizzas.clear();
        listaPizzas = dao.todasPizzas();
        notifyDataSetChanged();
    }
}
