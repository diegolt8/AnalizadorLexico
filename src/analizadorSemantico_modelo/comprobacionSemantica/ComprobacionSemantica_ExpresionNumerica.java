/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo.comprobacionSemantica;

import analizadorSemantico_modelo.ComprobacionSemantica;
import analizadorSemantico_modelo.FlujoSentencias;
import analizadorSintactico_modelo.sentencias.ExpresionNumerica;

/**
 *
 * @author Pepe
 */
public class ComprobacionSemantica_ExpresionNumerica implements ComprobacionSemantica{

    @Override
    public boolean comprobacionSemantica(FlujoSentencias flujoSentencia) {
        
        ComprobacionSemantica_TerminoNumerico comprobacionTerminoNumerico = new ComprobacionSemantica_TerminoNumerico();
        
        ExpresionNumerica expresionNumerica = (ExpresionNumerica) flujoSentencia.getNodoActual();
        
        flujoSentencia.setNodoActual(expresionNumerica.getTermino());
        comprobacionTerminoNumerico.comprobacionSemantica(flujoSentencia);
        
        if (expresionNumerica.getExpresion() != null) {
            flujoSentencia.setNodoActual(expresionNumerica.getExpresion());
            comprobacionSemantica(flujoSentencia);
        }      
        
        return true;
    }
    
}
