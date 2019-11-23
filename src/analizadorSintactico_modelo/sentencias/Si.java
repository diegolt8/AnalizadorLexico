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
public class Si extends Sentencia {

    private ExpresionLogica condicion;
    private ListaSentencias<Sentencia> listaSentencias;
    private Sino sino;

    public Si() {
        this.listaSentencias = new ListaSentencias<>();
    }

    public ExpresionLogica getCondicion() {
        return condicion;
    }

    public void setCondicion(ExpresionLogica condicion) {
        this.condicion = condicion;
    }

    public ListaSentencias<Sentencia> getListaSentencias() {
        return listaSentencias;
    }

    public void setListaSentencias(ListaSentencias<Sentencia> listaSentencias) {
        this.listaSentencias = listaSentencias;
    }

    public Sino getSino() {
        return sino;
    }

    public void setSino(Sino sino) {
        this.sino = sino;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        hijos.add(condicion);

        if (!listaSentencias.getSentencias().isEmpty()) {
            hijos.add(listaSentencias);
        }

        if (sino != null) {
            hijos.add(sino);
        }

        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();

        str.append("if").append("(");
        str.append(condicion.parse());
        str.append(") ");
        str.append("{");

        for (Sentencia sentencia : listaSentencias.getSentencias()) {
            str.append("\n").append("").append(sentencia.parse());
        }
        str.append("\n}");
         if (sino != null) {
             str.append(sino.parse());
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "estructura de control SI";
    }

}
