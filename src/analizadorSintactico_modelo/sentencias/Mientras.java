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
public class Mientras extends Sentencia {

    private ListaSentencias<Sentencia> listaSentencias;
    private ExpresionLogica expresionLogica;

    public Mientras() {
        this.listaSentencias = new ListaSentencias<>();
    }

    public ListaSentencias<Sentencia> getListaSentencias() {
        return listaSentencias;
    }

    public void setListaSentencias(ListaSentencias<Sentencia> listaSentencias) {
        this.listaSentencias = listaSentencias;
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
        
        if (expresionLogica != null) {
            hijos.add(expresionLogica);
        }
        
        if (!listaSentencias.getSentencias().isEmpty()) {
            hijos.add(listaSentencias);
        }       
        
        return hijos;
    }
    
    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Estructura de control MIENTRAS";
    }
    
}
