package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Pessoa {
    private String nome;
    protected List<Filme> filmes;

    public Pessoa(String nome){
        this.nome = nome;
        this.filmes = new ArrayList();
    }

    public String getNome() {
        return nome;
    }
    public List<Filme> getFilmes() {
        return filmes;
    }


    public boolean addFilme(Filme novo) {
        for (Object filme : this.getFilmes()) {
            if (novo.equals(filme))
                return false;
        }
        this.filmes.add(novo);
        return true;
    }
}
