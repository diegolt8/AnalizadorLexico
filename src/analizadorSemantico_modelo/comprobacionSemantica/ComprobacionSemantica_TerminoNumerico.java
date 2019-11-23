/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo.comprobacionSemantica;

import analizadorSemantico_modelo.ComprobacionSemantica;
import analizadorSemantico_modelo.FlujoSentencias;
import analizadorSintactico_modelo.sentencias.TerminoNumerico;

/**
 *
 * @author Pepe
 */
public class ComprobacionSemantica_TerminoNumerico implements ComprobacionSemantica {

    @Override
    public boolean comprobacionSemantica(FlujoSentencias flujoSentencia) {
        
        ComprobacionSemantica_FactorNumerico comprobacionFactorNumerico = new ComprobacionSemantica_FactorNumerico();
        
        TerminoNumerico terminoNumerico = (TerminoNumerico) flujoSentencia.getNodoActual();
        
        flujoSentencia.setNodoActual(terminoNumerico.getFactor());
        comprobacionFactorNumerico.comprobacionSemantica(flujoSentencia);
        
        if (terminoNumerico.getTermino() != null) {
            flujoSentencia.setNodoActual(terminoNumerico.getTermino());
            comprobacionSemantica(flujoSentencia);
        }
        
        return true;
    }
    
}
