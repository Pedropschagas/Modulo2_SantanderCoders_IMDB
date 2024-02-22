package repository;

import Infra.BancoDeDados;
import modelo.Ator;
import modelo.Filme;

import java.util.List;

public class AtorRepository {

   private static List<Ator> atores = BancoDeDados.atores;

    public boolean add(Ator ator) {
        if (findByName(ator.getNome()) == -1) {
            atores.add(ator);
            return true;
        }
        return false;
    }

    public boolean delete(String nome) {
        int indexAtor = findByName(nome);
        if (indexAtor != -1) {
            atores.remove(indexAtor);
            return true;
        }
        return false;
    }

    public int findByName(String name) {
        for (Ator ator : atores) {
            if (name.equals(ator.getNome())) {
                return atores.indexOf(ator);
            }
        }
        return -1;
    }

    public Ator findAtor(String name) {
        for (Ator ator : atores) {
            if (name.equals(ator.getNome())) {
                return ator;
            }
        }
        return null;
    }

    public boolean addFilme(Ator nome, Filme filme) {
        int indexAtor = findByName(nome.getNome());
        if (indexAtor != -1) {
            atores.get(indexAtor).addFilme(filme);
            return true;
        }
        return false;
    }

}
