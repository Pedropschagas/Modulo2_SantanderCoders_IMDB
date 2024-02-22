package repository;

import Infra.BancoDeDados;
import modelo.Ator;
import modelo.Diretor;
import modelo.Filme;

import java.time.LocalDate;
import java.util.List;

public  class FilmeRespository {

    private static List<Filme> filmes = BancoDeDados.filmes;
    private static DiretorRepository diretorRepository =  new DiretorRepository();
    private static AtorRepository atorRepository =  new AtorRepository();



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
        Filme filmeAtual = filmes.get(index);
        if(atorOuDiretor instanceof Ator){
            Ator novo = (Ator) atorOuDiretor;
            filmeAtual.adicionarAtor(novo);
            Ator ator = atorRepository.findAtor(novo.getNome());
            if(ator == null){
                atorRepository.add(novo);
            }
            atorRepository.addFilme(novo,filmeAtual);
            return true;
        }
        if (atorOuDiretor instanceof Diretor) {
            Diretor novo = (Diretor) atorOuDiretor;
            filmeAtual.adicionarDiretor((Diretor) atorOuDiretor);
            Diretor diretor = diretorRepository.findDiretor(novo.getNome());
            if (diretor == null) {
                diretorRepository.add(novo);
            }
            diretorRepository.addFilme(novo, filmeAtual);
            return true;
        }
        return false;
    }

    public List<Filme> listar(){
        return filmes;
    }
}
