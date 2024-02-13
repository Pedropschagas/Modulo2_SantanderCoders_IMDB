package modelo;

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

    protected String getNome() {
        return nome;
    }

    protected List getFilmes() {
        return Collections.unmodifiableList(this.filmes);
    }


}
