package br.com.adatech.imdbproject;

import modelo.Menu;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        int opcao = 0;



        while (opcao != 4) {

            try {
                menu.inicial();
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        menu.recebeFilme();
                        pausa(1300);
                        break;
                    case 2:

                        pausa(1300);
                        break;
                    case 3:

                        pausa(1300);
                        break;
                    case 4:
                        System.out.println("Até Logo!!");
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha uma das opções do menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Digite um numero inteiro, conforme" +
                        " as opções do Menu.");
                sc.nextLine();
                pausa(1300);
            }

        }
        sc.close();
    }

    public static void pausa(int tempo_em_ms) {
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
