/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.gramaticas;

import analizadorLexico_modelo.Lexema;
import analizadorLexico_modelo.TipoLexemaEnum;
import analizadorSintactico_modelo.FlujoLexema;
import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vi74ly
 */
public class Gramatica_DeclaranteVariableTest {

    public Gramatica_DeclaranteVariableTest() {
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
     * Test of analizar method, of class Gramatica_DeclaranteVariable.
     */
    @Test
    public void testAnalizarValida() {
        System.out.println("---analizar prueba valida---");
        ArrayList<Lexema> lexema = new ArrayList<>();
        lexema.add(new Lexema("a", TipoLexemaEnum.IDENTIFICADOR, 0, 0, 0));
        lexema.add(new Lexema(";", TipoLexemaEnum.PUNTO_Y_COMA, 0, 0, 0));
        FlujoLexema flujoLexema = new FlujoLexema(lexema);
        Gramatica_DeclaranteVariable instance = new Gramatica_DeclaranteVariable();
        Sentencia result = instance.analizar(flujoLexema);
        assertNotNull(result);
    }

    @Test
    public void testAnalizarNoValida() {
        System.out.println("---analizar prueba no valida---");
        ArrayList<Lexema> lexema = new ArrayList<>();
        lexema.add(new Lexema(";", TipoLexemaEnum.PUNTO_Y_COMA, 0, 0, 0));
        FlujoLexema flujoLexema = new FlujoLexema(lexema);
        Gramatica_DeclaranteVariable instance = new Gramatica_DeclaranteVariable();
        Sentencia result = instance.analizar(flujoLexema);
        assertNull(result);
    }

}
