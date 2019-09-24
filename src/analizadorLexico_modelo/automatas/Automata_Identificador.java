/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico_modelo.automatas;

import analizadorLexico_modelo.Automata;
import java.util.regex.Pattern;
import analizadorLexico_modelo.FlujoCaracteres;
import analizadorLexico_modelo.Lexema;
import analizadorLexico_modelo.TipoLexemaEnum;

/**
 *
 * @author Pepe
 */
public class Automata_Identificador implements Automata {

    /**
     * *
     * Metodo que contiene el comportamiento completo del automata, el cual se
     * encarga de determinar cuales son los lexemas de identificadores.
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

        if (posicionInicial != 0) {
            flujo.moverAtras();
            if (Pattern.matches("[0-9]", flujo.getCaracter() + "")) {
                flujo.moverAdelante();
                return null;
            }
            flujo.moverAdelante();
        }
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

            if ("qf".equals(estado)) {
                return estado_qf(lexema, flujo.getFila(), columnaInicial);
            } else {
                lexema += flujo.getCaracter();
                flujo.moverAdelante();
                flujo.siguienteColumna();
            }
        }
        if (!"qe".equals(estado)) {
            return estado_qf(lexema, flujo.getFila(), columnaInicial);
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
        return (Pattern.matches("[A-Za-z]", caracter + "")) ? "q1" : "qe";
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
        return (Pattern.matches("[A-Za-z0-9_]", caracter + "")) ? "q1" : "qf";
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
        return new Lexema(lexema, TipoLexemaEnum.IDENTIFICADOR, fila, columna, lexema.length());
    }
}
