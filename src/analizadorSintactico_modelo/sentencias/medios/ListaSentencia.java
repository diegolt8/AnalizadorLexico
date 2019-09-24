/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias.medios;

import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pepe
 * @param <T>
 */
public class ListaSentencia<T extends Sentencia> extends Sentencia {

    private final List<T> sentencias;

    public ListaSentencia(List<T> sentencias) {
        this.sentencias = sentencias;
    }

    public ListaSentencia() {
        sentencias = new ArrayList<>();
    }
    
        
    public void add(T sentencia) {
        sentencias.add(sentencia);
    }

    public List<T> getSentencias() {
        return sentencias;
    }
        

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        sentencias.forEach((t) -> {
            hijos.add(t);
        });
        return hijos;
    }

    @Override
    public String toString() {
        return null;
    }    

    @Override
    public String parse() {
        return null;
    }
}
