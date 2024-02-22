package service;

import modelo.Diretor;
import modelo.Filme;
import repository.DiretorRepository;

public class DiretorService {

    private static DiretorRepository diretorRepository =  new DiretorRepository();


    public boolean add(String nome){
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do Diretor não pode ser nulo");
        }
        Diretor novo = new Diretor(nome);
        return diretorRepository.add(novo);
    }

    public boolean delete(String nome){
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do Diretor não pode ser nulo");
        }
        return diretorRepository.delete(nome);
    }

    public StringBuilder findDiretor(String name){
        Diretor diretor = diretorRepository.findDiretor(name);
        if(diretor != null) {
            StringBuilder fichaDoDiretor = new StringBuilder("Nome: " + diretor.getNome()+"\n" + "Filmes: \n");
            for (Filme filme: diretor.getFilmes()){
                fichaDoDiretor.append("-").append(filme.getNome()).append("\n");
            }
            return fichaDoDiretor;

        }
        return new StringBuilder("Diretor não encontrado!");
    }
}
