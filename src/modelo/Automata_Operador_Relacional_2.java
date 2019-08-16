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
public class Automata_Operador_Relacional_2 implements Automata{

    /***
     * Metodo que contiene el comportamiento completo del automata, el cual se 
     * encarga de determinar cuales son los lexemas de operadores relacionales 2.
     * @param flujo
     * @return lexema
     */
    @Override
    public Lexema ejecutarAutomata(FlujoCaracteres flujo) {
        int cantidadLetras = flujo.getCantidadCaracteres();
        int posicionInicial = flujo.getPosicionActual();
        
        String estado = "q0";
        String estadoInicial = "q0";
        String lexema = "";
        
        while(flujo.getPosicionActual() < cantidadLetras){
            if("q1".equals(estado)){
                estado = estado_q1(flujo.getCaracter());
            }
            if("q0".equals(estado)){
                estado = estado_q0(flujo.getCaracter());
            }           
            if(estadoInicial.equals(estado)){
                break;
            }
            
            lexema += flujo.getCaracter();
            flujo.moverAdelante();
            estadoInicial = estado;
            
            if("qf".equals(estado)){
                return estado_qf(lexema, 0, 0);
            }            
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
    public String estado_q0(char caracter) {
        String estado = "q0";
        if( caracter == '<' || caracter == '>' || caracter == '=' || caracter == '!' ){
            estado = "q1";
        }
        return estado;
    }

    /***
     * Metodo que evalua el estado q1 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q1(char caracter){
        return caracter == '=' ? "qf" : "q1";
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
        return new Lexema(lexema, "Operador Relacional", fila, columna);
    }
    
}
