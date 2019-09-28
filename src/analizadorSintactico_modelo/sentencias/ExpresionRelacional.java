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
public class ExpresionRelacional extends Sentencia {

    private TerminoRelacional terminoRelacional;
    private Lexema operadorRelacional;
    private ExpresionRelacional expresionRelacional;

    public ExpresionRelacional() {
    }

    public TerminoRelacional getTerminoRelacional() {
        return terminoRelacional;
    }

    public void setTerminoRelacional(TerminoRelacional terminoRelacional) {
        this.terminoRelacional = terminoRelacional;
    }

    public Lexema getOperadorRelacional() {
        return operadorRelacional;
    }

    public void setOperadorRelacional(Lexema operadorRelacional) {
        this.operadorRelacional = operadorRelacional;
    }

    public ExpresionRelacional getExpresionRelacional() {
        return expresionRelacional;
    }

    public void setExpresionRelacional(ExpresionRelacional expresionRelacional) {
        this.expresionRelacional = expresionRelacional;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        hijos.add(terminoRelacional);

        if (operadorRelacional != null) {
            hijos.add(new Terminal(operadorRelacional));
        }
        
        if (expresionRelacional != null) {
            hijos.add(expresionRelacional);
        }
       
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "expresion relacional";
    }

}
