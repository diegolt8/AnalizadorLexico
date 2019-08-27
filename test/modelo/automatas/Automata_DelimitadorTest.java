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
public class Automata_DelimitadorTest {
    
    public Automata_DelimitadorTest() {
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
     * Test of ejecutarAutomata method, of class Automata_Delimitador.
     */
    @Test
    public void testEjecutarAutomataValida() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de delimitadores");
        char[] palabra = {';'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_Delimitador instance = new Automata_Delimitador();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals(";") && result.getTipoLexema().equals("Delimitador")) {
            System.out.println("Valor enviado: \";\"");
            System.out.println("Lexema enviado: \";\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Delimitador\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }
    
    /**
     * Test of ejecutarAutomata method, of class Automata_Delimitador.
     */
    @Test
    public void testEjecutarAutomataNoValida() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de delimitadores");
        char[] palabra = {'6'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_Delimitador instance = new Automata_Delimitador();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"6\"");
            System.out.println("El objeto es nulo");
        }
    }   
}
