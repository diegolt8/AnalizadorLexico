/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.gramaticas;

import analizadorSintactico_modelo.FlujoLexema;
import analizadorSintactico_modelo.Gramatica;
import analizadorSintactico_modelo.Sentencia;
import analizadorSintactico_modelo.gramaticas.newpackage.Gramatica_Expresion;
import analizadorSintactico_modelo.sentencias.InicializadorVariable;

/**
 *
 * @author Pepe
 */
public class Gramatica_InicializadorVariable implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_Expresion gramaticaExpresion = new Gramatica_Expresion();
        
        InicializadorVariable inicializadorVariable = new InicializadorVariable();
        
        Sentencia expresion = gramaticaExpresion.analizar(flujoLexema);
        if (expresion == null) {
            // error sintactico
            return null;
        }
        inicializadorVariable.setExpresion(expresion);
        
        return inicializadorVariable;
    }
    
}
