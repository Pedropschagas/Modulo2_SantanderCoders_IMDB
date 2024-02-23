package repository;

import Infra.BancoDeDados;
import modelo.Diretor;
import modelo.Filme;

import java.util.List;

public class DiretorRepository {

    private static List<Diretor> diretores = BancoDeDados.diretores;

    public boolean add(Diretor diretor) {
        if (findByName(diretor.getNome()) == -1) {
            diretores.add(diretor);
            return true;
        }
        return false;
    }

    public boolean delete(String diretor) {
        int indexDiretor = findByName(diretor);
        if (indexDiretor != -1) {
            diretores.remove(indexDiretor);
            return true;
        }
        return false;
    }

    public int findByName(String name) {
        for (Diretor diretor : diretores) {
            if (name.equals(diretor.getNome())) {
                return diretores.indexOf(diretor);
            }
        }
        return -1;
    }

    public Diretor findDiretor(String name) {
        for (Diretor diretor : diretores) {
            if (name.equals(diretor.getNome())) {
                return diretor;
            }
        }
        return null;
    }
    public boolean addFilme(Diretor nome, Filme filme) {
        int indexDiretor = findByName(nome.getNome());
        if (indexDiretor != -1) {
            diretores.get(indexDiretor).addFilme(filme);
            return true;
        }
        return false;
    }

    public List<Diretor> Listar() { return diretores;}

}
