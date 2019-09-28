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
import analizadorSintactico_modelo.sentencias.ExpresionRelacional;
import analizadorSintactico_modelo.sentencias.TerminoRelacional;

/**
 *
 * @author Pepe
 */
public class Gramatica_ExpresionRelacional implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_TerminoRelacional gramaticaTerminoRelacional = new Gramatica_TerminoRelacional();
        
        ExpresionRelacional expresionRelacional = new ExpresionRelacional();
        
        TerminoRelacional terminoRelacional = (TerminoRelacional) gramaticaTerminoRelacional.analizar(flujoLexema);
        if (terminoRelacional == null) {
            return null;
        }
        expresionRelacional.setTerminoRelacional(terminoRelacional);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_DIFERENTE && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_IGUAL_IGUAL && 
                flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_MAYOR && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_MAYOR_IGUAL &&
                flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_MENOR && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_MENOR_IGUAL) {
            return expresionRelacional;
        }
        expresionRelacional.setOperadorRelacional(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        ExpresionRelacional expreRelacional = (ExpresionRelacional) analizar(flujoLexema);
        if (expreRelacional == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EXPRESION_RELACIONAL);
        }
        expresionRelacional.setExpresionRelacional(expreRelacional);
        
        return expresionRelacional;
    }
    
}
