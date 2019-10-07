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
public class HTTPParametros extends Sentencia {

    private TerminoLiteral terminoLiteral;
    private JSON json;

    public HTTPParametros() {
    }

    public TerminoLiteral getTerminoLiteral() {
        return terminoLiteral;
    }

    public void setTerminoLiteral(TerminoLiteral terminoLiteral) {
        this.terminoLiteral = terminoLiteral;
    }

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }
       
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (terminoLiteral != null) {
            hijos.add(terminoLiteral);
        }
        
        if (json != null) {
            hijos.add(json);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Parametros";
    }
    
}
