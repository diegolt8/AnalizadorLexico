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
public class Gramatica_LiteralNumericoTest {

    public Gramatica_LiteralNumericoTest() {
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
     * Test of analizar method, of class Gramatica_LiteralNumerico.
     */
    @Test
    public void testAnalizarValido() {
        System.out.println("---analizar prueba valida---");
        ArrayList<Lexema> lexema = new ArrayList<>();
        lexema.add(new Lexema("1", TipoLexemaEnum.VALOR_NUMERICO, 0, 0, 0));
        lexema.add(new Lexema(".", TipoLexemaEnum.PUNTO, 0, 0, 0));
        lexema.add(new Lexema("1", TipoLexemaEnum.VALOR_NUMERICO, 0, 0, 0));
        FlujoLexema flujoLexema = new FlujoLexema(lexema);
        Gramatica_LiteralNumerico instance = new Gramatica_LiteralNumerico();
        Sentencia result = instance.analizar(flujoLexema);
        assertNotNull(result);
        System.out.println("Prueba valida");
    }

    @Test
    public void testAnalizarNoValido() {
        System.out.println("---analizar prueba no valida---");
        ArrayList<Lexema> lexema = new ArrayList<>();
        lexema.add(new Lexema(".", TipoLexemaEnum.PUNTO, 0, 0, 0));
        lexema.add(new Lexema("1", TipoLexemaEnum.VALOR_NUMERICO, 0, 0, 0));
        FlujoLexema flujoLexema = new FlujoLexema(lexema);
        Gramatica_LiteralNumerico instance = new Gramatica_LiteralNumerico();
        Sentencia result = instance.analizar(flujoLexema);
        assertNull(result);
        System.out.println("Prueba no valida");
    }

}
