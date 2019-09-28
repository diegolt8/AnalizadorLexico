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
public class ExpresionLogica extends Sentencia {

    private ExpresionRelacional expresionRelacional;
    private ExpresionLogica expresionLogica;
    private Lexema operadorLogico;
    private Lexema operadorLogicoNegacion;
    private Lexema valorLogico;

    public ExpresionLogica() {
    }

    public Lexema getOperadorLogicoNegacion() {
        return operadorLogicoNegacion;
    }

    public void setOperadorLogicoNegacion(Lexema operadorLogicoNegacion) {
        this.operadorLogicoNegacion = operadorLogicoNegacion;
    }

    public ExpresionRelacional getExpresionRelacional() {
        return expresionRelacional;
    }

    public void setExpresionRelacional(ExpresionRelacional expresionRelacional) {
        this.expresionRelacional = expresionRelacional;
    }

    public ExpresionLogica getExpresionLogica() {
        return expresionLogica;
    }

    public void setExpresionLogica(ExpresionLogica expresionLogica) {
        this.expresionLogica = expresionLogica;
    }

    public Lexema getOperadorLogico() {
        return operadorLogico;
    }

    public void setOperadorLogico(Lexema operadorLogico) {
        this.operadorLogico = operadorLogico;
    }

    public Lexema getValorLogico() {
        return valorLogico;
    }

    public void setValorLogico(Lexema valorLogico) {
        this.valorLogico = valorLogico;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (operadorLogicoNegacion != null) {
            hijos.add(new Terminal(operadorLogicoNegacion));
        }
 
        if (valorLogico != null) {
            hijos.add(new Terminal(valorLogico));
        }

        if (expresionRelacional != null) {
            hijos.add(expresionRelacional);
        }

        if (operadorLogico != null) {
            hijos.add(new Terminal(operadorLogico));
        }

        if (expresionLogica != null) {
            hijos.add(expresionLogica);
        }

        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Expresion logica";
    }

}
