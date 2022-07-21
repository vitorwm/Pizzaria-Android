package com.example.pizzaria.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pizzaria.entity.Pizza;

@Database(entities = {Pizza.class}, version = 1, exportSchema = false)


public abstract class PizzasDB extends RoomDatabase {

    private static final String DB_NAME = "pizzas.db";

    public abstract PizzaDAO getPizzaDAO();

    private static PizzasDB instance;


    public static PizzasDB getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, PizzasDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

}
