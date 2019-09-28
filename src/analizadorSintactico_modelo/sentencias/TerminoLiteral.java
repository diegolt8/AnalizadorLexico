/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias;

import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pepe
 */
public class TerminoLiteral extends Sentencia{

    private Sentencia terminoLiteral;

    public TerminoLiteral() {
    }

    public Sentencia getTerminoLiteral() {
        return terminoLiteral;
    }

    public void setTerminoLiteral(Sentencia terminoLiteral) {
        this.terminoLiteral = terminoLiteral;
    }    
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        hijos.add(terminoLiteral);
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Termino literal";
    }
    
}
