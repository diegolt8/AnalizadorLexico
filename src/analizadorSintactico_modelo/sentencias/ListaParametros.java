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
public class ListaParametros<T extends Sentencia> extends Sentencia{

    private final List<T> listaParametros;

    public ListaParametros(List<T> listaParametros) {
        this.listaParametros = listaParametros;
    }
    
    public ListaParametros() {
        this.listaParametros = new ArrayList<>();
    }
    
    
    public void add(T sentencia) {
        listaParametros.add(sentencia);
    }

    public List<T> getParametros() {
        return listaParametros;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        listaParametros.forEach((t) -> {
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
        return "Lista de parametros";
    }
    
}
