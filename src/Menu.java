public class Menu {
    
    public String principal(){

      return "\n Biblioteca de Músicas\n"
             + "  (1) Adicionar\n"
             + "  (2) Excluir  \n"
             + "  (3) Alterar  \n"
             + "  (4) Consultar\n"
             + "  (5) Sair     \n";
    }
    
    public String opcoes(){
        return "\n  (1) Artista \n"
               + "  (2) Album   \n"
               + "  (3) Música  \n"
               + "  (4) Gênero  \n";
    }
    
    public String adicionar(){

        return "\n Adicionar" + opcoes();
    }

    public String excluir(){

        return "\n Excluir" + opcoes();
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
}
