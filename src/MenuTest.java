
import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class MenuTest {

    @Test // Teste do método menu.principal();
    public void testPrincipal() {
        Menu menu = new Menu();
        Scanner sc = new Scanner("1");

        assertEquals(1, menu.principal(sc));
    }

    @Test // Teste do método menu.adicionar();
    public void testAdicionar() {
        Menu menu = new Menu();
        Scanner sc = new Scanner("2");

        assertEquals(2, menu.adicionar(sc));
    }

    @Test // Teste do método menu.excluir();
    public void testExcluir() {
        Menu menu = new Menu();
        Scanner sc = new Scanner("3");

        assertEquals(3, menu.excluir(sc));
    }

    @Test // Teste do método menu.alterar();
    public void testAlterar() {
        Menu menu = new Menu();
        Scanner sc = new Scanner("4");

        assertEquals(4, menu.alterar(sc));
    }

    @Test // Teste do método menu.consultar();
    public void testConsultar() {
        Menu menu = new Menu();
        Scanner sc = new Scanner("5");

        assertEquals(5, menu.consultar(sc));
    }

}
