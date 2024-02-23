package br.com.adatech.imdbproject;

import view.AtorController;
import view.DiretorController;
import view.FilmeController;
import view.MenuController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();
        AtorController atorController = new AtorController();
        DiretorController diretorController = new DiretorController();
        FilmeController filmeController = new FilmeController();

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
                        filmeController.opcoesFilme();
                        break;
                    case 2:
                        atorController.opcoesAtor();
                        break;
                    case 3:
                        diretorController.opcoesDiretor();
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
