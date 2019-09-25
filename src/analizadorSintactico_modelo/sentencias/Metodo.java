/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias;

import analizadorLexico_modelo.Lexema;
import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public class Metodo extends Sentencia{

    
    private Lexema nombreMetodo;
    private ListaParametros<Parametro> listaParametros;
    private ListaSentencias<Sentencia> listaSentencias;

    public Metodo() {
        this.listaParametros = new ListaParametros<>();
        this.listaSentencias = new ListaSentencias<>();
    }

    public Lexema getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(Lexema nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    public ListaParametros<Parametro> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(ListaParametros<Parametro> listaParametros) {
        this.listaParametros = listaParametros;
    }

    public ListaSentencias<Sentencia> getListaSentencias() {
        return listaSentencias;
    }

    public void setListaSentencias(ListaSentencias<Sentencia> listaSentencias) {
        this.listaSentencias = listaSentencias;
    }
    
    
    
    
    
    @Override
    public ArrayList<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        hijos.add(new Terminal(nombreMetodo));
        
        if (!listaParametros.getParametros().isEmpty()) {
            hijos.add(listaParametros);
        }
        
        if (!listaSentencias.getSentencias().isEmpty()) {
            hijos.add(listaSentencias);
        }
        
        return (ArrayList<Sentencia>) hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Metodo: " + nombreMetodo.getLexema();
    }
    
}
