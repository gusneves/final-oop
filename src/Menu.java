
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

    public String alterar(){

        return "\n Alterar" + opcoes();
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
        System.out.println("\n -O album \"" + nome +  "\" é de qual artista, informe o ID.\n");
        System.out.println(" -Artistas: " + DatabaseManager.GetAllArtists());
        System.out.printf("\n -ID do artista(int): ");
        int id;
        try{
            id = t.nextInt();
        }catch(RuntimeException e){
            System.out.println("\n Valor invalido informe números inteiros.\n");
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
        System.out.println("\n -A música \"" + name +  "\" é de qual album, informe o ID.\n");
        System.out.println(" -Albuns: " + DatabaseManager.GetAllAlbums());
        int id;
        try{
            System.out.printf("\n -ID do Album(int): ");
            id = t.nextInt();
        }catch(RuntimeException e){
            System.out.println("\nValor invalido informe números inteiros.\n");
            System.out.println(" -ID (do tipo int): ");
            id = t.nextInt();
        }
        int duration;
        try{
        System.out.printf("\n -Duração da música em segundos(int): ");
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




    





    public int voltarMenuPrincipal(Scanner w){
        System.out.println("\n (1)Voltar ao menu principal\n" 
                           + " (2)Fechar o programa\n");
        int continua = w.nextInt();

        if(continua == 1)
            return 1;
        else{
            return 0;
        }
    }

    public int voltarMenuAdicionar(Scanner w){
        System.out.println("\n (1)Menu adicionar\n" 
                           + " (2)Menu principal\n"
                           + " (3)Fechar o programa");
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
