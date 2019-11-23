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

    private TerminoLogico terminoLogico;
    private Lexema operador;
    private ExpresionLogica expresionLogica;

    public ExpresionLogica() {
    }

    public TerminoLogico getTerminoLogico() {
        return terminoLogico;
    }

    public void setTerminoLogico(TerminoLogico terminoLogico) {
        this.terminoLogico = terminoLogico;
    }

    public Lexema getOperador() {
        return operador;
    }

    public void setOperador(Lexema operador) {
        this.operador = operador;
    }

    public ExpresionLogica getExpresionLogica() {
        return expresionLogica;
    }

    public void setExpresionLogica(ExpresionLogica expresionLogica) {
        this.expresionLogica = expresionLogica;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        if (terminoLogico != null) {
            hijos.add(terminoLogico);
        }
        
        if (operador != null) {
            hijos.add(new Terminal(operador));
        }
        
        if (expresionLogica != null) {
            hijos.add(expresionLogica);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        
        str.append(terminoLogico.parse());
        if (operador != null) {
            str.append(" ");
            str.append(operador.getLexema()).append(" ");
            str.append(expresionLogica.parse());
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "Expresion logica";
    }

}
