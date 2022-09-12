import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public int principal(Scanner sc) {
        System.out.println("\n Biblioteca de Músicas\n"
                + "  (1) Adicionar\n"
                + "  (2) Excluir  \n"
                + "  (3) Alterar  \n"
                + "  (4) Consultar e Imprimir\n"
                + "  (5) Sair     \n");
        int opcao = testaInteiro(sc);
        return opcao;
    }

    public String opcoes() {
        return "\n (1) Artista \n"
                + " (2) Album   \n"
                + " (3) Música  \n"
                + " (4) Gênero  \n"
                + " (5) Voltar Menu Principal\n";
    }

    public void erro() {
        System.out.println("-Opção não é válida, tente de novo.");
    }

    //testaInteiros() tratamento de exceção em grande parte do sistema
    public int testaInteiro(Scanner sc) {
        int in = 0;
        boolean error = true;
        while (error == true) {
            try {
                in = sc.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println(" Valor inválido, utilizar inteiros(int).\n"
                        + " -Tente novamente\n");
                sc.nextLine();
            }
        }
        return in;
    }

    public int adicionar(Scanner sc) {
        System.out.println("\n Adicionar" + opcoes());
        int opcao = testaInteiro(sc);
        return opcao;
    }

    public int excluir(Scanner sc) {

        System.out.println("\n Excluir" + opcoes());
        int opcao = testaInteiro(sc);
        return opcao;
    }

    public int alterar(Scanner sc) {

        System.out.println("\n Alterar" + opcoes());
        int opcao = testaInteiro(sc);
        return opcao;
    }

    public int consultar(Scanner sc) {

        System.out.println("\n Consultar" + opcoes());
        int opcao = testaInteiro(sc);
        return opcao;
    }

    private <T extends BaseEntity> void list(ArrayList<T> list) {
        list.forEach((item) -> System.out.println(item.toString()));
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //////// ADICIONAR......
    public int addArtista(Scanner sc) {
        sc.nextLine();
        System.out.print(" Artista\n  -Nome do artista: ");
        String nome;
        nome = sc.nextLine();
        DatabaseManager.AddArtist(nome);
        System.out.println("\n >Artista \"" + nome + "\" adicionado");
        list(DatabaseManager.GetAllArtists());

        return voltarMenuAdicionar(sc);
    }

    public int addAlbum(Scanner sc) {
        sc.nextLine();
        System.out.print(" Album\n -Nome do album: ");
        String nome = sc.nextLine();
        System.out.println("\n -O album \"" + nome + "\" é de qual artista, informe o ID.");
        System.out.println(" -Artistas: ");
        list(DatabaseManager.GetAllArtists());
        System.out.print("\n -ID do artista: ");
        int id = testaInteiro(sc);

        DatabaseManager.AddAlbum(nome, id);
        System.out.println("\n >Album \"" + nome + "\" adicionado");
        list(DatabaseManager.GetAllAlbums());

        return voltarMenuAdicionar(sc);
    }

    public int addMusica(Scanner sc) {
        sc.nextLine();
        System.out.print("\n Música\n -Nome da música: ");
        String name = sc.nextLine();
        System.out.println("\n -A música \"" + name + "\" é de qual album?");
        System.out.println(" -Albuns: ");
        list(DatabaseManager.GetAllAlbums());

        System.out.print("\n -ID do Album que a música pertence: ");
        int albumId = testaInteiro(sc);

        System.out.print("\n -Duração da música em segundos: ");
        int duration = testaInteiro(sc);

        System.out.println("\n -A música \"" + name + "\" é de qual genero?");
        System.out.println(" -Generos: ");
        list(DatabaseManager.GetAllGenres());

        System.out.print("\n -ID do genero: ");
        int genreId = testaInteiro(sc);

        DatabaseManager.AddTrack(name, albumId, genreId, duration);
        System.out.println("\n >Música \"" + name + "\" adicionada<");
        list(DatabaseManager.GetAllTracks());

        return voltarMenuAdicionar(sc);
    }

    public int addGenero(Scanner sc) {
        sc.nextLine();
        System.out.print(" Gênero\n  -Nome do gênero musical: ");
        String nome;
        nome = sc.nextLine();
        DatabaseManager.AddGenre(nome);
        System.out.println("\n >Gênero musical \"" + nome + "\" adicionado");
        list(DatabaseManager.GetAllGenres());

        return voltarMenuAdicionar(sc);
    }

    //////////////////////////////////////////////////////////////////////////////////////
    /////// EXCLUIR......
    public int excluirArtista(Scanner sc) {
        sc.nextLine();
        System.out.println(" Excluir artista");
        System.out.println(" -Artistas: ");
        list(DatabaseManager.GetAllArtists());

        System.out.print("\n -ID do artista: ");
        int id = testaInteiro(sc);

        System.out.println("\n -Tem certeza que deseja excluir o artista: "
                + DatabaseManager.GetArtistById(id).toString());
        System.out.println("  (1)Sim\n  (2)Não");
        int sn = testaInteiro(sc);
        if (sn == 1) {
            DatabaseManager.DeleteArtist(id);
            System.out.println("\n -Artista excluido");
            list(DatabaseManager.GetAllArtists());
        } else {
            System.out.println(" \n -Cancelado");
        }

        return voltarMenuExcluir(sc);
    }

    public int excluirAlbum(Scanner sc) {
        sc.nextLine();
        System.out.println(" Excluir album");
        System.out.println(" -Albuns: ");
        list(DatabaseManager.GetAllAlbums());

        System.out.print("\n -ID do album: ");
        int id = testaInteiro(sc);

        System.out.println("\n -Tem certeza que deseja excluir o album: "
                + DatabaseManager.GetAlbumById(id).toString());
        System.out.println("  (1)Sim\n  (2)Não");
        int sn = testaInteiro(sc);
        if (sn == 1) {
            DatabaseManager.DeleteAlbum(id);
            System.out.println("\n -Album excluido");
            list(DatabaseManager.GetAllAlbums());
        } else {
            System.out.println(" \n -Cancelado");
        }
        return voltarMenuExcluir(sc);
    }

    public int excluirMusica(Scanner sc) {
        sc.nextLine();
        System.out.println(" Excluir música");
        System.out.println(" -Músicas: ");
        list(DatabaseManager.GetAllTracks());

        System.out.print("\n -ID do album: ");
        int id = testaInteiro(sc);

        System.out.println("\n -Tem certeza que deseja excluir a música: "
                + DatabaseManager.GetTrackById(id).toString());
        System.out.println("  (1)Sim\n  (2)Não");
        int sn = testaInteiro(sc);
        if (sn == 1) {
            DatabaseManager.DeleteTrack(id);
            System.out.println("\n -Música excluida");
            list(DatabaseManager.GetAllTracks());
        } else {
            System.out.println(" \n -Cancelado");
        }

        return voltarMenuExcluir(sc);
    }

    public int excluirGenero(Scanner sc) {
        sc.nextLine();
        System.out.println(" Excluir gênero musical");
        System.out.println(" -Gêneros: ");
        list(DatabaseManager.GetAllGenres());

        System.out.print("\n -ID do gênero: ");
        int id = testaInteiro(sc);

        System.out.println("\n -Tem certeza que deseja excluir o gênero: "
                + DatabaseManager.GetGenreById(id).toString());
        System.out.println("  (1)Sim\n  (2)Não");
        int sn = testaInteiro(sc);
        if (sn == 1) {
            DatabaseManager.DeleteGenre(id);
            System.out.println("\n -Gênero excluido");
            list(DatabaseManager.GetAllGenres());
        } else {
            System.out.println(" \n -Cancelado");
        }

        return voltarMenuExcluir(sc);
    }

    /////////////////////////////////////////////////////////////////////////////
    /////// ALTERAR........
    public int alterarArtista(Scanner sc) {
        sc.nextLine();
        System.out.println(" Alterar artista");
        System.out.println(" -Artistas: ");
        list(DatabaseManager.GetAllArtists());

        System.out.print("\n -ID do artista: ");
        int id = testaInteiro(sc);
        sc.nextLine();
        System.out.print("\n -Novo nome: ");
        String name = sc.nextLine();

        System.out.println("\n <Antigo " + DatabaseManager.GetArtistById(id).toString());
        DatabaseManager.UpdateArtist(id, name);
        System.out.println(" >Novo " + DatabaseManager.GetArtistById(id).toString() + "\n");
        list(DatabaseManager.GetAllArtists());

        return voltarMenuAlterar(sc);
    }

    public int alterarAlbum(Scanner sc) {
        sc.nextLine();
        System.out.println(" Alterar album");
        System.out.println(" -Albuns: ");
        list(DatabaseManager.GetAllAlbums());

        System.out.print("\n -ID do album: ");
        int id = testaInteiro(sc);
        sc.nextLine();
        System.out.print("\n -Novo nome: ");
        String name = sc.nextLine();
        list(DatabaseManager.GetAllArtists());
        System.out.print("\n -ID do artista:");
        int idArtista = testaInteiro(sc);

        System.out.println("\n <Antigo " + DatabaseManager.GetAlbumById(id).toString());
        DatabaseManager.UpdateAlbum(id, name, idArtista);
        System.out.println(" >Novo " + DatabaseManager.GetAlbumById(id).toString() + "\n");
        list(DatabaseManager.GetAllAlbums());

        return voltarMenuAlterar(sc);
    }

    public int alteraMusica(Scanner sc) {
        sc.nextLine();
        System.out.println(" Alterar música");
        System.out.println(" -Músicas: ");
        list(DatabaseManager.GetAllTracks()); 

        System.out.print("\n -ID da música: ");
        int id = testaInteiro(sc);
        sc.nextLine();
        System.out.print("\n -Novo nome: ");
        String name = sc.nextLine();
        System.out.print("\n -Nova duração:");
        int duration = testaInteiro(sc);
        System.out.println("\n -Albuns:");
        list(DatabaseManager.GetAllAlbums());
        System.out.print("\n -ID do album: ");
        int albumId = testaInteiro(sc);
        System.out.println("\n -Gêneros:");
        list(DatabaseManager.GetAllGenres());
        System.out.print("\n -ID do genero: ");
        int genreId = testaInteiro(sc);

        System.out.println("\n <Antigo " + DatabaseManager.GetTrackById(id).toString());
        DatabaseManager.UpdateTrack(id, name, albumId, genreId, duration);
        System.out.println(" >Novo " + DatabaseManager.GetTrackById(id).toString() + "\n");
        list(DatabaseManager.GetAllTracks());

        return voltarMenuAlterar(sc);
    }

    public int alterarGenero(Scanner sc) {
        sc.nextLine();
        System.out.println(" Alterar Gênero");
        System.out.println(" -Gêneros: ");
        list(DatabaseManager.GetAllGenres());

        System.out.print("\n -ID do gênero: ");
        int id = testaInteiro(sc);
        sc.nextLine();
        System.out.print("\n -Novo nome: ");
        String name = sc.nextLine();

        System.out.println("\n <Antigo " + DatabaseManager.GetGenreById(id).toString());
        DatabaseManager.UpdateGenre(id, name);
        System.out.println(" >Novo " + DatabaseManager.GetGenreById(id).toString() + "\n");
        list(DatabaseManager.GetAllGenres());

        return voltarMenuAlterar(sc);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////// CONSULTAR e IMPRIMIR......

    public int consultarArtista(Scanner sc) {
        sc.nextLine();
        System.out.println("\n Consultar artista\n");
        System.out.println(" (1)Imprimir lista completa\n"
                         + " (2)Consultar por ID\n");
        int umOuDois = testaInteiro(sc);
        int id;
        if (umOuDois == 1) {
            System.out.println("\n -Lista de artistas");
            list(DatabaseManager.GetAllArtists());
        } else if (umOuDois == 2) {
            System.out.print("\n -ID: ");
            id = testaInteiro(sc);
            System.out.println("\n -Artista: " + DatabaseManager.GetArtistById(id).toString());
        }

        return voltarMenuConsultar(sc);
    }

    public int consultarAlbum(Scanner sc) {
        sc.nextLine();
        System.out.println("\n Consultar album\n");
        System.out.println(" (1)Imprimir lista completa\n"
                         + " (2)Consultar por ID\n");
        int umOuDois = testaInteiro(sc);
        int id;
        if (umOuDois == 1) {
            System.out.println("\n -Lista de albuns");
            list(DatabaseManager.GetAllAlbums());
        } else if (umOuDois == 2) {
            System.out.print("\n -ID: ");
            id = testaInteiro(sc);
            System.out.println("\n -Album: " + DatabaseManager.GetAlbumById(id).toString());
        }

        return voltarMenuConsultar(sc);
    }

    public int consultarMusica(Scanner sc) {
        sc.nextLine();
        System.out.println("\n Consultar música\n");
        System.out.println(" (1)Imprimir lista completa\n"
                         + " (2)Consultar por ID\n");
        int umOuDois = testaInteiro(sc);
        int id;
        if (umOuDois == 1) {
            System.out.println("\n -Lista de músicas");
            list(DatabaseManager.GetAllTracks());
        } else if (umOuDois == 2) {
            System.out.print("\n -ID: ");
            id = testaInteiro(sc);
            System.out.println("\n -Música: " + DatabaseManager.GetTrackById(id).toString());
        }

        return voltarMenuConsultar(sc);
    }

    public int consultarGenero(Scanner sc) {
        sc.nextLine();
        System.out.println("\n Consultar gênero\n");
        System.out.println(" (1)Imprimir lista completa\n"
                         + " (2)Consultar por ID\n");
        int umOuDois = testaInteiro(sc);
        int id;
        if (umOuDois == 1) {
            System.out.println("\n -Lista de gênetos");
            list(DatabaseManager.GetAllGenres());
        } else if (umOuDois == 2) {
            System.out.print("\n -ID: ");
            id = testaInteiro(sc);
            System.out.println("\n -Gênero: " + DatabaseManager.GetGenreById(id).toString());
        }

        return voltarMenuConsultar(sc);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    ////// Menus de retorno

    public int voltarMenuAdicionar(Scanner sc) {
        System.out.println("\n (1)Voltar menu Adicionar\n"
                + " (2)Menu Principal\n"
                + " (3)Fechar o Programa");
        int continua = testaInteiro(sc);

        if (continua == 1)
            return 1;
        else if (continua == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    public int voltarMenuExcluir(Scanner sc) {
        System.out.println("\n (1)Voltar menu Excluir\n"
                + " (2)Menu Principal\n"
                + " (3)Fechar o Programa");
        int continua = testaInteiro(sc);

        if (continua == 1)
            return 1;
        else if (continua == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    public int voltarMenuAlterar(Scanner sc) {
        System.out.println("\n (1)Voltar menu Alterar\n"
                + " (2)Menu Principal\n"
                + " (3)Fechar o Programa");
        int continua = testaInteiro(sc);

        if (continua == 1)
            return 1;
        else if (continua == 2) {
            return 2;
        } else {
            return 3;
        }
    }

    public int voltarMenuConsultar(Scanner sc) {
        System.out.println("\n (1)Voltar menu Consultar\n"
                + " (2)Menu Principal\n"
                + " (3)Fechar o Programa");
        int continua = testaInteiro(sc);

        if (continua == 1)
            return 1;
        else if (continua == 2) {
            return 2;
        } else {
            return 3;
        }
    }
}
