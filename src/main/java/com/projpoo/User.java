package com.projpoo;

import java.util.List;

import info.movito.themoviedbapi.model.MovieDb;

public class User {
    public String nome;
    public int idade;
    public List<MovieDb> lista;
    public int qtdListas;
    
    User(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        
    }


}
