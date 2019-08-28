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
public class Automata_PalabrasReservada_MainTest {
    
    public Automata_PalabrasReservada_MainTest() {
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
     * Test of ejecutarAutomata method, of class Automata_PalabrasReservada_Main.
     */
    @Test
    public void testEjecutarAutomataValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de palabras reservadas main");
        char[] palabra = {'_', '_', 'm', 'a', 'i', 'n', '_', '_'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_PalabrasReservada_Main instance = new Automata_PalabrasReservada_Main();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("__main__") && result.getTipoLexema().equals("Palabra Reservada: Main")) {
            System.out.println("Valor enviado: \"__main__\"");
            System.out.println("Lexema enviado: \"__main__\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Palabra Reservada: Main\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_PalabrasReservada_Main.
     */
    @Test
    public void testEjecutarAutomataNoValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de palabras reservadas main");
        char[] palabra = {'_', '_', 'm', 'a', 'i', 'n', '_', '_', '_'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_PalabrasReservada_Main instance = new Automata_PalabrasReservada_Main();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"__main___\"");
            System.out.println("El objeto es nulo");
        }
    }
}
