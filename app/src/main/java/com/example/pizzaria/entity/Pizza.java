package com.example.pizzaria.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "pizzas")

public class Pizza implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String nome;
    private int qtde;
    private String ingrediente1;
    private String ingrediente2;
    private String ingrediente3;


    @Ignore
    public Pizza(int id, String nome, int qtde, String ingrediente1, String ingrediente2, String ingrediente3) {
        this.id = id;
        this.nome = nome;
        this.qtde = qtde;
        this.ingrediente1 = ingrediente1;
        this.ingrediente2 = ingrediente2;
        this.ingrediente3 = ingrediente3;

    }

    public Pizza(){}


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtde() {
        return qtde;
    }
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public String getIngrediente1() {
        return ingrediente1;
    }
    public void setIngrediente1(String ingrediente1) {
        this.ingrediente1 = ingrediente1;
    }

    public String getIngrediente2() {
        return ingrediente2;
    }
    public void setIngrediente2(String ingrediente2) {
        this.ingrediente2 = ingrediente2;
    }

    public String getIngrediente3() {
        return ingrediente3;
    }
    public void setIngrediente3(String ingrediente3) {
        this.ingrediente3 = ingrediente3;
    }



    @Override
    public String toString() {
        return this.nome + " (x" + this.qtde +")";
    }
}
