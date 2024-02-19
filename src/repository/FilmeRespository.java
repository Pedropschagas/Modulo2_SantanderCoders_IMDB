package repository;

import modelo.Ator;
import modelo.Diretor;
import modelo.Filme;

import java.time.LocalDate;
import java.util.List;

public  class FilmeRespository {

    List<Filme> filmes;


    public boolean add(Filme filme) {
        if (findByName(filme.getNome(), filme.getDataLancamento()) == -1) {
            filmes.add(filme);
            return true;
        }
        return false;
    }

    public boolean delete(String name, LocalDate dataLancamento) {
        int indexFilme = findByName(name, dataLancamento);
        if(indexFilme != -1){
            filmes.remove(indexFilme);
            return true;
        }
        return false;

    }

    public int findByName(String name, LocalDate dataLancamento){
        for(Filme filme : filmes) {
            if(name.equals(filme.getNome()) && dataLancamento.equals(filme.getDataLancamento())){
                return filmes.indexOf(filme);
            }
        }
        return -1;
    }

    public Filme findFilme(String name, LocalDate dataLancamento) {
        for (Filme filme : filmes){
            if(name.equals(filme.getNome()) && dataLancamento.equals(filme.getDataLancamento())){
                return filme;
            }
        }
        return null;
    }

    public boolean update(int index, Object atorOuDiretor) {
        if(atorOuDiretor instanceof Ator){
            filmes.get(index).adicionarAtor((Ator) atorOuDiretor);
            return true;
        }
        if (atorOuDiretor instanceof Diretor) {
            filmes.get(index).adicionarDiretor((Diretor) atorOuDiretor);
            return true;
        }
        return false;
    }




}
