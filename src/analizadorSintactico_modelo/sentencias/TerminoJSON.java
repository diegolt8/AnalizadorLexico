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
public class TerminoJSON extends Sentencia {

    private Lexema literalCadena;
    private TerminoLiteral terminoLiteral;
    private TerminoJSON terminoJSON;

    public TerminoJSON() {
    }

    public Lexema getLiteralCadena() {
        return literalCadena;
    }

    public void setLiteralCadena(Lexema literalCadena) {
        this.literalCadena = literalCadena;
    }

    public TerminoLiteral getTerminoLiteral() {
        return terminoLiteral;
    }

    public void setTerminoLiteral(TerminoLiteral terminoLiteral) {
        this.terminoLiteral = terminoLiteral;
    }

    public TerminoJSON getTerminoJSON() {
        return terminoJSON;
    }

    public void setTerminoJSON(TerminoJSON terminoJSON) {
        this.terminoJSON = terminoJSON;
    }
        
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (literalCadena != null) {
            hijos.add(new Terminal(literalCadena));
        }
        
        if (terminoLiteral != null) {
            hijos.add(terminoLiteral);
        }
        
        if (terminoJSON != null) {
            hijos.add(terminoJSON);
        }
        
        
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Termino JSON";
    }
    
}
