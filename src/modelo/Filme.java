package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Filme {
    private String nome;
    private String descricao;
    private double orcamento;
    private Date dataLancamento;
    private List elenco;
    private List diretores;

    public Filme(String nome, String descricao, double orcamento, Date dataLancamento) {
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

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public List getElenco() {
        return Collections.unmodifiableList(this.elenco);
    }

    public List getDiretores() {
        return Collections.unmodifiableList(this.diretores);
    }

    public void adicionarAtor(Ator ator){

    }
}
