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

    private TerminoNumerico terminoNumerico;
    private ExpresionNumerica expresionNumerica;
    private Lexema operador;
    private Lexema parentesisAbierto;
    private Lexema parentesisCerrado;

    public ExpresionNumerica() {
    }

    public Lexema getParentesisAbierto() {
        return parentesisAbierto;
    }

    public void setParentesisAbierto(Lexema parentesisAbierto) {
        this.parentesisAbierto = parentesisAbierto;
    }

    public Lexema getParentesisCerrado() {
        return parentesisCerrado;
    }

    public void setParentesisCerrado(Lexema parentesisCerrado) {
        this.parentesisCerrado = parentesisCerrado;
    }
    
    public TerminoNumerico getTerminoNumerico() {
        return terminoNumerico;
    }

    public void setTerminoNumerico(TerminoNumerico terminoNumerico) {
        this.terminoNumerico = terminoNumerico;
    }

    public ExpresionNumerica getExpresionNumerica() {
        return expresionNumerica;
    }

    public void setExpresionNumerica(ExpresionNumerica expresionNumerica) {
        this.expresionNumerica = expresionNumerica;
    }

    public Lexema getOperador() {
        return operador;
    }

    public void setOperador(Lexema operador) {
        this.operador = operador;
    }   
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (parentesisAbierto != null) {
            hijos.add(new Terminal(parentesisAbierto));
        }
        
        if (terminoNumerico != null) {
            hijos.add(terminoNumerico);
        }
        
        if (operador != null) {
            hijos.add(new Terminal(operador));
        }
        
        if (expresionNumerica != null) {
            hijos.add(expresionNumerica);
        }     
        
        if (parentesisCerrado != null) {
            hijos.add(new Terminal(parentesisCerrado));
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
