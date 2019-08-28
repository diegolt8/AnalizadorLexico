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
public class Automata_ValorNumericoTest {
    
    public Automata_ValorNumericoTest() {
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
     * Test of ejecutarAutomata method, of class Automata_PalabrasReservada_Nulo.
     */
    @Test
    public void testEjecutarAutomataValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de valor numerico");
        char[] palabra = {'1', '0', '0', '0'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_ValorNumerico instance = new Automata_ValorNumerico();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("1000") && result.getTipoLexema().equals("Valor Numerico")) {
            System.out.println("Valor enviado: \"1000\"");
            System.out.println("Lexema enviado: \"1000\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Valor Numerico\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_PalabrasReservada_Nulo.
     */
    @Test
    public void testEjecutarAutomataNoValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de valor numerico");
        char[] palabra = {'1', '0', '0', '0', 'a'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_ValorNumerico instance = new Automata_ValorNumerico();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"1000a\"");
            System.out.println("El objeto es nulo");
        }
    }
}
