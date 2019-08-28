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
public class Automata_IdentificadorTest {
    
    public Automata_IdentificadorTest() {
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
     * Test of ejecutarAutomata method, of class Automata_Identificador.
     */
    @Test
    public void testEjecutarAutomataValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de identificador");
        char[] palabra = {'a', 'a', 'r'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_Identificador instance = new Automata_Identificador();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("aar") && result.getTipoLexema().equals("Identificador")) {
            System.out.println("Valor enviado: \"aar\"");
            System.out.println("Lexema enviado: \"aar\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Identificador\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_Identificador.
     */
    @Test
    public void testEjecutarAutomataNoValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de identificador");
        char[] palabra = {'6', 'd'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_TiposDatos instance = new Automata_TiposDatos();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"6d\"");
            System.out.println("El objeto es nulo");
        }
    }    
}
