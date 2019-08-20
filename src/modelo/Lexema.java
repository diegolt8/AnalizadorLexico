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
    private String lexema, tipoLexema;
    private int linea, columna, token;
        
    public Lexema(){}

    public Lexema(String lexema, String tipoLexema, int linea, int columna, int token) {
        this.lexema = lexema;
        this.tipoLexema = tipoLexema;
        this.linea = linea;
        this.columna = columna;
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
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
