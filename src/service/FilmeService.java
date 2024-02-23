package service;

import modelo.Ator;
import modelo.Diretor;
import modelo.Filme;
import repository.FilmeRespository;

import java.time.LocalDate;
import java.util.List;

public class FilmeService {

    private static FilmeRespository filmeRespository = new FilmeRespository();


    public boolean add(String nome, String descricao, Double orcamento, LocalDate dataLancamento) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do filme não pode ser nulo");
            return false;
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            System.out.println("Descrição do filme não pode ser nula");
            return false;
        }
        if (orcamento < 0) {
            System.out.println("O orçamento do filme não pode custar menos de 1 real.");
            return false;
        }
        Filme novo = new Filme(nome, descricao, orcamento, dataLancamento);

        return filmeRespository.add(novo);
    }

    public boolean delete(String nome, LocalDate dataLancamento) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do filme não pode ser nulo");
            return false;
        }
        return filmeRespository.delete(nome, dataLancamento);
    }

    //Método para "Setar" filmes já existentes.
    public boolean update(String nome, LocalDate dataLancamento, Object atorOuDiretor) {
        if ((dataLancamento == null || nome.trim().isEmpty()) || (atorOuDiretor == null)) {
            System.out.println("Por favor, informe valores validos para o filme e/ou o ator/diretor.");
            return false;
        }
        int indexFilme = filmeRespository.findByName(nome, dataLancamento);
        if (indexFilme == -1) {
            return false;
        }
        return filmeRespository.update(filmeRespository.findByName(nome, dataLancamento), atorOuDiretor);
    }

    //Método para achar um filme e exibir suas informações.
    public StringBuilder findfilme(String nome, LocalDate dataLancamento) {
        Filme filme = filmeRespository.findFilme(nome, dataLancamento);
        StringBuilder show = new StringBuilder();
        if (filme != null) {
            show = new StringBuilder("Nome: " + filme.getNome() + "\n" +
                    "Data de Lancamento: " + filme.getDataLancamento() + "\n" +
                    "Orcamento: " + filme.getOrcamento() + "\n" +
                    "Descrição: " + filme.getDescricao() + "\n" +
                    "Diretores: \n");
        } else {
            return show = new StringBuilder("\nFilme não encontrado. Verifique se o nome está em letras minúsculas\n" +
                    "e se a data de lançamento está correta, formato solicitado.\n");
        }
        if (filme.getDiretores().isEmpty()) {
            show.append("-").append("Não há diretores cadastrados.");
        }
        for (Diretor diretor : filme.getDiretores()) {
            show.append("- ").append(diretor.getNome()).append("\n");
        }
        show.append("Elenco: \n");
        if (filme.getElenco().isEmpty()) {
            show.append("-").append("Não há atores cadastrados.");
        }
        for (Ator ator : filme.getElenco()) {
            show.append("- ").append(ator.getNome()).append("\n");
        }
        return show;
    }

    public void listar() {
        List<Filme> lista = filmeRespository.listar();
        if (!lista.isEmpty()) {
            for (Filme filme : lista) {
                System.out.println("-- Nome: " + filme.getNome() + "\n" +
                        "-- Descrição: " + filme.getDescricao() + "\n" +
                        "-- Lançamento: " + filme.getDataLancamento() + "\n");
            }
        } else {
            System.out.println("\nNão há filmes cadastrados.\n");
        }
    }
}
