/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.gramaticas;

import analizadorLexico_modelo.Lexema;
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
public class Gramatica_ParaCadaTest {

    public Gramatica_ParaCadaTest() {
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
     * Test of analizar method, of class Gramatica_ParaCada.
     */
    @Test
    public void testAnalizarValida() {
        System.out.println("analizar");
        ArrayList<Lexema> lexema = new ArrayList<>();
        lexema.add(new Lexema("ParaCada", analizadorLexico_modelo.TipoLexemaEnum.EST_PARA_CADA, 0, 0, 0));
        lexema.add(new Lexema("(", analizadorLexico_modelo.TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema("Dec", analizadorLexico_modelo.TipoLexemaEnum.TIPO_DATO_DEC, 0, 0, 0));
        lexema.add(new Lexema("a", analizadorLexico_modelo.TipoLexemaEnum.IDENTIFICADOR, 0, 0, 0));
        lexema.add(new Lexema(":", analizadorLexico_modelo.TipoLexemaEnum.DOS_PUNTOS, 0, 0, 0));
        lexema.add(new Lexema("b", analizadorLexico_modelo.TipoLexemaEnum.IDENTIFICADOR, 0, 0, 0));
        lexema.add(new Lexema(")", analizadorLexico_modelo.TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        lexema.add(new Lexema("\"", analizadorLexico_modelo.TipoLexemaEnum.COMILLA_DOBLE, 0, 0, 0));
        lexema.add(new Lexema("\"", analizadorLexico_modelo.TipoLexemaEnum.COMILLA_DOBLE, 0, 0, 0));
        lexema.add(new Lexema("\"", analizadorLexico_modelo.TipoLexemaEnum.COMILLA_DOBLE, 0, 0, 0));
        FlujoLexema flujoLexema = new FlujoLexema(lexema);
        Gramatica_ParaCada instance = new Gramatica_ParaCada();
        Sentencia result = instance.analizar(flujoLexema);
        assertNotNull(result);
    }
    
    @Test
    public void testAnalizarNoValida() {
        System.out.println("analizar");
        ArrayList<Lexema> lexema = new ArrayList<>();
        lexema.add(new Lexema("(", analizadorLexico_modelo.TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema("Dec", analizadorLexico_modelo.TipoLexemaEnum.TIPO_DATO_DEC, 0, 0, 0));
        lexema.add(new Lexema("a", analizadorLexico_modelo.TipoLexemaEnum.IDENTIFICADOR, 0, 0, 0));
        lexema.add(new Lexema(":", analizadorLexico_modelo.TipoLexemaEnum.DOS_PUNTOS, 0, 0, 0));
        lexema.add(new Lexema("b", analizadorLexico_modelo.TipoLexemaEnum.IDENTIFICADOR, 0, 0, 0));
        lexema.add(new Lexema(")", analizadorLexico_modelo.TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        lexema.add(new Lexema("\"", analizadorLexico_modelo.TipoLexemaEnum.COMILLA_DOBLE, 0, 0, 0));
        lexema.add(new Lexema("\"", analizadorLexico_modelo.TipoLexemaEnum.COMILLA_DOBLE, 0, 0, 0));
        lexema.add(new Lexema("\"", analizadorLexico_modelo.TipoLexemaEnum.COMILLA_DOBLE, 0, 0, 0));
        FlujoLexema flujoLexema = new FlujoLexema(lexema);
        Gramatica_ParaCada instance = new Gramatica_ParaCada();
        Sentencia result = instance.analizar(flujoLexema);
        assertNull(result);
    }

}
