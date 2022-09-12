import static org.junit.Assert.assertEquals;
import java.util.Scanner;
import org.junit.Test;

public class MenuTest {
    // JUnit, testando a entrada de parametro(int) do método com entrada de int (expected: sucesso) e entrada de String (expected: Excecão)
 
    @Test // Teste de entrada de dados correta do método menu.principal();
    public void principal(){
        Menu menu = new Menu();
        Scanner sc = new Scanner("1");

        assertEquals(1, menu.principal(sc));
    }
    
    @Test(expected = Exception.class) // Teste de entrada de dados incorretos no menu.principal();
    public void principalExcecao(){
        Menu menu = new Menu();
        Scanner sc = new Scanner("adcd");
     
        assertEquals(1, menu.principal(sc));
    }

    @Test // Teste de entrada de dados correta do método menu.adicionar();
    public void adicionar(){
        Menu menu = new Menu();
        Scanner sc = new Scanner("2");

        assertEquals(2, menu.adicionar(sc));
    }

    @Test(expected = Exception.class) // Teste de entrada de dados incorretos no menu.adicionar();
    public void adicionarExcecao()
    {
        Menu menu = new Menu();
        Scanner sc = new Scanner("abcd");
       
        menu.adicionar(sc);
    }

    @Test // Teste do método menu.excluir();
    public void excluir(){
        Menu menu = new Menu();
        Scanner sc = new Scanner("3");

        assertEquals(3, menu.excluir(sc));
    }

    @Test(expected = Exception.class)
    public void excluirExcecao()
    {
        Menu menu = new Menu();
        Scanner sc = new Scanner("abcd");
       
        menu.excluir(sc);
    }

    @Test // Teste do método menu.alterar();
    public void alterar(){
        Menu menu = new Menu();
        Scanner sc = new Scanner("4");

        assertEquals(4, menu.alterar(sc));
    }

    @Test(expected = Exception.class)
    public void alterarExcecao()
    {
        Menu menu = new Menu();
        Scanner sc = new Scanner("abcd");
       
        menu.alterar(sc);
    }

    @Test // Teste do método menu.consultar();
    public void consultar(){
        Menu menu = new Menu();
        Scanner sc = new Scanner("5");

        assertEquals(5, menu.consultar(sc));
    }

    @Test(expected = Exception.class)
    public void consultarExcecao()
    {
        Menu menu = new Menu();
        Scanner sc = new Scanner("abcd");
       
        menu.consultar(sc);
    }
}
