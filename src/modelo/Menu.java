package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {




    public void faixa() {
        System.out.println("=====================\n" +
                "   || ADA FILMS ||\n" +
                "=====================\n");
    }

    public void inicial() {
        faixa();
        System.out.println(
                "1 - Cadastrar filme\n" +
                "2 - Cadastrar Diretor\n" +
                "3 - Cadastrar Ator\n" +
                "4 - Sair\n");
    }

    public Filme recebeFilme() {

        Scanner sc = new Scanner(System.in);

        System.out.println("== Cadastro de Filmes ==\n" +
                "Digite o nome do filme: \n");
        String nome = sc.nextLine().toLowerCase();

        System.out.println("Insira uma breve descrição do filme: ");
        String descricao = sc.nextLine().toLowerCase();


        System.out.println("Em apenas numeros, quanto custou para fazer esse filme?");
        Double orcamento = sc.nextDouble();

        LocalDate dataLancamento = null;
        boolean valida = false;
        do {
            System.out.print("Digite a data de lançamento do filme (no formato yyyy-MM-dd): ");
            String lancamento = sc.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            try {
                dataLancamento = LocalDate.parse(lancamento, formatter);
                valida = true;
            } catch (Exception e) {
                System.out.println("Formato de data inválido. Certifique-se de usar o formato yyyy-MM-dd.");
            }
        } while (!valida);

        Filme filme = new Filme(nome, descricao, orcamento, dataLancamento);


        String maisDiretor = "n";
        do {
            System.out.print("Informe o nome do diretor do filme: ");
            Diretor diretor = new Diretor(sc.nextLine());
            diretor.adicionarFilme(filme);
            if(!filme.adicionarDiretor(diretor)) {
                System.out.println("Este diretor já está nesse filme.");
            }




            System.out.println("O filme possui mais de um diretor (s/n)?");
            maisDiretor = sc.nextLine().toLowerCase();

        } while (!maisDiretor.equals("n"));


        String maisAtor = "n";
        System.out.println("Elenco do filme");
        do {
            System.out.println("Informe o nome do Ator: ");
            Ator ator = new Ator(sc.nextLine());
            ator.adicionarFilme(filme);
            if(!filme.adicionarAtor(ator)) {
                System.out.println("Este ator já consta nesse filme.");
            }

            System.out.println("mais algum ator (s/n)?");
            maisAtor = sc.nextLine().toLowerCase();

        } while (!maisAtor.equals("n"));




        return filme;
    }

}
