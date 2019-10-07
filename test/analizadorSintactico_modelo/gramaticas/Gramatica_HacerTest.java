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
public class Gramatica_HacerTest {

    public Gramatica_HacerTest() {
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
     * Test of analizar method, of class Gramatica_Hacer.
     */
    @Test
    public void testAnalizarValido() {
        System.out.println("analizar");
        ArrayList<Lexema> lexema = new ArrayList<>();
        lexema.add(new Lexema("Hacer", TipoLexemaEnum.EST_HACER, 0, 0, 0));
        lexema.add(new Lexema("\"", TipoLexemaEnum.COMILLA_DOBLE, 0, 0, 0));
        lexema.add(new Lexema("\"", TipoLexemaEnum.COMILLA_DOBLE, 0, 0, 0));
        lexema.add(new Lexema("Mientras", TipoLexemaEnum.EST_MIENTRAS, 0, 0, 0));
        lexema.add(new Lexema("(", TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema("Verdadero", TipoLexemaEnum.VLR_VERDADERO, 0, 0, 0));
        lexema.add(new Lexema(")", TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        FlujoLexema flujoLexema = new FlujoLexema(lexema);
        Gramatica_Hacer instance = new Gramatica_Hacer();
        Sentencia result = instance.analizar(flujoLexema);
        if (result.getHijos().isEmpty()) {
            assertNotNull(result);
        }
    }

    @Test
    public void testAnalizarNoValido() {
        System.out.println("analizar");
        ArrayList<Lexema> lexema = new ArrayList<>();
        lexema.add(new Lexema("Hacer", TipoLexemaEnum.EST_HACER, 0, 0, 0));
        lexema.add(new Lexema("\"", TipoLexemaEnum.COMILLA_DOBLE, 0, 0, 0));
        lexema.add(new Lexema("\"", TipoLexemaEnum.COMILLA_DOBLE, 0, 0, 0));
        lexema.add(new Lexema("Mientras", TipoLexemaEnum.EST_MIENTRAS, 0, 0, 0));
        lexema.add(new Lexema("(", TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema("Verdadero", TipoLexemaEnum.VLR_VERDADERO, 0, 0, 0));
        lexema.add(new Lexema(")", TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        FlujoLexema flujoLexema = new FlujoLexema(lexema);
        Gramatica_Hacer instance = new Gramatica_Hacer();
        Sentencia result = instance.analizar(flujoLexema);
        if (result.getHijos().isEmpty()) {
            assertNull(result);
        }
    }

}
