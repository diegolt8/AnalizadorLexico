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
public class ImprimirConsola extends Sentencia {

    private Sentencia expresion;

    public ImprimirConsola() {
    }

    public Sentencia getExpresion() {
        return expresion;
    }

    public void setExpresion(Sentencia expresion) {
        this.expresion = expresion;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (expresion != null) {
            hijos.add(expresion);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Imprimir en consola";
    }
    
}
