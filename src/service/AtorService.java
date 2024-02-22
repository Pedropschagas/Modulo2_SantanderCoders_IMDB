package service;

import modelo.Ator;
import modelo.Filme;
import repository.AtorRepository;

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

}
