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
public class Automata_Operador_Asignacion implements Automata{

    /***
     * Metodo que contiene el comportamiento completo del automata, el cual se 
     * encarga de determinar cuales son los lexemas de operadores de Asignacion.
     * @param flujo
     * @return lexema
     */
    @Override
    public Lexema ejecutarAutomata(FlujoCaracteres flujo) {
        int cantidadLetras = flujo.getCantidadCaracteres();
        int posicionActual = flujo.getPosicionActual();
        
        String estado = "q0";
        String estadoInicial = "q0";
        String lexema = "";
        
        while(posicionActual < cantidadLetras){
            if("q1".equals(estado)){
                estado = estado_q1(flujo.getCaracter(posicionActual));
            }
            if("q0".equals(estado)){
                estado = estado_q0(flujo.getCaracter(posicionActual));
            }           
            if(estadoInicial.equals(estado)){
                break;
            }
            
            lexema += flujo.getCaracter(posicionActual);
            posicionActual++;
            estadoInicial = estado;
            
            if("qf".equals(estado)){
                return estado_qf(lexema, 0, 0);
            }            
        }
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
        if( caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' ){
            estado = "q1";
        }
        if(caracter == '='){
            estado = "qf";
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
        return new Lexema(lexema, "Operador Asignacion", fila, columna);
    }
    
}
