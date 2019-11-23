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
public class Terminal extends Sentencia{

    private Lexema lexema;

    public Terminal() {
    }

    public Terminal(Lexema lexema) {
        this.lexema = lexema;
    }

    public Lexema getLexema() {
        return lexema;
    }   
    
    @Override
    public ArrayList<Sentencia> llenarHijos() {
        return null;
    }

    @Override
    public String parse() {
        return lexema.getLexema();
    }

    @Override
    public String toString() {
        return "Lexema: " + lexema.getLexema() + " - Tipo: " + lexema.getTipoLexema();
    }
    
}
