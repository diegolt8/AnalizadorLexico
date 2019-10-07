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
public class Automata_PalabrasReservada_VerbosHttp implements Automata {

    /**
     * *
     * Metodo que contiene el comportamiento completo del automata, el cual se
     * encarga de determinar cuales son los lexemas de palabras reservadas por
     * el sistema - verbos Http
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
            if ("q26".equals(estado)) {
                estado = estado_q26(flujo.getCaracter());
            }

            if ("q25".equals(estado)) {
                estado = estado_q25(flujo.getCaracter());
            }
            
            if ("q24".equals(estado)) {
                estado = estado_q24(flujo.getCaracter());
            }

            if ("q23".equals(estado)) {
                estado = estado_q23(flujo.getCaracter());
            }

            if ("q22".equals(estado)) {
                estado = estado_q22(flujo.getCaracter());
            }

            if ("q21".equals(estado)) {
                estado = estado_q21(flujo.getCaracter());
            }

            if ("q20".equals(estado)) {
                estado = estado_q20(flujo.getCaracter());
            }

            if ("q19".equals(estado)) {
                estado = estado_q19(flujo.getCaracter());
            }

            if ("q18".equals(estado)) {
                estado = estado_q18(flujo.getCaracter());
            }

            if ("q17".equals(estado)) {
                estado = estado_q17(flujo.getCaracter());
            }

            if ("q16".equals(estado)) {
                estado = estado_q16(flujo.getCaracter());
            }

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
                if (flujo.getCantidadCaracteres() == flujo.getPosicionActual()) {
                    return estado_qf(lexema, flujo.getFila(), columnaInicial);
                }
                if (Pattern.matches("[^A-Za-z0-9_]", flujo.getCaracter() + "")) {
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
        if (caracter == 'C') {
            estado = "q1";
        }

        if (caracter == 'M') {
            estado = "q10";
        }

        if (caracter == 'P') {
            estado = "q16";
        }

        if (caracter == 'E') {
            estado = "q20";
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
        String estado = "qe";
        if (caracter == 'o') {
            estado = "q2";
        }

        if (caracter == 'r') {
            estado = "q7";
        }

        return estado;
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
        return caracter == 'n' ? "q3" : "qe";
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
        return caracter == 's' ? "q4" : "qe";
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
        return caracter == 'u' ? "q5" : "qe";
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
        return caracter == 'l' ? "q6" : "qe";
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
        return caracter == 't' ? "q8" : "qe";
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
        return caracter == 'a' ? "q9" : "qe";
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
        return caracter == 'r' ? "qf" : "qe";
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
        return caracter == 'o' ? "q11" : "qe";
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
        return caracter == 'd' ? "q12" : "qe";
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
        return caracter == 'i' ? "q13" : "qe";
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
        return caracter == 'f' ? "q14" : "qe";
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
        return caracter == 'i' ? "q15" : "qe";
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
        return caracter == 'c' ? "q25" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q15 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q16(char caracter) {
        return caracter == 'a' ? "q17" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q15 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q17(char caracter) {
        return caracter == 'r' ? "q18" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q18 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q18(char caracter) {
        return caracter == 'c' ? "q19" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q19 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q19(char caracter) {
        return caracter == 'h' ? "q25" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q20 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q20(char caracter) {
        return caracter == 'l' ? "q21" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q21 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q21(char caracter) {
        return caracter == 'i' ? "q22" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q22 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q22(char caracter) {
        return caracter == 'm' ? "q23" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q23 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q23(char caracter) {
        return caracter == 'i' ? "q24" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q24 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q24(char caracter) {
        return caracter == 'n' ? "q25" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q25 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q25(char caracter) {
        return caracter == 'a' ? "q26" : "qe";
    }

    /**
     * *
     * Metodo que evalua el estado q26 del automata.
     *
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto
     * retorna el valor actual.
     */
    private String estado_q26(char caracter) {
        return caracter == 'r' ? "qf" : "qe";
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
            case "Consultar":
                tipoLexema = TipoLexemaEnum.VERBO_HTTP_GET;
                break;
            case "Crear":
                tipoLexema = TipoLexemaEnum.VERBO_HTTP_POST;
                break;            
            case "Modificar":
                tipoLexema = TipoLexemaEnum.VERBO_HTTP_PUT;
                break;
            case "Parchar":
                tipoLexema = TipoLexemaEnum.VERBO_HTTP_PATCH;
                break;
            case "Eliminar":
                tipoLexema = TipoLexemaEnum.VERBO_HTTP_DELETE;
                break;
        }
        return new Lexema(lexema, tipoLexema, fila, columna, lexema.length());
    }
}
