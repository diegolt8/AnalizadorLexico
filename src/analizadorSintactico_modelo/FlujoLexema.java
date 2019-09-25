/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo;

import analizadorLexico_modelo.Lexema;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public class FlujoLexema {
    
    private final ArrayList<Lexema> listaLexemas;
    private int posActual;
    private int posTemp;

    
    public FlujoLexema(ArrayList<Lexema> listaLexemas) {
        this.listaLexemas = listaLexemas;
        this.posActual = 0;
        this.posTemp = 0;
    }

    public void avanzar() {
        posActual++;
    }
    
    public Lexema getLexema() {
        if (posActual >= listaLexemas.size()) {
            return null;
        }
        return listaLexemas.get(posActual);
    }
    
    public void guardarPosicion() {
        posTemp = posActual;
    }
    
    public void backTrack() {        
        posActual = posTemp;
    } 
    
    public boolean posicionFinal(){
        return posActual == listaLexemas.size();
    }
}
