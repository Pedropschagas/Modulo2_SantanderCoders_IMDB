package view;

import modelo.Ator;
import modelo.Diretor;
import modelo.Filme;
import service.FilmeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FilmeController {

    private MenuController menuController = new MenuController();
    private FilmeService filmeService = new FilmeService();

    public void opcoesFilme() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;


        while (opcao != 0) {
            menuController.faixa();
            System.out.println(
                    "1 - Cadastrar filme\n" +
                            "2 - Buscar Filme\n" +
                            "3 - Listar Filmes\n" +
                            "0 - Retornar ao menu anterior");
            try {
                opcao = sc.nextInt();

                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        menuController.faixa();
                        cadastrarFilme();
                        break;
                    case 2:
                        menuController.faixa();
                        sc.nextLine();
                        System.out.println("Informe o nome do filme: ");
                        String nome = sc.nextLine();
                        LocalDate lancamento = lancamento();
                        System.out.println(filmeService.findfilme(nome, lancamento));
                        break;
                    case 3:
                        menuController.faixa();
                        filmeService.listar();
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha uma das opções do menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Digite um numero inteiro, conforme" +
                        " as opções do MenuController.");
                sc.nextLine();
            }
        }
    }


    public Filme cadastrarFilme() {

        Scanner sc = new Scanner(System.in);

        System.out.println("== Cadastro de Filmes ==\n" +
                "Digite o nome do filme:");
        String nome = sc.nextLine().toLowerCase();

        System.out.println("Insira uma breve descrição do filme: ");
        String descricao = sc.nextLine().toLowerCase();


        System.out.println("Em apenas numeros, quanto custou para fazer esse filme?");
        Double orcamento = sc.nextDouble();
        sc.nextLine();

        LocalDate dataLancamento = lancamento();

        Filme filme = new Filme(nome, descricao, orcamento, dataLancamento);
        filmeService.add(nome, descricao, orcamento, dataLancamento);

        String maisDiretor = "n";
        do {
            System.out.print("Informe o nome do diretor do filme: ");
            Diretor diretor = new Diretor(sc.nextLine().toLowerCase());
            diretor.addFilme(filme);
            filmeService.update(nome, dataLancamento, diretor);
            if (!filme.adicionarDiretor(diretor)) {
                System.out.println("Este diretor já está nesse filme.");
            }
            System.out.println("O filme possui mais um diretor (s/n)?");
            maisDiretor = sc.nextLine().toLowerCase();

        } while (!maisDiretor.equals("n"));


        String maisAtor = "n";
        System.out.println("Elenco do filme");
        do {
            System.out.println("Informe o nome do Ator: ");
            Ator ator = new Ator(sc.nextLine());
            ator.addFilme(filme);
            filmeService.update(nome, dataLancamento, ator);
            if (!filme.adicionarAtor(ator)) {
                System.out.println("Este ator já consta nesse filme.");
            }

            System.out.println("mais algum ator (s/n)?");
            maisAtor = sc.nextLine().toLowerCase();

        } while (!maisAtor.equals("n"));


        return filme;
    }

    public void listarFilmes() {
        filmeService.listar();
    }

    //Funcoes auxiliares
    public LocalDate lancamento() {
        Scanner sc = new Scanner(System.in);
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
        return dataLancamento;
    }
}

