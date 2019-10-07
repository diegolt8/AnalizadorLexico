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
import analizadorSintactico_modelo.sentencias.ExpresionNumerica;
import analizadorSintactico_modelo.sentencias.TerminoNumerico;

/**
 *
 * @author Pepe
 */
public class Gramatica_ExpresionNumerica implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {      

        Gramatica_TerminoNumerico gramaticaTerminoNumerico = new Gramatica_TerminoNumerico();
        
        ExpresionNumerica expresionNumerica = new ExpresionNumerica();
        
        TerminoNumerico terminoNumerico = (TerminoNumerico) gramaticaTerminoNumerico.analizar(flujoLexema);
        if (terminoNumerico == null) {
            return null;
        }
        expresionNumerica.setTermino(terminoNumerico);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_SUMA && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_RESTA) {
            return expresionNumerica;
        }
        expresionNumerica.setOperador(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        ExpresionNumerica expreNumerica = (ExpresionNumerica) analizar(flujoLexema);
        if (expreNumerica == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EXPRESION_NUMERICA);
        }
        expresionNumerica.setExpresion(expreNumerica);      
        
        return expresionNumerica;
    }

}
