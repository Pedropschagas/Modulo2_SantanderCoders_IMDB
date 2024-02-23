package view;

import Infra.BancoDeDados;
import service.AtorService;
import service.DiretorService;
import service.FilmeService;

public class MenuController {

    private FilmeService filmeService = new FilmeService();
    private DiretorService diretorService = new DiretorService();
    private AtorService atorService = new AtorService();
    private BancoDeDados bancoDeDados = new BancoDeDados();
    private AtorController atorController = new AtorController();

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
                "0 - Sair");
    }
}


