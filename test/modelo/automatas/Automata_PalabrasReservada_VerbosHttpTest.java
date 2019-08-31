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
public class Automata_PalabrasReservada_VerbosHttpTest {
    
    public Automata_PalabrasReservada_VerbosHttpTest() {
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
     * Test of ejecutarAutomata method, of class Automata_PalabrasReservada_VerbosHttp.
     */
    @Test
    public void testEjecutarAutomataValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de palabras reservadas verbos http");
        char[] palabra = {'C', 'o', 'n', 's', 'u', 'l', 't', 'a', 'r'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_PalabrasReservada_VerbosHttp instance = new Automata_PalabrasReservada_VerbosHttp();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("Consultar") && result.getTipoLexema().equals("Palabra Reservada: Verbos http")) {
            System.out.println("Valor enviado: \"Consultar\"");
            System.out.println("Lexema enviado: \"Consultar\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Palabra Reservada: Verbos http\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_PalabrasReservada_VerbosHttp.
     */
    @Test
    public void testEjecutarAutomataNoValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de palabras reservadas verbos http");
        char[] palabra = {'C', 'o', 'n', 's', 'u', 'l', 't', 'a', 'r', 'r'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_PalabrasReservada_VerbosHttp instance = new Automata_PalabrasReservada_VerbosHttp();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"Consultarr\"");
            System.out.println("El objeto es nulo");
        }
    }
}
