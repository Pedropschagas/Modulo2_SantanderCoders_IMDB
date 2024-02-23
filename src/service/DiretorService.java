package service;

import modelo.Diretor;
import modelo.Filme;
import repository.DiretorRepository;

import java.util.List;

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

    //Método para localizar o ator e exibir o seu portfólio de filmes, casp haja.
    public StringBuilder findDiretor(String name){
        Diretor diretor = diretorRepository.findDiretor(name);
        if(diretor != null) {
            StringBuilder fichaDoDiretor = new StringBuilder("Nome: " + diretor.getNome()+"\n" + "Filmes: \n");
            if(diretor.getFilmes().isEmpty()){
                fichaDoDiretor.append("- Sem filmes associados!");
            }
            for (Filme filme: diretor.getFilmes()){
                fichaDoDiretor.append("-").append(filme.getNome()).append("\n");
            }
            return fichaDoDiretor;

        }
        return new StringBuilder("Diretor não encontrado!");
    }

    //Método para listar os Diretores do banco de dados.
    public StringBuilder findAll(){
        List<Diretor> diretores = diretorRepository.Listar();

        if(diretores.isEmpty()){
            return new StringBuilder("Não há diretores cadastrados");
        }
        StringBuilder listaDiretores = new StringBuilder("Diretores: \n");
        for (Diretor diretor : diretores){
            listaDiretores.append("-").append(diretor.getNome()).append("\n");
        }
        return listaDiretores;
    }
}
