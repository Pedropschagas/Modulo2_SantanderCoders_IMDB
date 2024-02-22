package br.com.adatech.imdbproject;

import modelo.Ator;
import modelo.Diretor;
import view.MenuController;
import service.AtorService;
import service.DiretorService;
import service.FilmeService;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        int opcao = -1;


        while (opcao != 0) {

            try {
                menuController.inicial();
                opcao = sc.nextInt();

                switch (opcao) {
                    case 0:
                        System.out.println("Até Logo!!");
                        break;
                    case 1:
                        menuController.cadastrarFilme();
                        pausa(1300);
                        break;
                    case 2:
                        menuController.cadastrarDiretor();
                        pausa(1300);
                        break;
                    case 3:
                        menuController.cadastrarAtor();
                        pausa(1300);
                        break;

                    case 4:
                        menuController.listarFilmes();
                        break;
                    case 5:
                        FilmeService filmeService = new FilmeService();
                        filmeService.add("teste", "teste", 50054.00, LocalDate.parse("2020-03-02"));
                        AtorService atorService = new AtorService();
                        DiretorService diretorService = new DiretorService();
                        atorService.add("Jão");
                        filmeService.update("teste", LocalDate.parse("2020-03-02"), new Ator("Jão"));
                        filmeService.update("teste", LocalDate.parse("2020-03-02"), new Diretor("juan"));
                        System.out.println(atorService.findAtor("Jão"));
                        System.out.println(diretorService.findDiretor("juan"));

                        break;
                    default:
                        System.out.println("Opção inválida. Escolha uma das opções do menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Digite um numero inteiro, conforme" +
                        " as opções do MenuController.");
                sc.nextLine();
                pausa(1300);
            }

        }
        sc.close();
    }

    public static void pausa(int tempo_em_ms) {
        try {
            Thread.sleep(tempo_em_ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
