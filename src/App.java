import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        int opcao = 0;
        int continua = 0;

        do {
            opcao = menu.principal(sc);

            switch (opcao) {
                case 1:
                    do {
                        opcao = menu.adicionar(sc);
                        switch (opcao) {
                            case 1:
                                continua = menu.addArtista(sc);
                                break;
                            case 2:
                                continua = menu.addAlbum(sc);
                                break;
                            case 3:
                                continua = menu.addMusica(sc);
                                break;
                            case 4:
                                continua = menu.addGenero(sc);
                                break;
                            case 5:
                                continua = 2;
                                break;
                            default:
                                menu.erro();
                                continua = 1;
                        }
                    } while (continua == 1);
                    break;

                case 2:
                    do {
                        opcao = menu.excluir(sc);
                        switch (opcao) {
                            case 1:
                                continua = menu.excluirArtista(sc);
                                break;
                            case 2:
                                continua = menu.excluirAlbum(sc);
                                break;
                            case 3:
                                continua = menu.excluirMusica(sc);
                                break;
                            case 4:
                                continua = menu.excluirGenero(sc);
                                break;
                            case 5:
                                continua = 2;
                                break;
                            default:
                                menu.erro();
                                continua = 1;
                        }
                    } while (continua == 1);
                    break;

                case 3:
                    do {
                        opcao = menu.alterar(sc);
                        switch (opcao) {
                            case 1:
                                continua = menu.alterarArtista(sc);
                                break;
                            case 2:
                                continua = menu.alterarAlbum(sc);
                                break;
                            case 3:
                                continua = menu.alteraMusica(sc);
                                break;
                            case 4:
                                continua = menu.alterarGenero(sc);
                                break;
                            case 5:
                                continua = 2;
                                break;
                            default:
                                menu.erro();
                                continua = 1;
                        }
                    } while (continua == 1);
                    break;

                case 4:
                    do {
                        opcao = menu.consultar(sc);
                        switch (opcao) {
                            case 1:
                                continua = menu.consultarArtista(sc);
                                break;
                            case 2:
                                continua = menu.consultarAlbum(sc);
                                break;
                            case 3:
                                continua = menu.consultarMusica(sc);
                                break;
                            case 4:
                            continua = menu.consultarGenero(sc);
                                break;
                            case 5:
                                continua = 2;
                                break;
                            default:
                                menu.erro();
                                continua = 1;
                        }
                    } while (continua == 1);
                    break;

                case 5:
                    continua = 3;
                    break;

                default:
                    menu.erro();
                    continua = 0;
                    break;
            }
        } while (continua != 3);
        sc.close();
    }
}
