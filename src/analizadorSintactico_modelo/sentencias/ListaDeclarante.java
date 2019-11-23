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
public class ListaDeclarante<T extends Sentencia> extends Sentencia {

    private final List<T> listaDeclarante;

    public ListaDeclarante(List<T> listaDeclarante) {
        this.listaDeclarante = listaDeclarante;
    }

    public ListaDeclarante() {
        this.listaDeclarante = new ArrayList<>();
    }

    public void add(T sentencia) {
        listaDeclarante.add(sentencia);
    }

    public List<T> getDeclarantes() {
        return listaDeclarante;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        listaDeclarante.forEach((t) -> {
            hijos.add(t);
        });
        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        for (T declarante : listaDeclarante) {
            str.append(declarante.parse());
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "Lista declarantes";
    }

}
