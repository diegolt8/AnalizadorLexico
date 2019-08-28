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
public class Automata_Operador_AsignacionTest {
    
    public Automata_Operador_AsignacionTest() {
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
     * Test of ejecutarAutomata method, of class Automata_Operador_Asignacion.
     */
    @Test
    public void testEjecutarAutomataValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de operador de asignacion");
        char[] palabra = {'+', '='};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_Operador_Asignacion instance = new Automata_Operador_Asignacion();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("+=") && result.getTipoLexema().equals("Operador Asignacion")) {
            System.out.println("Valor enviado: \"+=\"");
            System.out.println("Lexema enviado: \"+=\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Operador Asignacion\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_Operador_Asignacion.
     */
    @Test
    public void testEjecutarAutomataNoValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de operador de asignacion");
        char[] palabra = {'+', '+'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_Operador_Asignacion instance = new Automata_Operador_Asignacion();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"++\"");
            System.out.println("El objeto es nulo");
        }
    }
}
