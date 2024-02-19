package service;

import modelo.Ator;
import repository.AtorRepository;

public class AtorService {

    private final AtorRepository atorRepository =  new AtorRepository();

    public boolean add(String nome){
        Ator novo = new Ator(nome);
        return atorRepository.add(novo);
    }

    public boolean delete(String nome){
        return atorRepository.delete(nome);
    }

    public Ator findAtor(String name){
        Ator ator = atorRepository.findAtor(name);
        if(ator != null) {
            return ator;
        }
        return null;
    }
}
