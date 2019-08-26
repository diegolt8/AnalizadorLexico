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

    public FlujoCaracteres() {
    }

    public FlujoCaracteres(char[] caracteres) {
        this.posicionActual = 0;
        this.caracteres = caracteres;
        this.fila = 1;
        this.columna = 1;
    }

    /**
     * *
     * Metodo que retorna el caracter segun la posicion del flujo de caracteres
     *
     * @return char que contiene el caracter del flujo
     */
    public char getCaracter() {
        return caracteres[posicionActual];
    }

    /**
     * *
     * Metodo que retorna el caracter segun la posicion del flujo de caracteres
     *
     * @return char que contiene el caracter del flujo
     */
    public char getCaracterAnterior() {
        return caracteres[posicionActual - 1];
    }

    /**
     * *
     * Metodo que retorna el tamaño del flujo de caracteres
     *
     * @return int con la cantidad de elementos del flujo de caracteres
     */
    public int getCantidadCaracteres() {
        return caracteres.length;
    }

    /**
     * *
     * Metodo que suma 1 a la posicion actual del flujo de caracteres
     */
    public void moverAdelante() {
        posicionActual++;
    }

    /**
     * *
     * Metodo que resta 1 a la posicion actual del flujo de caracteres
     */
    public void moverAtras() {
        posicionActual--;
    }

    /**
     * *
     * Metodo que suma 1 a la fila del flujo de caracteres
     */
    public void siguienteFila() {
        fila++;
    }

    /**
     * *
     * Metodo que suma 1 a la columna actual del flujo de caracteres
     */
    public void siguienteColumna() {
        columna++;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.columna -= (this.posicionActual - posicionActual);
        this.posicionActual = posicionActual;
    }

    public char[] getCaracteres() {
        return caracteres;
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
