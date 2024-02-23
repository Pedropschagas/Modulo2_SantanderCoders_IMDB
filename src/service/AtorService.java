package service;

import modelo.Ator;
import modelo.Filme;
import repository.AtorRepository;

import java.util.List;

public class AtorService {

    private static AtorRepository atorRepository =  new AtorRepository();

    public boolean add(String nome){
        Ator novo = new Ator(nome);
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do ator não pode ser nulo");
        }
        return atorRepository.add(novo);
    }

    public boolean delete(String nome){
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do ator não pode ser nulo");
        }
        return atorRepository.delete(nome);
    }

    public StringBuilder findAtor(String name){
        Ator ator = atorRepository.findAtor(name);
        if(ator != null) {
            StringBuilder fichaDoAtor = new StringBuilder("Nome: " + ator.getNome()+"\n" + "Filmes: \n");
            for (Filme filme: ator.getFilmes()){
                fichaDoAtor.append("-").append(filme.getNome()).append("\n");
            }
            return fichaDoAtor;

        }
        return new StringBuilder("Ator não encontrado!");
    }

    public StringBuilder findAll(){
        List<Ator> atores = atorRepository.Listar();

        if(atores.isEmpty()){
            return new StringBuilder("Não há atores cadastrados");
        }
        StringBuilder listaAtores = new StringBuilder("Atores: \n");
        for (Ator ator : atores){
            listaAtores.append("-").append(ator.getNome()).append("\n");
        }
        return listaAtores;
    }

}
