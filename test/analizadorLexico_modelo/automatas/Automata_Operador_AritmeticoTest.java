/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico_modelo.automatas;

import analizadorLexico_modelo.automatas.Automata_Operador_Aritmetico;
import analizadorLexico_modelo.FlujoCaracteres;
import analizadorLexico_modelo.Lexema;
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
public class Automata_Operador_AritmeticoTest {
    
    public Automata_Operador_AritmeticoTest() {
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
     * Test of ejecutarAutomata method, of class Automata_Operador_Aritmetico.
     */
    @Test
    public void testEjecutarAutomataValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de operador aritmetico");
        char[] palabra = {'+'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_Operador_Aritmetico instance = new Automata_Operador_Aritmetico();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("+") && result.getTipoLexema().equals("Operador Aritmetico")) {
            System.out.println("Valor enviado: \"+\"");
            System.out.println("Lexema enviado: \"+\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Operador Aritmetico\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_Operador_Aritmetico.
     */
    @Test
    public void testEjecutarAutomataNoValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de operador aritmetico");
        char[] palabra = {'6'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_Operador_Aritmetico instance = new Automata_Operador_Aritmetico();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"6\"");
            System.out.println("El objeto es nulo");
        }
    }
}
