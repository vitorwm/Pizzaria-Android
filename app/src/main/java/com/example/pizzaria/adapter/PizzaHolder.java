package com.example.pizzaria.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzaria.R;

public class PizzaHolder extends RecyclerView.ViewHolder {

    TextView tvPizzaQtde;

    ImageButton ibDetalhes;
    ImageButton ibEditar;
    ImageButton ibExcluir;

    public PizzaHolder(@NonNull View itemView) {
        super(itemView);

        tvPizzaQtde = itemView.findViewById(R.id.tvPizzaQtde);

        ibDetalhes = itemView.findViewById(R.id.ibDetalhes);
        ibEditar = itemView.findViewById(R.id.ibEditar);
        ibExcluir = itemView.findViewById(R.id.ibExcluir);

    }
}