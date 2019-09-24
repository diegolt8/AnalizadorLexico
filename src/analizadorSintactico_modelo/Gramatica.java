/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo;

/**
 *
 * @author Pepe
 */
public interface Gramatica {
    
    public Sentencia analizar(FlujoLexema flujoLexema);
}
