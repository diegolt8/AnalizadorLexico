/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo.comprobacionSemantica;

import analizadorSemantico_modelo.ComprobacionSemantica;
import analizadorSemantico_modelo.FlujoSentencias;
import analizadorSintactico_modelo.sentencias.ExpresionLogica;

/**
 *
 * @author Pepe
 */
public class ComprobacionSemantica_ExpresionLogica implements ComprobacionSemantica {

    @Override
    public boolean comprobacionSemantica(FlujoSentencias flujoSentencia) {
        
        ComprobacionSemantica_TerminoLogico comprobacionTerminoLogico = new ComprobacionSemantica_TerminoLogico();
        
        ExpresionLogica expresionLogica = (ExpresionLogica) flujoSentencia.getNodoActual();
        
        flujoSentencia.setNodoActual(expresionLogica.getTerminoLogico());
        comprobacionTerminoLogico.comprobacionSemantica(flujoSentencia);
        
        if (expresionLogica.getExpresionLogica() != null) {
            flujoSentencia.setNodoActual(expresionLogica.getExpresionLogica());
            comprobacionSemantica(flujoSentencia);
        }
        
        return true;
    }
    
}
