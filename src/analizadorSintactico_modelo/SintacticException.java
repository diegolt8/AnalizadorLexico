/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo;

import analizadorLexico_modelo.Lexema;
import analizadorLexico_modelo.TipoLexemaEnum;

/**
 *
 * @author diegoalt
 */
public class SintacticException extends RuntimeException{

    /**
     * Token actual del analisis.
     */
    private Lexema antes;
    /**
     * Lo que se esperaba
     */
    private TipoLexemaEnum esperado;

    public SintacticException(Lexema antes, TipoLexemaEnum esperado) {
        super("Error en " + antes.getLinea() + "-" + antes.getColumna()
                + ": Simbolo no esperado: " + antes.getTipoLexema().name() + ". se esperaba " + esperado
        );
        this.antes = antes;
        this.esperado = esperado;
    }

    public SintacticException(String Mensaje) {
        super(Mensaje);
    }
   
    public Lexema getAntes() {
        return antes;
    }

    public void setAntes(Lexema antes) {
        this.antes = antes;
    }

    public TipoLexemaEnum getEsperado() {
        return esperado;
    }

    public void setEsperado(TipoLexemaEnum esperado) {
        this.esperado = esperado;
    }

}
