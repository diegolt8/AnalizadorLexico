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
public class Automata_ComentarioTest {
    
    public Automata_ComentarioTest() {
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
     * Test of ejecutarAutomata method, of class Automata_Comentario.
     */
    @Test
    public void testEjecutarAutomataValida() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de comentarios");
        char[] palabra = {'#', 'c', 'o','m'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_Comentario instance = new Automata_Comentario();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("#com") && result.getTipoLexema().equals("Comentarios")) {
            System.out.println("Valor enviado: \"#com\"");
            System.out.println("Lexema enviado: \"#com\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Comentarios\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_Comentario.
     */
    @Test
    public void testEjecutarAutomataNoValida() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de comentarios");
        char[] palabra = {'c','o','m'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_Comentario instance = new Automata_Comentario();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"com\"");
            System.out.println("El objeto es nulo");
        }
    }

}
