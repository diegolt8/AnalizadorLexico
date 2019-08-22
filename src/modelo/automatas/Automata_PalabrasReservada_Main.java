/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.automatas;

import modelo.FlujoCaracteres;
import modelo.Lexema;

/**
 *
 * @author Pepe
 */
public class Automata_PalabrasReservada_Main implements Automata {

    /**
     * *
     * Metodo que contiene el comportamiento completo del automata, el cual se
     * encarga de determinar cuales son los lexemas de palabras reservadas por
     * el sistema.
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
            if ("q7".equals(estado)) {
                estado = estado_q7(flujo.getCaracter());
            }

            if ("q6".equals(estado)) {
                estado = estado_q6(flujo.getCaracter());
            }

            if ("q5".equals(estado)) {
                estado = estado_q5(flujo.getCaracter());
            }

            if ("q4".equals(estado)) {
                estado = estado_q4(flujo.getCaracter());
            }

            if ("q3".equals(estado)) {
                estado = estado_q3(flujo.getCaracter());
            }

            if ("q2".equals(estado)) {
                estado = estado_q2(flujo.getCaracter());
            }

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
                if (flujo.getCaracter() == '(' || flujo.getCaracter() == 32) {
                    return estado_qf(lexema, flujo.getFila(), columnaInicial);
                } else {
                    break;
                }
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
        return caracter == '_' ? "q1" : "qe";
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
        return caracter == '_' ? "q2" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q2 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q2(char caracter) {
        return caracter == 'm' ? "q3" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q3 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q3(char caracter) {
        return caracter == 'a' ? "q4" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q4 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q4(char caracter) {
        return caracter == 'i' ? "q5" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q5 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q5(char caracter) {
        return caracter == 'n' ? "q6" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q6 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q6(char caracter) {
        return caracter == '_' ? "q7" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q7 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q7(char caracter) {
        return caracter == '_' ? "qf" : "qe";
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
        return new Lexema(lexema, "Palabra Reservada: Main", fila, columna, lexema.length());
    }

}
