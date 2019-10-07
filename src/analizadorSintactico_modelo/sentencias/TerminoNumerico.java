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
public class TerminoNumerico extends Sentencia {

    private FactorNumerico factor;
    private Lexema operador;
    private TerminoNumerico termino;

    public TerminoNumerico() {
    }

    public FactorNumerico getFactor() {
        return factor;
    }

    public void setFactor(FactorNumerico factor) {
        this.factor = factor;
    }

    public Lexema getOperador() {
        return operador;
    }

    public void setOperador(Lexema operador) {
        this.operador = operador;
    }

    public TerminoNumerico getTermino() {
        return termino;
    }

    public void setTermino(TerminoNumerico termino) {
        this.termino = termino;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (factor != null) {
            hijos.add(factor);
        }
        
        if (operador != null) {
            hijos.add(new Terminal(operador));
        }
        
        if (termino != null) {
            hijos.add(termino);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Termino numerico";
    }
    
}
