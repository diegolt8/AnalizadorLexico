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
public class Main extends Sentencia {

    ListaSentencias<Sentencia> listaSentencia;

    public Main() {
        this.listaSentencia = new ListaSentencias<>();
    }

    public ListaSentencias<Sentencia> getListaSentencia() {
        return listaSentencia;
    }

    public void setListaSentencia(ListaSentencias<Sentencia> listaSentencia) {
        this.listaSentencia = listaSentencia;
    }

    @Override
    public ArrayList<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        if (!listaSentencia.getSentencias().isEmpty()) {
            hijos.add(listaSentencia);
        }

        return (ArrayList<Sentencia>) hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        /*str.append("main");
        str.append("(").append(")");
        str.append("\t{\n");*/
        for (Sentencia sentencia : listaSentencia.getSentencias()) {
            str.append(sentencia.parse());
        }
        
        /*str.append("\n\n}\n\n");*/
        return str.toString();
    }

    @Override
    public String toString() {
        return "Metodo: Main";
    }
}
