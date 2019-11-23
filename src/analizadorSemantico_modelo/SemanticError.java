/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo;

import analizadorLexico_modelo.TipoLexemaEnum;

/**
 *
 * @author Pepe
 */
public class SemanticError extends RuntimeException{

    /***
     * metodo para datos incopatibles en asignaciones
     * @param tipoVariable
     * @param tipoAsignacion
     * @param fila 
     */
    public SemanticError(TipoLexemaEnum tipoVariable, TipoLexemaEnum tipoAsignacion, int fila) {
        super("En la linea " +fila+". Tipo de datos incompatibles: "+tipoAsignacion+" no puede castearse a "+tipoVariable);
    }
    
    /***
     * metodo para variables y metodos ya declarados
     * valor 0 => variable ya declarada
     * valor 1 => metodo ya declarado
     * @param nombre
     * @param valor 
     * @param fila 
     */
    public SemanticError(String nombre, int valor, int fila) {
        super(valor == 0 ? "En la linea " +fila+ ". La variable '"+nombre+"' ya ha sido declarada previamente" : "En la linea " +fila+". El metodo '"+nombre+"()' ya ha sido declarado previamente");
    }
    
    /***
     * metodo para variables y metodos que no se encuentran declarados
     * valor true => variable no declarada
     * valor false => metodo no delcarado
     * @param nombre
     * @param valor 
     * @param fila 
     */
    public SemanticError(String nombre, boolean valor, int fila) {
        super(valor ? "En la linea " +fila+ ". La variable '"+nombre+"' no se encuentra declarada" : "En la linea " +fila+ ". El metodo '"+nombre+"()' no se encuentra declarado");
    }
    
    /***
     * metodo para especificar que la variable no se encuentra inicializada
     * @param nombre
     * @param fila
     */
    public SemanticError(String nombre, int fila) {
        super("En la linea " +fila+ ". La variable '"+nombre+"' no se encuentra inicializada");
    }
    
    /***
     * metodo para saber que el metodo no se ha invocado correctamente
     * @param nombre
     * @param fila
     */
    public SemanticError(int fila, String nombre) {
        super("En la linea " +fila+ ". El metodo '"+nombre+"()' no ha sido llamado correctamente, parametros incorrectos");
    }

}
