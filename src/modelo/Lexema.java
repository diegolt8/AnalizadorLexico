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
public class Lexema {
    private String token, tipoLexema;
    private int linea, columna;
        
    public Lexema(){}

    public Lexema(String token, String tipoLexema, int linea, int columna) {
        this.token = token;
        this.tipoLexema = tipoLexema;
        this.linea = linea;
        this.columna = columna;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipoLexema() {
        return tipoLexema;
    }

    public void setTipoLexema(String tipoLexema) {
        this.tipoLexema = tipoLexema;
    }
    
    
}
