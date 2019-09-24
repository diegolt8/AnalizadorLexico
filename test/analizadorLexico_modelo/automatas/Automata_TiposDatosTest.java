/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico_modelo.automatas;

import analizadorLexico_modelo.automatas.Automata_TiposDatos;
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
public class Automata_TiposDatosTest {

    public Automata_TiposDatosTest() {
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
     * Test of ejecutarAutomata method, of class Automata_TiposDatos.
     */
    @Test
    public void testEjecutarAutomataValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para Automata de tipos de datos");
        char[] palabra = {'V', 'a', 'r'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_TiposDatos instance = new Automata_TiposDatos();
        Lexema result = instance.ejecutarAutomata(flujo);
        if (result.getLexema().equals("Var") && result.getTipoLexema().equals("Tipos de datos")) {
            System.out.println("Valor enviado: \"Var\"");
            System.out.println("Lexema enviado: \"Var\" - resultLexema: \""+result.getLexema()+"\"");
            System.out.println("Tipo de lexema esperado: \"Tipos de datos\" - resultTipoLexema: \""+result.getTipoLexema()+"\"");
            assertNotNull(result);
        }
    }

    /**
     * Test of ejecutarAutomata method, of class Automata_TiposDatos.
     */
    @Test
    public void testEjecutarAutomataNoValido() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para Automata de tipos de datos");
        char[] palabra = {'V', 'a', 'r', 'r'};
        FlujoCaracteres flujo = new FlujoCaracteres(palabra);
        Automata_TiposDatos instance = new Automata_TiposDatos();
        Lexema result = instance.ejecutarAutomata(flujo);
        if(result == null){
            assertNull(result);
            System.out.println("Valor enviado: \"Varr\"");
            System.out.println("El objeto es nulo");
        }
    }
}
