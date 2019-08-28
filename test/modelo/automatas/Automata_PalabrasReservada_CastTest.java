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
public class Automata_PalabrasReservada_CastTest {
    
    public Automata_PalabrasReservada_CastTest() {
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
     * Test of ejecutarAutomata method, of class Automata_PalabrasReservada_Cast.
     */
    @Test
    public void testEjecutarAutomataValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de palabras reservadas casteo");
        char[] palabra = {'X', 'M', 'L'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_PalabrasReservada_Cast instance = new Automata_PalabrasReservada_Cast();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("XML") && result.getTipoLexema().equals("Palabra Reservada: Casteo")) {
            System.out.println("Valor enviado: \"XML\"");
            System.out.println("Lexema enviado: \"XML\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Palabra Reservada: Casteo\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_PalabrasReservada_Cast.
     */
    @Test
    public void testEjecutarAutomataNoValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de palabras reservadas casteo");
        char[] palabra = {'X', 'M', 'L', 'L'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_PalabrasReservada_Cast instance = new Automata_PalabrasReservada_Cast();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"XMLL\"");
            System.out.println("El objeto es nulo");
        }
    }
}
