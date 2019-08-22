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
public class Automata_EstructurasControl_1 implements Automata {

    /**
     * *
     * Metodo que contiene el comportamiento completo del automata, el cual se
     * encarga de determinar cuales son los lexemas de estructuras de control.
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
            if ("q15".equals(estado)) {
                estado = estado_q15(flujo.getCaracter());
            }

            if ("q14".equals(estado)) {
                estado = estado_q14(flujo.getCaracter());
            }

            if ("q13".equals(estado)) {
                estado = estado_q13(flujo.getCaracter());
            }

            if ("q12".equals(estado)) {
                estado = estado_q12(flujo.getCaracter());
            }

            if ("q11".equals(estado)) {
                estado = estado_q11(flujo.getCaracter());
            }

            if ("q10".equals(estado)) {
                estado = estado_q10(flujo.getCaracter());
            }

            if ("q9".equals(estado)) {
                estado = estado_q9(flujo.getCaracter());
            }

            if ("q8".equals(estado)) {
                estado = estado_q8(flujo.getCaracter());
            }

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
                if (flujo.getCaracter() == 32 || flujo.getCaracter() == 10 || flujo.getCaracter() == '(') {
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
        String estado = "qe";
        if (caracter == 'S') {
            estado = "q1";
        }

        if (caracter == 'P') {
            estado = "q2";
        }

        if (caracter == 'H') {
            estado = "q5";
        }

        if (caracter == 'M') {
            estado = "q9";
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
        return caracter == 'i' ? "qf" : "qe";
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
        return caracter == 'a' ? "q3" : "qe";
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
        return caracter == 'r' ? "q4" : "qe";
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
        return caracter == 'a' ? "qf" : "qe";
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
        return caracter == 'a' ? "q6" : "qe";
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
        return caracter == 'c' ? "q7" : "qe";
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
        return caracter == 'e' ? "q8" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q8 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q8(char caracter) {
        return caracter == 'r' ? "qf" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q9 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q9(char caracter) {
        return caracter == 'i' ? "q10" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q10 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q10(char caracter) {
        return caracter == 'e' ? "q11" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q11 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q11(char caracter) {
        return caracter == 'n' ? "q12" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q12 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q12(char caracter) {
        return caracter == 't' ? "q13" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q13 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q13(char caracter) {
        return caracter == 'r' ? "q4" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q14 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q14(char caracter) {
        return caracter == 'a' ? "q15" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q15 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q15(char caracter) {
        return caracter == 's' ? "qf" : "qe";
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
        return new Lexema(lexema, "Estructura de control", fila, columna, lexema.length());
    }

}
