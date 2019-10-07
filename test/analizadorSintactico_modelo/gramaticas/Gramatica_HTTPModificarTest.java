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
public class Gramatica_HTTPModificarTest {

    public Gramatica_HTTPModificarTest() {
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
     * Test of analizar method, of class Gramatica_HTTPModificar.
     */
    @Test
    public void testAnalizarValido() {
        System.out.println("analizar");
        ArrayList<Lexema> lexema = new ArrayList<>();
        lexema.add(new Lexema("Modificar", TipoLexemaEnum.VERBO_HTTP_PUT, 0, 0, 0));
        lexema.add(new Lexema("(", TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema("URL", TipoLexemaEnum.IDENTIFICADOR, 0, 0, 0));
        lexema.add(new Lexema(")", TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        lexema.add(new Lexema(".", TipoLexemaEnum.PUNTO, 0, 0, 0));
        lexema.add(new Lexema("Parametros", TipoLexemaEnum.REQUEST_PARAMETROS, 0, 0, 0));
        lexema.add(new Lexema("(", TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema(")", TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        lexema.add(new Lexema(".", TipoLexemaEnum.PUNTO, 0, 0, 0));
        lexema.add(new Lexema("Query", TipoLexemaEnum.COMENTARIO, 0, 0, 0));
        lexema.add(new Lexema("(", TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema("{", TipoLexemaEnum.LLAVE_ABIERTA, 0, 0, 0));
        lexema.add(new Lexema("}", TipoLexemaEnum.LLAVE_CERRADA, 0, 0, 0));
        lexema.add(new Lexema(")", TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        lexema.add(new Lexema(".", TipoLexemaEnum.PUNTO, 0, 0, 0));
        lexema.add(new Lexema("Cuerpo", TipoLexemaEnum.CUERPO, 0, 0, 0));
        lexema.add(new Lexema("(", TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema("{", TipoLexemaEnum.LLAVE_ABIERTA, 0, 0, 0));
        lexema.add(new Lexema("}", TipoLexemaEnum.LLAVE_CERRADA, 0, 0, 0));
        lexema.add(new Lexema(")", TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        lexema.add(new Lexema(";", TipoLexemaEnum.PUNTO_Y_COMA, 0, 0, 0));
        FlujoLexema flujoLexema = new FlujoLexema(lexema);
        Gramatica_HTTPModificar instance = new Gramatica_HTTPModificar();
        Sentencia result = instance.analizar(flujoLexema);
        assertNotNull(result);
    }
    
    @Test
    public void testAnalizarNoValido() {
        System.out.println("analizar");
        ArrayList<Lexema> lexema = new ArrayList<>();
        lexema.add(new Lexema("(", TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema("URL", TipoLexemaEnum.IDENTIFICADOR, 0, 0, 0));
        lexema.add(new Lexema(")", TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        lexema.add(new Lexema(".", TipoLexemaEnum.PUNTO, 0, 0, 0));
        lexema.add(new Lexema("Parametros", TipoLexemaEnum.REQUEST_PARAMETROS, 0, 0, 0));
        lexema.add(new Lexema("(", TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema(")", TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        lexema.add(new Lexema(".", TipoLexemaEnum.PUNTO, 0, 0, 0));
        lexema.add(new Lexema("Query", TipoLexemaEnum.COMENTARIO, 0, 0, 0));
        lexema.add(new Lexema("(", TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema("{", TipoLexemaEnum.LLAVE_ABIERTA, 0, 0, 0));
        lexema.add(new Lexema("}", TipoLexemaEnum.LLAVE_CERRADA, 0, 0, 0));
        lexema.add(new Lexema(")", TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        lexema.add(new Lexema(".", TipoLexemaEnum.PUNTO, 0, 0, 0));
        lexema.add(new Lexema("Cuerpo", TipoLexemaEnum.CUERPO, 0, 0, 0));
        lexema.add(new Lexema("(", TipoLexemaEnum.PARENTESIS_ABIERTO, 0, 0, 0));
        lexema.add(new Lexema("{", TipoLexemaEnum.LLAVE_ABIERTA, 0, 0, 0));
        lexema.add(new Lexema("}", TipoLexemaEnum.LLAVE_CERRADA, 0, 0, 0));
        lexema.add(new Lexema(")", TipoLexemaEnum.PARENTESIS_CERRADO, 0, 0, 0));
        lexema.add(new Lexema(";", TipoLexemaEnum.PUNTO_Y_COMA, 0, 0, 0));
        FlujoLexema flujoLexema = new FlujoLexema(lexema);
        Gramatica_HTTPModificar instance = new Gramatica_HTTPModificar();
        Sentencia result = instance.analizar(flujoLexema);
        assertNull(result);
    }

}
