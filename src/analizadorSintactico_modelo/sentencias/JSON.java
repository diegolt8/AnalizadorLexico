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
public class JSON extends Sentencia {

    private TerminoJSON terminoJSON;

    public JSON() {
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
        return "JSON";
    }
    
}
