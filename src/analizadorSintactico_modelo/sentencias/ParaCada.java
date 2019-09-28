/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias;

import analizadorLexico_modelo.Lexema;
import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pepe
 */
public class ParaCada extends Sentencia {

    private DeclaracionVariable declarancion;
    private Lexema identificador;
    private ListaSentencias<Sentencia> listaSentencias;

    public ParaCada() {
        this.listaSentencias = new ListaSentencias<>();
    }

    public DeclaracionVariable getDeclaracion() {
        return declarancion;
    }

    public void setDeclaracion(DeclaracionVariable declaracionInicio) {
        this.declarancion = declaracionInicio;
    }

    public Lexema getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Lexema identificador) {
        this.identificador = identificador;
    }

    public ListaSentencias<Sentencia> getListaSentencias() {
        return listaSentencias;
    }

    public void setListaSentencias(ListaSentencias<Sentencia> listaSentencias) {
        this.listaSentencias = listaSentencias;
    }
      
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (declarancion != null) {
            hijos.add(declarancion);
        }
        
        if (identificador != null) {
            hijos.add(new Terminal(identificador));
        }
        
        if (!listaSentencias.getSentencias().isEmpty()) {
            hijos.add(listaSentencias);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Estructura de control PARACADA";
    }
    
}
