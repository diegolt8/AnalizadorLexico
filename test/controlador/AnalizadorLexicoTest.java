/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.ErrorLexico;
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
public class AnalizadorLexicoTest {
    
    public AnalizadorLexicoTest() {
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
     * Test of analizadorLexico method, of class AnalizadorLexico.
     */
    @Test
    public void testAnalizadorLexicoValida() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba valida para analizador lexico");
        System.out.println("");
        String caracteres = "Var variable = 10;";
        AnalizadorLexico instance = new AnalizadorLexico();
        instance.analizadorLexico(caracteres);
        ArrayList<Lexema> listaLexemas = instance.getListaLexema();
        ArrayList<ErrorLexico> listaErrorLexico = instance.getListaErroresLexico();
        if(listaLexemas.size() == 5 && listaErrorLexico.isEmpty()){
            System.out.println("Lista de lexemas identificados");
            listaLexemas.forEach((lexema) -> {
                System.out.println("Lexema= "+lexema.getLexema()+" - Tipo lexema: "+lexema.getTipoLexema());
            });
            assertNotNull(listaLexemas);
        }
    }
    
    /**
     * Test of analizadorLexico method, of class AnalizadorLexico.
     */
    @Test
    public void testAnalizadorLexicoNoValida() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba no valida para analizador lexico");
        String caracteres = "Var 7variable = 10;";
        AnalizadorLexico instance = new AnalizadorLexico();
        instance.analizadorLexico(caracteres);
        ArrayList<Lexema> listaLexemas = instance.getListaLexema();
        ArrayList<ErrorLexico> listaErrorLexico = instance.getListaErroresLexico();
        if(listaLexemas.size() == 4 && listaErrorLexico.size() == 1){
            System.out.println("Lista de lexemas identificados");
            listaLexemas.forEach((lexema) -> {
                System.out.println("Lexema= "+lexema.getLexema()+" - Tipo lexema: "+lexema.getTipoLexema());
            });
            System.out.println("");
            System.out.println("Lista de errores lexicos identificados");
            listaErrorLexico.forEach((lexema) -> {
                System.out.println("error lexico= "+lexema.getToken());
            });
            assertNotNull(listaLexemas);
        }
    }
}
