
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        int opcao = 0;
        int continua = 2;

        do{
           try{
                opcao = menu.principal(sc);
            }catch(RuntimeException e){
                System.out.println(menu.erro());
            }

           
            switch(opcao){
            case 1:    
                do{
                    opcao = menu.adicionar(sc);
                    switch(opcao){
                        case 1: 
                            continua = menu.addArtista(sc, sc);
                            break;
                        case 2: 
                            continua = menu.addAlbum(sc, sc, sc);
                            break;
                        case 3: 
                            continua = menu.addMusica(sc, sc, sc, sc);
                            break;
                        case 4: 
                            // Gênero
                            //DatabaseManager.AddGenre(name);
                            break;
                        default:
                    }
                }while(continua == 1);
            break;
        
            case 2:
            do{
                opcao = menu.excluir(sc);
                switch(opcao){
                    case 1: 
                       
                        break;
                    case 2: 
                       
                        break;
                    case 3: 
                      
                        break;
                    case 4: 
                        // Gênero
                        //DatabaseManager.AddGenre(name);
                        break;
                }

            }while(continua == 1);
            break;

             /* 
            case 3:
                    System.out.println(menu.alterar());
                    opcao = sc.nextInt();
                    switch(opcao){
                        case 1: 
                            // Artista
                            break;
                        case 2: 
                            // Album
                            break;
                        case 3: 
                            // Música
                            break;
                        case 4: 
                            // Gênero
                            break;
                    }
                    break;
                case 4:
                    System.out.println(menu.consultar());
                    opcao = sc.nextInt();
                    switch(opcao){
                        case 1: 
                            // Artista
                            break;
                        case 2: 
                            // Album
                            break;
                        case 3: 
                            // Música
                            break;
                        case 4: 
                            // Gênero
                            break;
                    }
                    break;
            }
        */
        }

         
        sc.close();
    }while(continua != 3);
    }
}
