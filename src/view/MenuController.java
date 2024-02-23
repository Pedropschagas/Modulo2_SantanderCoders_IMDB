package view;

public class MenuController {

    public void faixa() {
        System.out.println("=====================\n" +
                "   || ADA MOVIES ||\n" +
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


