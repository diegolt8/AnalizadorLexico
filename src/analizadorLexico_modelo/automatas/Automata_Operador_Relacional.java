/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico_modelo.automatas;

import analizadorLexico_modelo.Automata;
import analizadorLexico_modelo.FlujoCaracteres;
import analizadorLexico_modelo.Lexema;
import analizadorLexico_modelo.TipoLexemaEnum;

/**
 *
 * @author Pepe
 */
public class Automata_Operador_Relacional implements Automata {

    /**
     * *
     * Metodo que contiene el comportamiento completo del automata, el cual se
     * encarga de determinar cuales son los lexemas de operadores relacionales
     *
     * @param flujo
     * @return lexema
     */
    @Override
    public Lexema ejecutarAutomata(FlujoCaracteres flujo) {
        int posicionInicial = flujo.getPosicionActual();
        int columnaInicial = flujo.getColumna();

        String estado = "q0";
        String lexema = "";

        while (flujo.getPosicionActual() < flujo.getCantidadCaracteres()) {
            if ("q1".equals(estado)) {
                estado = estado_q1(flujo.getCaracter());
            }

            if ("q0".equals(estado)) {
                estado = estado_q0(flujo.getCaracter());
            }

            if ("qe".equals(estado)) {
                break;
            }

            lexema += flujo.getCaracter();
            flujo.moverAdelante();
            flujo.siguienteColumna();

            if ("qf".equals(estado)) {              
                if (flujo.getPosicionActual() != flujo.getCantidadCaracteres()) {
                    if("<".equals(lexema)){
                        if('=' == flujo.getCaracter()){
                            estado = "q1";
                            continue;
                        }
                    }
                    if(">".equals(lexema)){
                        if('=' == flujo.getCaracter()){
                            estado = "q1";
                            continue;
                        }
                    }
                }
                return estado_qf(lexema, flujo.getFila(), columnaInicial);
            }
        }

        flujo.setPosicionActual(posicionInicial);
        return null;
    }

    /**
     * *
     * Metodo que evalua el estado inicial del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    @Override
    public String estado_q0(char caracter) {
        String estado = "qe";
        
        if (caracter == '=' || caracter == '!') {
            estado = "q1";
        }

        if (caracter == '<' || caracter == '>') {
            estado = "qf";
        }

        return estado;
    }

    /**
     * *
     * Metodo que evalua el estado q1 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q1(char caracter) {
        return caracter == '=' ? "qf" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado final del automata.
     *
     * @param lexema
     * @param fila
     * @param columna
     * @return Lexema que identifico el automata en el estado final
     */
    @Override
    public Lexema estado_qf(String lexema, int fila, int columna) {
        TipoLexemaEnum tipoLexema = null;
        switch (lexema){
            case "<":
                tipoLexema = TipoLexemaEnum.OPE_REL_MENOR;
                break;
            case ">":
                tipoLexema = TipoLexemaEnum.OPE_REL_MAYOR;
                break;            
            case "<=":
                tipoLexema = TipoLexemaEnum.OPE_REL_MENOR_IGUAL;
                break;
            case ">=":
                tipoLexema = TipoLexemaEnum.OPE_REL_MAYOR_IGUAL;
                break;
            case "==":
                tipoLexema = TipoLexemaEnum.OPE_REL_IGUAL_IGUAL;
                break;
            case "!=":
                tipoLexema = TipoLexemaEnum.OPE_REL_DIFERENTE;
                break;
        }
        return new Lexema(lexema, tipoLexema, fila, columna, lexema.length());
    }
}
