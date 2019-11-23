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
public class VerboHTTP extends Sentencia {

    private Sentencia verboHTTP;

    public VerboHTTP() {
    }

    public Sentencia getVerboHTTP() {
        return verboHTTP;
    }

    public void setVerboHTTP(Sentencia verboHTTP) {
        this.verboHTTP = verboHTTP;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (verboHTTP != null) {
            hijos.add(verboHTTP);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return verboHTTP.parse();
    }

    @Override
    public String toString() {
        return "Verbo HTTP";
    }
    
}
