/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.automatas;

import modelo.FlujoCaracteres;
import modelo.Lexema;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pepe
 */
public class Automata_ValorCadenaTest {
    
    public Automata_ValorCadenaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_ValorCadena.
     */
    @Test
    public void testEjecutarAutomataValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de valor cadena");
        char[] palabra = {'\'', 'C', 'a', 'd', 'e', 'n', 'a', '\''};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_ValorCadena instance = new Automata_ValorCadena();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("\'Cadena\'") && result.getTipoLexema().equals("Valor Cadena")) {
            System.out.println("Valor enviado: \"\'Cadena\'\"");
            System.out.println("Lexema enviado: \"\'Cadena\'\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Valor cadena\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_ValorCadena.
     */
    @Test
    public void testEjecutarAutomataNoValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de valor cadena");
        char[] palabra = {'C', 'a', 'd', 'e', 'n', 'a', '\''};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_ValorCadena instance = new Automata_ValorCadena();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"Cadena\'\"");
            System.out.println("El objeto es nulo");
        }
    }
}
