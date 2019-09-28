/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias;

import analizadorLexico_modelo.Lexema;
import analizadorSintactico_modelo.Sentencia;
import analizadorSintactico_modelo.sentencias.newpackage.Terminal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pepe
 */
public class DeclaracionVariable extends Sentencia {

    private Lexema tipoDato;
    private ListaDeclarante<DeclaranteVariable> listaDeclarantes;

    public DeclaracionVariable() {
        this.listaDeclarantes = new ListaDeclarante<>();
    }

    public Lexema getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Lexema tipoDato) {
        this.tipoDato = tipoDato;
    }

    public ListaDeclarante<DeclaranteVariable> getListaDeclarantes() {
        return listaDeclarantes;
    }

    public void setListaDeclarantes(ListaDeclarante<DeclaranteVariable> listaDeclarantes) {
        this.listaDeclarantes = listaDeclarantes;
    }    
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        hijos.add(new Terminal(tipoDato));
        
        hijos.add(listaDeclarantes);
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Declaracion";
    }
    
}
