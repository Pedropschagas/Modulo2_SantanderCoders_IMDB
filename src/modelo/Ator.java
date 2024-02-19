package modelo;

import java.util.List;

public class Ator extends Pessoa{

    public Ator(String nome){
        super(nome);
      }


    public boolean adicionarFilme(Filme novo) {
        for (Object filme : this.getFilmes()) {
            if (novo.equals(filme))
                return false;
        }
        this.filmes.add(novo);
        return true;
    }


}
