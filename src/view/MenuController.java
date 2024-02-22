package view;

import Infra.BancoDeDados;
import modelo.Ator;
import modelo.Diretor;
import modelo.Filme;
import service.AtorService;
import service.DiretorService;
import service.FilmeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuController {

    private FilmeService filmeService = new FilmeService();
    private DiretorService diretorService = new DiretorService();
    private AtorService atorService = new AtorService();
    private BancoDeDados bancoDeDados = new BancoDeDados();

    public void faixa() {
        System.out.println("=====================\n" +
                "   || ADA FILMS ||\n" +
                "=====================");
    }

    public void inicial() {
        faixa();
        System.out.println(
                "1 - Filme\n" +
                "2 - Ator\n" +
                "3 - Diretor\n" +
                "4 - Listar todos os filmes\n" +
                "0 - Sair");
    }

    public Filme cadastrarFilme() {

        Scanner sc = new Scanner(System.in);

        System.out.println("== Cadastro de Filmes ==\n" +
                "Digite o nome do filme: \n");
        String nome = sc.nextLine().toLowerCase();

        System.out.println("Insira uma breve descrição do filme: ");
        String descricao = sc.nextLine().toLowerCase();


        System.out.println("Em apenas numeros, quanto custou para fazer esse filme?");
        Double orcamento = sc.nextDouble();
        sc.nextLine();

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
        filmeService.add(nome, descricao, orcamento, dataLancamento);

        String maisDiretor = "n";
        do {
            System.out.print("Informe o nome do diretor do filme: ");
            Diretor diretor = new Diretor(sc.nextLine().toLowerCase());
            diretor.addFilme(filme);
            if(!filme.adicionarDiretor(diretor)) {
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
            if(!filme.adicionarAtor(ator)) {
                System.out.println("Este ator já consta nesse filme.");
            }

            System.out.println("mais algum ator (s/n)?");
            maisAtor = sc.nextLine().toLowerCase();

        } while (!maisAtor.equals("n"));

        return filme;
    }

    public void cadastrarDiretor(){
        Scanner sc = new Scanner(System.in);
        String maisDiretor = "n";
        do {
            System.out.print("Informe o nome do diretor do filme: ");
            if(!diretorService.add(sc.nextLine().toLowerCase())) {
                System.out.println("Este diretor já está no nosso banco de dados.");
            }
            System.out.println("Deseja cadastrar mais um diretor (s/n)?");
            maisDiretor = sc.nextLine().toLowerCase();

        } while (!maisDiretor.equals("n"));
    }

    public void cadastrarAtor(){
        Scanner sc = new Scanner(System.in);
        String maisAtor = "n";
        do {
            System.out.print("Informe o nome do Ator do filme: ");
            if(!diretorService.add(sc.nextLine().toLowerCase())) {
                System.out.println("Este ator já está no nosso banco de dados.");
            }
            System.out.println("Deseja cadastrar mais um ator (s/n)?");
            maisAtor = sc.nextLine().toLowerCase();

        } while (!maisAtor.equals("n"));
    }

    public void listarFilmes() {
        filmeService.listar();
    }
}
