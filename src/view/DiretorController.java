package view;

import modelo.Diretor;
import service.DiretorService;
import service.FilmeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DiretorController {

    private FilmeService filmeService = new FilmeService();
    private DiretorService diretorService = new DiretorService();

    public void opcoesDiretor() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println(
                    "1 - Cadastrar Diretor\n" +
                            "2 - Associar Diretor ao filme\n" +
                            "3 - Buscar Diretor\n" +
                            "4 - Listar Diretor\n" +
                            "0 - Retornar ao menu anterior");
            try {
                opcao = sc.nextInt();

                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        cadastrarDiretor();
                        break;
                    case 2:
                        associarDiretor();
                        break;
                    case 3:
                        System.out.println("Informe o nome do Diretor: ");
                        sc.nextLine();
                        System.out.println(diretorService.findDiretor(sc.nextLine().toLowerCase()));
                        break;

                    case 4:
                        System.out.println(diretorService.findAll());
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

    public void cadastrarDiretor() {
        Scanner sc = new Scanner(System.in);
        String maisDiretor = "n";
        do {
            System.out.print("Informe o nome do diretor do filme: ");
            if (!diretorService.add(sc.nextLine().toLowerCase())) {
                System.out.println("Este diretor já está no nosso banco de dados.");
            }
            System.out.println("Deseja cadastrar mais um diretor (s/n)?");
            maisDiretor = sc.nextLine().toLowerCase();

        } while (!maisDiretor.equals("n"));
    }

    public void associarDiretor() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome do filme: ");
        String nomeFilme = sc.nextLine();

        LocalDate lancamento = lancamento();

        String maisDiretor = "n";
        do {
            System.out.print("Informe o nome do Diretor do filme: ");
            String nomeDiretor = sc.nextLine().toLowerCase();
            boolean hasUpdated = filmeService.update(nomeFilme, lancamento, new Diretor(nomeDiretor));
            if (!hasUpdated) {
                System.out.println("\nFilme não existe, cadastre no menu de filmes!\n");
                return;
            }
            System.out.println("Deseja associar mais um diretor (s/n)?");
            maisDiretor = sc.nextLine().toLowerCase();

        } while (!maisDiretor.equals("n"));
    }

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

