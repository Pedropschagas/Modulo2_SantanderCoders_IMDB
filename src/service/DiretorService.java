package service;

import modelo.Ator;
import modelo.Diretor;
import repository.AtorRepository;
import repository.DiretorRepository;

public class DiretorService {

    private final DiretorRepository diretorRepository =  new DiretorRepository();


    public boolean add(String nome){
        Diretor novo = new Diretor(nome);
        return diretorRepository.add(novo);
    }

    public boolean delete(String nome){
        return diretorRepository.delete(nome);
    }

    public Diretor findDiretor(String name){
        Diretor diretor = diretorRepository.findDiretor(name);
        if(diretor != null) {
            return diretor;
        }
        return null;
    }
}
