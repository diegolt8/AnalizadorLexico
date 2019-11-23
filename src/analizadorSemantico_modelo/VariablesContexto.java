/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo;

import analizadorLexico_modelo.Lexema;
import analizadorLexico_modelo.TipoLexemaEnum;

/**
 *
 * @author Pepe
 */
public class VariablesContexto {
    
    private String nombre;
    private TipoLexemaEnum tipoDato; 
    private Lexema valor;
    private int contexto;

    public VariablesContexto(String nombre, TipoLexemaEnum tipoDato, Lexema valor, int contexto) {
        this.nombre = nombre;
        this.tipoDato = tipoDato;
        this.valor = valor;
        this.contexto = contexto;
    }

    public VariablesContexto(String nombre, TipoLexemaEnum tipoDato, int contexto) {
        this.nombre = nombre;
        this.tipoDato = tipoDato;
        this.contexto = contexto;
        this.valor = new Lexema();
    }

    public VariablesContexto(String nombre, TipoLexemaEnum tipoDato) {
        this.nombre = nombre;
        this.tipoDato = tipoDato;
    }   
    
    public VariablesContexto() {
    }

    public int getContexto() {
        return contexto;
    }

    public void setContexto(int contexto) {
        this.contexto = contexto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoLexemaEnum getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(TipoLexemaEnum tipoDato) {
        this.tipoDato = tipoDato;
    }

    public Lexema getValor() {
        return valor;
    }

    public void setValor(Lexema valor) {
        this.valor = valor;
    }   
    
}
