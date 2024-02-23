package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filme {
    private String nome;
    private String descricao;
    private Double orcamento;
    private LocalDate dataLancamento;
    private List elenco;
    private List diretores;

    public Filme(String nome, String descricao, Double orcamento, LocalDate dataLancamento) {
        this.nome = nome;
        this.descricao = descricao;
        this.orcamento = orcamento;
        this.dataLancamento = dataLancamento;
        this.elenco = new ArrayList();
        this.diretores = new ArrayList();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public List<Ator> getElenco() {
        return Collections.unmodifiableList(this.elenco);
    }

    public List<Diretor> getDiretores() {
        return Collections.unmodifiableList(this.diretores);
    }


    @Override
    public boolean equals(Object filme) {
        if (filme == this) {
            return true;
        }
        if (!(filme instanceof Filme)) {
            return false;
        }
        Filme f = (Filme) filme;
        return this.nome.equals(f.getNome()) && this.dataLancamento == f.getDataLancamento();
    }

    public boolean adicionarAtor(Ator novo) {
        for (Object ator : this.getElenco()) {
            if (novo.equals(ator))
                return false;
        }
        elenco.add(novo);
        return true;
    }

    public boolean adicionarDiretor(Diretor novo) {
        for (Object diretor : this.getDiretores()) {
            if (novo.equals(diretor))
                return false;
        }
        diretores.add(novo);
        return true;
    }
}
