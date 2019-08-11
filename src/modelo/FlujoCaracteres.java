/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pepe
 */
public class FlujoCaracteres {
    
    private int posicionActual, fila, columna;
    private char[] caracteres;

    public FlujoCaracteres(){}

    public FlujoCaracteres(int posicionActual, char[] caracteres, int fila, int columna) {
        this.posicionActual = posicionActual;
        this.fila = fila;
        this.columna = columna;
        this.caracteres = caracteres;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public char[] getCaracteres() {
        return caracteres;
    }
    
    public char getCaracter(int pos){
        return caracteres[pos];
    }
    
    public int getCantidadCaracteres(){
        return caracteres.length;
    }

    public void setCaracteres(char[] caracteres) {
        this.caracteres = caracteres;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
        
}
