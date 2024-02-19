package service;

import modelo.Filme;
import repository.AtorRepository;
import repository.DiretorRepository;
import repository.FilmeRespository;

import java.time.LocalDate;

public class FilmeService {

    FilmeRespository filmeRespository = new FilmeRespository();
    DiretorRepository diretorRepository =  new DiretorRepository();
    AtorRepository atorRepository =  new AtorRepository();


    public boolean add(String nome, String descricao, Double orcamento, LocalDate dataLancamento){
        Filme novo = new Filme(nome, descricao, orcamento, dataLancamento);
        return filmeRespository.add(novo);
    }

    public boolean delete(String nome, LocalDate dataLancamento){
        return filmeRespository.delete(nome, dataLancamento);
    }



}
