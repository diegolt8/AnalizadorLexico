/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias;

import analizadorSintactico_modelo.sentencias.medios.ListaSentencia;
import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pepe
 */
public class Archivo extends Sentencia {

    private Main main;
    private ListaSentencia<Metodo> listaMetodos;

    /*
     * Constructor
     */
    public Archivo() {
        this.listaMetodos = new ListaSentencia<>();
    }

    // Gets y sets
    // ------------------------------------------------------------------------
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public ListaSentencia<Metodo> getListaMetodos() {
        return listaMetodos;
    }

    public void setListaMetodos(ListaSentencia<Metodo> listaMetodos) {
        this.listaMetodos = listaMetodos;
    }
    //-------------------------------------------------------------------------
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        if (main != null) {
            hijos.add(main);
        }

        if (!listaMetodos.getSentencias().isEmpty()) {
            hijos.add(listaMetodos);
        }

        return hijos;
    }

    @Override
    public String parse() {
        return null;
    }

    @Override
    public String toString() {
        return "";
    }

}
