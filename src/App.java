import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Genre> genres = DatabaseManager.GetAllGenres();

        for (Genre genre : genres) {
            System.out.println(genre.toString());
        }

        Menu menu = new Menu();
        int p = 0;

        do{
           try{
                System.out.println(menu.principal());
                p = sc.nextInt();

            }catch(RuntimeException e){
                System.out.println(menu.erro());
                break;
            }

            switch(p){
                case 1:
                    System.out.println(menu.adicionar());
                    p = sc.nextInt();
                    switch(p){
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
                case 2:
                    System.out.println(menu.excluir());
                    p = sc.nextInt();
                    switch(p){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 3:
                    System.out.println(menu.alterar());
                    p = sc.nextInt();
                    switch(p){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
                case 4:
                    System.out.println(menu.consultar());
                    p = sc.nextInt();
                    switch(p){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }
                    break;
            }
        
        }while(false);


        sc.close();
    }
}
