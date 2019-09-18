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
public class Automata_PalabrasReservada_HttpRequestTest {
    
    public Automata_PalabrasReservada_HttpRequestTest() {
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
     * Test of ejecutarAutomata method, of class Automata_PalabrasReservada_HttpRequest_1.
     */
    @Test
    public void testEjecutarAutomataValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de palabras reservadas http request");
        char[] palabra = {'T', 'r', 'a', 'e', 'r', 'C', 'o', 'd', 'i', 'g', 'o'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_PalabrasReservada_HttpRequest instance = new Automata_PalabrasReservada_HttpRequest();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("TraerCodigo") && result.getTipoLexema().equals("Palabra Reservada: Http request")) {
            System.out.println("Valor enviado: \"TraerCodigo\"");
            System.out.println("Lexema enviado: \"TraerCodigo\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Palabra Reservada: Http request\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_PalabrasReservada_HttpRequest_1.
     */
    @Test
    public void testEjecutarAutomataNoValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de palabras reservadas http request");
        char[] palabra = {'T', 'r', 'a', 'e', 'r', 'C', 'o', 'd', 'i', 'g', 'o', 'o'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_PalabrasReservada_HttpRequest instance = new Automata_PalabrasReservada_HttpRequest();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"TraerCodigoo\"");
            System.out.println("El objeto es nulo");
        }
    }
}
