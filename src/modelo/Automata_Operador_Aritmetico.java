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
public class Automata_Operador_Aritmetico implements Automata{

    /***
     * Metodo que contiene el comportamiento completo del automata, el cual se 
     * encarga de determinar cuales son los lexemas de operadores aritmeticos.
     * @param flujo
     * @return lexema
     */
    @Override
    public Lexema ejecutarAutomata(FlujoCaracteres flujo) {
        int posicionInicial = flujo.getPosicionActual();
        String estado = "q0";
        String lexema = "";        
    
        estado = estado_q0(flujo.getCaracter());
        lexema += flujo.getCaracter();
        flujo.moverAdelante();
        
        if("qf".equals(estado)){
            return estado_qf(lexema, 0, 0);
        }
        
        flujo.setPosicionActual(posicionInicial);
        return null;
    }
    
    /***
     * Metodo que evalua el estado inicial del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    @Override
    public String estado_q0(char caracter){
        String estado = "q0";
        if( caracter == '+' || caracter == '-' || caracter == '*' || 
            caracter == '/' || caracter == '%'){
            estado = "qf";
        }
        return estado;
    }

    /***
     * Metodo que evalua el estado final del automata.
     * @param lexema
     * @param fila
     * @param columna
     * @return Lexema que identifico el automata en el estado final
     */
    @Override
    public Lexema estado_qf(String lexema, int fila, int columna) {
        return new Lexema(lexema, "Operador Logico", fila, columna);
    }
    
}
