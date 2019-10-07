/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias;

import analizadorLexico_modelo.Lexema;
import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pepe
 */
public class ExpresionNumerica extends Sentencia {

    private TerminoNumerico termino;
    private Lexema operador;
    private ExpresionNumerica expresion;

    public ExpresionNumerica() {
    }

    public TerminoNumerico getTermino() {
        return termino;
    }

    public void setTermino(TerminoNumerico termino) {
        this.termino = termino;
    }

    public Lexema getOperador() {
        return operador;
    }

    public void setOperador(Lexema operador) {
        this.operador = operador;
    }

    public ExpresionNumerica getExpresion() {
        return expresion;
    }

    public void setExpresion(ExpresionNumerica expresion) {
        this.expresion = expresion;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (termino != null) {
            hijos.add(termino);
        }
        
        if (operador != null) {
            hijos.add(new Terminal(operador));
        }
        
        if (expresion != null) {
            hijos.add(expresion);
        }
       
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Expresion numerica";
    }
    
    
    
    
}
