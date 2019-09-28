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
public class TerminoRelacional extends Sentencia {

    private ExpresionNumerica expresionNumerica;
    private Lexema literalCadena;

    public TerminoRelacional() {
    }

    public ExpresionNumerica getExpresionNumerica() {
        return expresionNumerica;
    }

    public void setExpresionNumerica(ExpresionNumerica expresionNumerica) {
        this.expresionNumerica = expresionNumerica;
    }

    public Lexema getLiteralCadena() {
        return literalCadena;
    }

    public void setLiteralCadena(Lexema literalCadena) {
        this.literalCadena = literalCadena;
    }    
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (expresionNumerica != null) {
            hijos.add(expresionNumerica);
        }
        
        if (literalCadena != null) {
            hijos.add(new Terminal(literalCadena));
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Termino Relacional";
    }
    
}
