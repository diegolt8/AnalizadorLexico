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
public interface Automata {
    
    /***
     * Metodo que define el comportamiento interno de los automatas.
     * @param flujo
     * @return 
     */
    public Lexema ejecutarAutomata(FlujoCaracteres flujo);
    
}
