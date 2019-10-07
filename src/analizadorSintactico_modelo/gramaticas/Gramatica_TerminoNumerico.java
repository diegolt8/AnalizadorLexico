/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.gramaticas;

import analizadorLexico_modelo.TipoLexemaEnum;
import analizadorSintactico_modelo.FlujoLexema;
import analizadorSintactico_modelo.Gramatica;
import analizadorSintactico_modelo.Sentencia;
import analizadorSintactico_modelo.SintacticException;
import analizadorSintactico_modelo.sentencias.FactorNumerico;
import analizadorSintactico_modelo.sentencias.TerminoNumerico;

/**
 *
 * @author Pepe
 */
public class Gramatica_TerminoNumerico implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_FactorNumerico gramaticaFactorNumerico = new Gramatica_FactorNumerico();
        
        TerminoNumerico terminoNumerico = new TerminoNumerico();

        FactorNumerico factorNumerico = (FactorNumerico) gramaticaFactorNumerico.analizar(flujoLexema);
        if (factorNumerico == null) {
            return null;
        }
        terminoNumerico.setFactor(factorNumerico);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_DIVISION && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_MULTIPLICACION &&
                flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_MODULO) {
            return terminoNumerico;
        }
        terminoNumerico.setOperador(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        TerminoNumerico terNumerico = (TerminoNumerico) analizar(flujoLexema);
        if (terNumerico == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.TERMINO_NUMERICO);
        }
        terminoNumerico.setTermino(terNumerico);        
        
        return terminoNumerico;
    }
    
}
