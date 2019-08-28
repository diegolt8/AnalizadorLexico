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
public class Automata_EstructurasControl_1Test {
    
    public Automata_EstructurasControl_1Test() {
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
     * Test of ejecutarAutomata method, of class Automata_EstructurasControl_1.
     */
    @Test
    public void testEjecutarAutomataValida() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de estructuras de control");
        char[] palabra = {'P', 'a', 'r', 'a'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_EstructurasControl_1 instance = new Automata_EstructurasControl_1();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("Para") && result.getTipoLexema().equals("Estructura de control")) {
            System.out.println("Valor enviado: \"Para\"");
            System.out.println("Lexema enviado: \"Para\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Estructura de control\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }
    
    /**
     * Test of ejecutarAutomata method, of class Automata_EstructurasControl_1.
     */
    @Test
    public void testEjecutarAutomataNoValida() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de estructuras de control");
        char[] palabra = {'P', 'a', 'r', 'a', 'a'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_EstructurasControl_1 instance = new Automata_EstructurasControl_1();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"Paraa\"");
            System.out.println("El objeto es nulo");
        }
    }
}
