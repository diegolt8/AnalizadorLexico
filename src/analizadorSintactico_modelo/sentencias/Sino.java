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
public class Sino extends Sentencia {

    private ListaSentencias<Sentencia> listaSentencias;

    public Sino() {
        this.listaSentencias = new ListaSentencias<>();
    }

    public ListaSentencias<Sentencia> getListaSentencias() {
        return listaSentencias;
    }

    public void setListaSentencias(ListaSentencias<Sentencia> listaSentencias) {
        this.listaSentencias = listaSentencias;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
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
        return "Estructura de control SINO";
    }
    
}
