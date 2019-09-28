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
public class ListaMetodos<T extends Sentencia> extends Sentencia{

    private final List<T> listaMetodos;

    public ListaMetodos(List<T> listaMetodos) {
        this.listaMetodos = listaMetodos;
    }
    
    public ListaMetodos() {
        this.listaMetodos = new ArrayList<>();
    }
    
    public void add(T sentencia) {
        listaMetodos.add(sentencia);
    }

    public List<T> getMetodos() {
        return listaMetodos;
    }
        
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        listaMetodos.forEach((t) -> {
            hijos.add(t);
        });
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {        
        return "Lista Metodos";
    }
    
}
