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
public class Parametro extends Sentencia{

    private Lexema tipoDato;
    private Lexema nombreParametro;

    public Parametro() {
    }

    public Lexema getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Lexema tipoDato) {
        this.tipoDato = tipoDato;
    }

    public Lexema getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(Lexema nombreParametro) {
        this.nombreParametro = nombreParametro;
    }   
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        hijos.add(new Terminal(tipoDato));
        hijos.add(new Terminal(nombreParametro));
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Parametro: " + nombreParametro.getLexema() + " - Tipo: " + tipoDato.getLexema();
    }
    
}
