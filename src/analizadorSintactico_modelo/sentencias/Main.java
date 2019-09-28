/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias;

import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public class Main extends Sentencia{

    ListaSentencias<Sentencia> listaSentencia;
    
    @Override
    public ArrayList<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        return (ArrayList<Sentencia>) hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Metodo: Main";
    }

    public Main() {
        this.listaSentencia = new ListaSentencias<>();
    }

    public ListaSentencias<Sentencia> getListaSentencia() {
        return listaSentencia;
    }

    public void setListaSentencia(ListaSentencias<Sentencia> listaSentencia) {
        this.listaSentencia = listaSentencia;
    }
    
    
    
}
