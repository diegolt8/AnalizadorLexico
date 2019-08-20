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
public interface Automata {
    
    /***
     * Metodo que define el comportamiento interno de los automatas.
     * @param flujo
     * @return 
     */
    public Lexema ejecutarAutomata(FlujoCaracteres flujo);
    
    /***
     * Metodo que define el comportamiento del estado inicial del automata
     * @param caracter
     * @return 
     */
    public String estado_q0(char caracter);
    
    /***
     * Metodo que define el comportamiento del estado final del automata
     * @param lexema
     * @param fila
     * @param columna
     * @return 
     */
    public Lexema estado_qf(String lexema, int fila, int columna);
    
}
