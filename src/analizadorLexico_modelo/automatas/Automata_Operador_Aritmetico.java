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
public class Automata_Operador_Aritmetico implements Automata {

    /**
     * *
     * Metodo que contiene el comportamiento completo del automata, el cual se
     * encarga de determinar cuales son los lexemas de operadores aritmeticos.
     *
     * @param flujo
     * @return lexema
     */
    @Override
    public Lexema ejecutarAutomata(FlujoCaracteres flujo) {
        int posicionInicial = flujo.getPosicionActual();
        int columnaInicial = flujo.getColumna();

        String estado;
        String lexema = "";

        estado = estado_q0(flujo.getCaracter());
        lexema += flujo.getCaracter();
        flujo.moverAdelante();
        flujo.siguienteColumna();

        if ("qf".equals(estado)) {
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
        return (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '%') ? "qf" : "qe";
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
            case "+":
                tipoLexema = TipoLexemaEnum.OPE_SUMA;
                break;
            case "-":
                tipoLexema = TipoLexemaEnum.OPE_RESTA;
                break;            
            case "*":
                tipoLexema = TipoLexemaEnum.OPE_MULTIPLICACION;
                break;
            case "/":
                tipoLexema = TipoLexemaEnum.OPE_DIVISION;
                break;
            case "%":
                tipoLexema = TipoLexemaEnum.OPE_MODULO;
                break;
        }
        return new Lexema(lexema, tipoLexema, fila, columna, lexema.length());
    }
}
