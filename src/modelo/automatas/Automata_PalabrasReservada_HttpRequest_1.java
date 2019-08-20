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
public class Automata_PalabrasReservada_HttpRequest_1 implements Automata{
    
    /***
     * Metodo que contiene el comportamiento completo del automata, el cual se 
     * encarga de determinar cuales son los lexemas de palabras reservadas
     * por el sistema.
     * @param flujo
     * @return lexema
     */
    @Override
    public Lexema ejecutarAutomata(FlujoCaracteres flujo) {
        int posicionInicial = flujo.getPosicionActual();
        
        String estado = "q0";
        String lexema = "";
        
        while(flujo.getPosicionActual() < flujo.getCantidadCaracteres()){
            if("q29".equals(estado))
                estado = estado_q29(flujo.getCaracter());
            
            if("q28".equals(estado))
                estado = estado_q28(flujo.getCaracter());
            
            if("q27".equals(estado))
                estado = estado_q27(flujo.getCaracter());
            
            if("q26".equals(estado))
                estado = estado_q26(flujo.getCaracter());
            
            if("q25".equals(estado))
                estado = estado_q25(flujo.getCaracter());
            
            if("q24".equals(estado))
                estado = estado_q24(flujo.getCaracter());
            
            if("q23".equals(estado))
                estado = estado_q23(flujo.getCaracter());
            
            if("q22".equals(estado))
                estado = estado_q22(flujo.getCaracter());
            
            if("q21".equals(estado))
                estado = estado_q21(flujo.getCaracter());
            
            if("q20".equals(estado))
                estado = estado_q20(flujo.getCaracter());
            
            if("q19".equals(estado))
                estado = estado_q19(flujo.getCaracter());
            
            if("q18".equals(estado))
                estado = estado_q18(flujo.getCaracter());
            
            if("q17".equals(estado))
                estado = estado_q17(flujo.getCaracter());
            
            if("q16".equals(estado))
                estado = estado_q16(flujo.getCaracter());
            
            if("q15".equals(estado))
                estado = estado_q15(flujo.getCaracter());
            
            if("q14".equals(estado))
                estado = estado_q14(flujo.getCaracter());
            
            if("q13".equals(estado))
                estado = estado_q13(flujo.getCaracter());
             
            if("q12".equals(estado))
                estado = estado_q12(flujo.getCaracter());
            
            if("q11".equals(estado))
                estado = estado_q11(flujo.getCaracter());
            
            if("q10".equals(estado))
                estado = estado_q10(flujo.getCaracter());
            
            if("q9".equals(estado))
                estado = estado_q9(flujo.getCaracter());
            
            if("q8".equals(estado))
                estado = estado_q8(flujo.getCaracter());
              
            if("q7".equals(estado))
                estado = estado_q7(flujo.getCaracter());
            
            if("q6".equals(estado))
                estado = estado_q6(flujo.getCaracter());
            
            if("q5".equals(estado))
                estado = estado_q5(flujo.getCaracter());
            
            if("q4".equals(estado))
                estado = estado_q4(flujo.getCaracter());
            
            if("q3".equals(estado))
                estado = estado_q3(flujo.getCaracter());
            
            if("q2".equals(estado))
                estado = estado_q2(flujo.getCaracter());
            
            if("q1".equals(estado))
                estado = estado_q1(flujo.getCaracter());
            
            if("q0".equals(estado))
                estado = estado_q0(flujo.getCaracter());
                       
            if("qe".equals(estado))
                break;            
            
            lexema += flujo.getCaracter();
            flujo.moverAdelante();
            
            if("qf".equals(estado))
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
    public String estado_q0(char caracter) {
        return caracter == 'T' ? "q1" : "qe";
    }

    /***
     * Metodo que evalua el estado q1 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q1(char caracter){
        return caracter == 'r' ? "q2" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q2 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q2(char caracter){
        return caracter == 'a' ? "q3" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q3 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q3(char caracter){
        return caracter == 'e' ? "q4" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q4 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q4(char caracter){
        return caracter == 'r' ? "q5" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q5 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q5(char caracter){
        String estado = "qe";
        if (caracter == 'C')
            estado = "q6";
        
        if (caracter == 'N')
            estado = "q15";
        
        if (caracter == 'M')
            estado = "q20";
        
        if (caracter == 'V')
            estado = "q26";
        
        return estado;
    }
    
    /***
     * Metodo que evalua el estado q6 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q6(char caracter){
        String estado = "qe";
        if (caracter == 'o')
            estado = "q7";
        
        if (caracter == 'u')
            estado = "q11";
        
        return estado;
    }
    
    /***
     * Metodo que evalua el estado q7 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q7(char caracter){
        return caracter == 'd' ? "q8" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q8 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q8(char caracter){
        return caracter == 'i' ? "q9" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q9 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q9(char caracter){
        return caracter == 'g' ? "q10" : "qe";
    }

    /***
     * Metodo que evalua el estado q10 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q10(char caracter){
        return caracter == 'o' ? "qf" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q11 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q11(char caracter){
        return caracter == 'e' ? "q12" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q12 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q12(char caracter){
        return caracter == 'r' ? "q13" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q13 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q13(char caracter){
        return caracter == 'p' ? "q14" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q14 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q14(char caracter){
        return caracter == 'o' ? "qf" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q15 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q15(char caracter){
        return caracter == 'o' ? "q16" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q15 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q16(char caracter){
        return caracter == 'm' ? "q17" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q15 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q17(char caracter){
        return caracter == 'b' ? "q18" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q18 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q18(char caracter){
        return caracter == 'r' ? "q19" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q19 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q19(char caracter){
        return caracter == 'e' ? "qf" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q20 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q20(char caracter){
        return caracter == 'e' ? "q21" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q21 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q21(char caracter){
        return caracter == 'n' ? "q22" : "qe";
    }
       
    /***
     * Metodo que evalua el estado q22 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q22(char caracter){
        return caracter == 's' ? "q23" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q23 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q23(char caracter){
        return caracter == 'a' ? "q24" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q24 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q24(char caracter){
        return caracter == 'j' ? "q25" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q25 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q25(char caracter){
        return caracter == 'e' ? "qf" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q26 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q26(char caracter){
        return caracter == 'a' ? "q27" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q27 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q27(char caracter){
        return caracter == 'l' ? "q28" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q28 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q28(char caracter){
        return caracter == 'o' ? "q29" : "qe";
    }
    
    /***
     * Metodo que evalua el estado q29 del automata.
     * @param caracter
     * @return String que contiene el nuevo estado del automata, por defecto 
     * retorna el valor actual.
     */
    private String estado_q29(char caracter){
        return caracter == 'r' ? "qf" : "qe";
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
        return new Lexema(lexema, "Estructura de control", fila, columna, lexema.length());
    }
}
