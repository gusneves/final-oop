
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public int principal(Scanner scanner){
           System.out.println("\n Biblioteca de Músicas\n"
                             + "  (1) Adicionar\n"
                             + "  (2) Excluir  \n"
                             + "  (3) Alterar  \n"
                             + "  (4) Consultar\n"
                             + "  (5) Sair     \n");
        int opcao = scanner.nextInt();
        return opcao;
    }
    
    public String opcoes(){
        return "\n  (1) Artista \n"
               + "  (2) Album   \n"
               + "  (3) Música  \n"
               + "  (4) Gênero  \n";
    }

    public int adicionar(Scanner sc){

        System.out.println("\n Adicionar" + opcoes());
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public int excluir(Scanner sc){

        System.out.println("\n Excluir" + opcoes());
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public int alterar(Scanner sc){

        System.out.println("\n Alterar" + opcoes());
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public String consultar(){

        return "\n Consultar" + opcoes();
    }

    public String erro(){
        return "Valor digitado não esta entre as opções";
    }
    
///////////////////////////////////////////////////////////////////////////////////////
    public int addArtista(Scanner sc, Scanner w){

        System.out.print(" Artista\n  -Nome do artista: ");
        String nome; 
        nome = sc.nextLine();
        DatabaseManager.AddArtist(nome);
        System.out.println("\n >Artista \"" + nome + "\" adicionado");

        return voltarMenuAdicionar(w);
    }

    public int addAlbum(Scanner sc, Scanner t, Scanner w){

        System.out.print(" Album\n -Nome do album: ");
        String nome = sc.nextLine();
        System.out.println("\n -O album \"" + nome +  "\" é de qual artista, informe o ID.");
        System.out.println(" -Artistas: " + DatabaseManager.GetAllArtists());
        System.out.print("\n -ID do artista(int): ");
        int id;
        
        try{
            id = t.nextInt();
        }catch(InputMismatchException e){
            System.out.println("\n Valor invalido informe números inteiros. " +e.getMessage()+ " \n");
            System.out.println(" -ID (do tipo int): ");
            id = t.nextInt();
        }

        DatabaseManager.AddAlbum(nome, id);
        System.out.println("\n >Album \"" + nome + "\" adicionado");

        return voltarMenuAdicionar(w);
    }

    public int addMusica(Scanner sc, Scanner t, Scanner p, Scanner w){

        System.out.print("\n Música\n -Nome da música: ");
        String name = sc.nextLine();
        System.out.println("\n -A música \"" + name +  "\" é de qual album, informe o ID.");
        System.out.println(" -Albuns: " + DatabaseManager.GetAllAlbums());
        int id;
        try{
            System.out.print("\n -ID do Album(int): ");
            id = t.nextInt();
        }catch(RuntimeException e){
            System.out.println("\nValor invalido informe números inteiros.\n");
            System.out.println(" -ID (do tipo int): ");
            id = t.nextInt();
        }
        int duration;
        try{
            System.out.print("\n -Duração da música em segundos(int): ");
            duration = p.nextInt();
        }catch(RuntimeException e){
            p.nextLine();
            System.out.println("\n -Valor invalido informe números inteiros.\n");
            System.out.print(" -Duração (do tipo int): ");
            duration = p.nextInt();
        }
        DatabaseManager.AddTrack(name, id, duration);
        System.out.println("\n >Música \"" + name + " \" adicionada< \n" );
     
        return voltarMenuAdicionar(w);
    }
    //////////////////////////////////////////////////////////////////////////////////////
    /////// EXCLUIR.......
    public int excluirArtista(Scanner sc, Scanner t, Scanner w){

        System.out.println(" Excluir artista");
        System.out.println(" -Artistas: " + DatabaseManager.GetAllArtists());

        System.out.print("\n -ID do artista(int): ");
        int id = sc.nextInt();

        System.out.println("\n -Tem certeza que deseja excluir o artista: "+ DatabaseManager.GetArtistById(id));
        System.out.println("  (1)Sim\n  (2)Não");
        int sn = t.nextInt();
        if(sn == 1){
            DatabaseManager.DeleteArtist(id);
            System.out.println("\n -Artista excluido");
        }else{
            System.out.println(" \n -Cancelado");
        }
    
        return voltarMenuExcluir(w);
    }

    public int excluirAlbum(Scanner sc, Scanner t, Scanner w){

        System.out.println(" Excluir album");
        System.out.println(" -Albuns: " + DatabaseManager.GetAllAlbums());

        System.out.print("\n -ID do album(int): ");
        int id = sc.nextInt();

        System.out.println("\n -Tem certeza que deseja excluir o album: "+ DatabaseManager.GetAlbumById(id));
        System.out.println("  (1)Sim\n  (2)Não");
        int sn = t.nextInt();
        if(sn == 1){
            DatabaseManager.DeleteArtist(id);
            System.out.println("\n -Album excluido");
        }else{
            System.out.println(" \n -Cancelado");
        }
        return voltarMenuExcluir(w);
    }
    
    public int excluirMusica(Scanner sc, Scanner t, Scanner w){

        System.out.println(" Excluir música");
        System.out.println(" -Músicas: " + DatabaseManager.GetAllTracks());

        System.out.print("\n -ID do album(int): ");
        int id = sc.nextInt();

        System.out.println("\n -Tem certeza que deseja excluir a música: "+ DatabaseManager.GetTrackById(id));
        System.out.println("  (1)Sim\n  (2)Não");
        int sn = t.nextInt();
        if(sn == 1){
            DatabaseManager.DeleteArtist(id);
            System.out.println("\n -Música excluida");
        }else{
            System.out.println(" \n -Cancelado");
        }
    
        return voltarMenuExcluir(w);
    }
    /////////////////////////////////////////////////////////////////////////////

    public int alterarArtista(Scanner sc, Scanner t, Scanner w){

        System.out.println(" Alterar artista");
        System.out.println(" -Artistas: " + DatabaseManager.GetAllArtists());

        System.out.print("\n -ID do artista(int): ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("\n -Novo nome: ");
        String name = t.nextLine();

        System.out.println("\n -Antigo " + DatabaseManager.GetArtistById(id));
        DatabaseManager.UpdateArtist(id, name);
        System.out.println("\n -Novo " + DatabaseManager.GetArtistById(id));

        return voltarMenuAlterar(w);

    }

    public int alterarAlbum(Scanner sc, Scanner t, Scanner q, Scanner w){

        System.out.println(" Alterar album");
        System.out.println(" -Albuns: " + DatabaseManager.GetAllAlbums());

        System.out.print("\n -ID do album(int): ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("\n -Novo nome: ");
        String name = t.nextLine();
        System.out.print("\n -ID do artista(int):");
        int idArtista = q.nextInt();

        System.out.println("\n -Antigo " + DatabaseManager.GetAlbumById(id));
        DatabaseManager.UpdateAlbum(id, name, idArtista);
        System.out.println("\n -Novo " + DatabaseManager.GetAlbumById(id));

        return voltarMenuAlterar(w);
    }

    public int alteraMusica(Scanner sc, Scanner t, Scanner q, Scanner w){

        System.out.println(" Alterar música");
        System.out.println(" -Músicas: " + DatabaseManager.GetAllTracks());

        System.out.print("\n -ID da música(int): ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("\n -Novo nome: ");
        String name = t.nextLine();
        System.out.print("\n -Nova duração:");
        int duration = q.nextInt();

        System.out.println("\n -Antigo " + DatabaseManager.GetTrackById(id));
        DatabaseManager.UpdateTrack(id, name, duration);
        System.out.println("\n -Novo " + DatabaseManager.GetTrackById(id));

        return voltarMenuAlterar(w);
    }

    public int voltarMenuPrincipal(Scanner w){
        System.out.println("\n (1)Menu Principal\n" 
                           + " (2)Fechar o Programa\n");
        int continua = w.nextInt();

        if(continua == 1)
            return 1;
        else{
            return 0;
        }
    }

    public int voltarMenuAdicionar(Scanner w){
        System.out.println("\n (1)Menu Adicionar\n" 
                           + " (2)Menu Principal\n"
                           + " (3)Fechar o Programa");
        int continua = w.nextInt();

        if(continua == 1)
            return 1;
        else if(continua == 2){
            return 2;
        }else{
            return 3;
        }
    }

    public int voltarMenuExcluir(Scanner w){
        System.out.println("\n (1)Menu Excluir\n" 
                           + " (2)Menu Principal\n"
                           + " (3)Fechar o Programa");
        int continua = w.nextInt();

        if(continua == 1)
            return 1;
        else if(continua == 2){
            return 2;
        }else{
            return 3;
        }
    }

    public int voltarMenuAlterar(Scanner w){
        System.out.println("\n (1)Menu Alterar\n" 
                           + " (2)Menu Principal\n"
                           + " (3)Fechar o Programa");
        int continua = w.nextInt();

        if(continua == 1)
            return 1;
        else if(continua == 2){
            return 2;
        }else{
            return 3;
        }
    }

}
