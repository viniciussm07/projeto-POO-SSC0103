package com.projpoo;

public class Filme{

    public String nomeDoFilme;
    public String URL;
    public String sinopse;
    public String lancamento;

    public Filme(String nomeDoFilme, String URL, String lancamento, String sinopse){

        this.nomeDoFilme = nomeDoFilme;
        this.URL = URL;
        this.lancamento = lancamento;
        this.sinopse = sinopse;
    }
}