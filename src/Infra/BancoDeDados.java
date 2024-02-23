package Infra;

import modelo.Ator;
import modelo.Diretor;
import modelo.Filme;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    public static List<Filme> filmes = new ArrayList();
    public static List<Ator> atores = new ArrayList();
    public static List<Diretor> diretores = new ArrayList();


    public void add(Filme filme) {
        filmes.add(filme);
    }

    public void delete(int indexOfFilme) {
        filmes.remove(indexOfFilme);
    }

    public boolean addArtista(int indexFilme, Object atorOuDiretor) {
        if (atorOuDiretor instanceof Ator) {
            filmes.get(indexFilme).adicionarAtor((Ator) atorOuDiretor);
            return true;
        }
        if (atorOuDiretor instanceof Diretor) {
            filmes.get(indexFilme).adicionarDiretor((Diretor) atorOuDiretor);
            return true;
        }
        return false;
    }
}
