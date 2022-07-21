package com.example.pizzaria.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pizzaria.entity.Pizza;

import java.util.List;
@Dao

public interface PizzaDAO {

    @Insert
    void salvar(Pizza pizza);

    @Delete
    void excluir (Pizza pizza);

    @Update
    void editar (Pizza pizza);

    @Query("SELECT * FROM pizzas")
    List<Pizza> todasPizzas();

}
