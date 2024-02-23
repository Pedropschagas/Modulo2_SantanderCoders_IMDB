package view;


import modelo.Ator;
import service.AtorService;
import service.FilmeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AtorController {

    private FilmeService filmeService = new FilmeService();
    private AtorService atorService = new AtorService();


    public void opcoesAtor() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println(
                    "1 - Cadastrar ator\n" +
                            "2 - Associar Ator ao filme\n" +
                            "3 - Buscar Ator\n" +
                            "4 - Listar Atores\n" +
                            "0 - Retornar ao menu anterior");
            try {
                opcao = sc.nextInt();

                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        cadastrarAtor();
                        break;
                    case 2:
                        associarAtor();
                        break;
                    case 3:
                        System.out.println("Informe o nome do ator: ");
                        sc.nextLine();
                        System.out.println(atorService.findAtor(sc.nextLine().toLowerCase()));
                        break;

                    case 4:
                        System.out.println(atorService.findAll());
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
    public void cadastrarAtor(){
        Scanner sc = new Scanner(System.in);
        String maisAtor = "n";
        do {
            System.out.print("Informe o nome do Ator do filme: ");
            if(!atorService.add(sc.nextLine().toLowerCase())) {
                System.out.println("Este ator já está no nosso banco de dados.");
            }
            System.out.println("Deseja cadastrar mais um ator (s/n)?");
            maisAtor = sc.nextLine().toLowerCase();

        } while (!maisAtor.equals("n"));
    }
    public void associarAtor(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome do filme: ");
        String nomeFilme = sc.nextLine();

        LocalDate lancamento = lancamento();

        String maisAtor = "n";
        do {
            System.out.print("Informe o nome do Ator do filme: ");
            String nomeAtor = sc.nextLine().toLowerCase();
            filmeService.update(nomeFilme,lancamento, new Ator(nomeAtor));
            System.out.println("Deseja associar mais um ator (s/n)?");
            maisAtor = sc.nextLine().toLowerCase();

        } while (!maisAtor.equals("n"));
    }

    public LocalDate lancamento(){
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

