/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo.comprobacionSemantica;

import analizadorSemantico_modelo.ComprobacionSemantica;
import analizadorSemantico_modelo.FlujoSentencias;
import analizadorSintactico_modelo.sentencias.TerminoLogico;

/**
 *
 * @author Pepe
 */
public class ComprobacionSemantica_TerminoLogico implements ComprobacionSemantica {

    @Override
    public boolean comprobacionSemantica(FlujoSentencias flujoSentencia) {
        
        ComprobacionSemantica_ExpresionNumerica comprobacionExpresionNumerica = new ComprobacionSemantica_ExpresionNumerica();
        ComprobacionSemantica_ExpresionLogica comprobacionExpresionLogica = new ComprobacionSemantica_ExpresionLogica();
        
        TerminoLogico terminoLogico = (TerminoLogico) flujoSentencia.getNodoActual();
        
        if (terminoLogico.getExpresionNumerica1() != null) {
            flujoSentencia.setNodoActual(terminoLogico.getExpresionNumerica1());
            comprobacionExpresionNumerica.comprobacionSemantica(flujoSentencia);
        }
        
        if (terminoLogico.getExpresionNumerica2() != null) {
            flujoSentencia.setNodoActual(terminoLogico.getExpresionNumerica2());
            comprobacionExpresionNumerica.comprobacionSemantica(flujoSentencia);
        }
        
        if (terminoLogico.getExpresionLogica()!= null) {
            flujoSentencia.setNodoActual(terminoLogico.getExpresionLogica());
            comprobacionExpresionLogica.comprobacionSemantica(flujoSentencia);
        }
        
        return true;
    }
    
}
