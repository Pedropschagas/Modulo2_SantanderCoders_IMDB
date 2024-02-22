package service;

import modelo.Filme;
import repository.FilmeRespository;

import java.time.LocalDate;

public class FilmeService {

    private static FilmeRespository filmeRespository = new FilmeRespository();


    public boolean add(String nome, String descricao, Double orcamento, LocalDate dataLancamento){
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Nome do filme não pode ser nulo");
            return false;
        }
        if(descricao == null || descricao.trim().isEmpty()){
            System.out.println("Descrição do filme não pode ser nula");
            return false;
        }
        if(orcamento < 0) {
            System.out.println("O orçamento do filme não pode custar menos de 1 real.");
            return false;
        }
        Filme novo = new Filme(nome, descricao, orcamento, dataLancamento);

        return filmeRespository.add(novo);
    }

    public boolean delete(String nome, LocalDate dataLancamento){
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Nome do filme não pode ser nulo");
            return false;
        }
        return filmeRespository.delete(nome, dataLancamento);
    }

    public boolean update(String nome, LocalDate dataLancamento, Object atorOuDiretor){
       if ((dataLancamento == null || nome.trim().isEmpty()) || (atorOuDiretor == null)){
           System.out.println("Por favor, informe valores validos para o filme e/ou o ator/diretor.");
           return false;
       }
       return  filmeRespository.update(filmeRespository.findByName(nome, dataLancamento), atorOuDiretor);
    }

    public void listar(){
        for (Filme filme : filmeRespository.listar()){
            System.out.println("-- Nome: " + filme.getNome() + "\n" +
                    "-- Descrição: " + filme.getDescricao() + "\n" +
                    "-- Lançamento: " + filme.getDataLancamento() + "\n");
        }
    }



}
