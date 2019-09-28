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
 * @param <T>
 */
public class ListaSentencias<T extends Sentencia> extends Sentencia {

    private final List<T> listaSentencias;

    public ListaSentencias(List<T> sentencias) {
        this.listaSentencias = sentencias;
    }

    public ListaSentencias() {
        listaSentencias = new ArrayList<>();
    }
    
        
    public void add(T sentencia) {
        listaSentencias.add(sentencia);
    }

    public List<T> getSentencias() {
        return listaSentencias;
    }
        

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        listaSentencias.forEach((t) -> {
            hijos.add(t);
        });
        return hijos;
    }

    @Override
    public String toString() {
        return "Lista de sentencias";
    }    

    @Override
    public String parse() {
        return "";
    }
}
