package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Pessoa {
    private String nome;
    protected List filmes;

    public Pessoa(String nome){
        this.nome = nome;
        this.filmes = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public List getFilmes() {
        return filmes;
    }

    public boolean comparaFilme(Filme filme){
        return filme != null && !this.equals(filme);}


    public void adicionarFilme(Filme filme){
        if (comparaFilme(filme)){
            filmes.add(filme);
        }
    }

}
