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
import analizadorSintactico_modelo.sentencias.ExpresionLogica;
import analizadorSintactico_modelo.sentencias.ExpresionRelacional;

/**
 *
 * @author Pepe
 */
public class Gramatica_ExpresionLogica implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {

        Gramatica_ExpresionRelacional gramaticaExpresionRelacional = new Gramatica_ExpresionRelacional();

        ExpresionLogica expresionLogica = new ExpresionLogica();

        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.OPE_LOG_NOT) {
            expresionLogica.setOperadorLogicoNegacion(flujoLexema.getLexema());
            flujoLexema.avanzar();

            if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VLR_FALSO || flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VLR_VERDADERO) {
                expresionLogica.setValorLogico(flujoLexema.getLexema());
                flujoLexema.avanzar();
            } else {
                ExpresionRelacional expresionRelacional = (ExpresionRelacional) gramaticaExpresionRelacional.analizar(flujoLexema);
                if (expresionRelacional == null) {
                    return null;
                }
                expresionLogica.setExpresionRelacional(expresionRelacional);
            }
            
            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_LOG_AND && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_LOG_OR) {
                return expresionLogica;
            }
            expresionLogica.setOperadorLogico(flujoLexema.getLexema());
            flujoLexema.avanzar();
            
            ExpresionLogica expreLogica = (ExpresionLogica) analizar(flujoLexema);
            if (expreLogica == null) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EXPRESION_LOGICA);
            }
            expresionLogica.setExpresionLogica(expreLogica);
        } else {
            if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VLR_FALSO || flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VLR_VERDADERO) {
                expresionLogica.setValorLogico(flujoLexema.getLexema());
                flujoLexema.avanzar();
            } else {
                ExpresionRelacional expresionRelacional = (ExpresionRelacional) gramaticaExpresionRelacional.analizar(flujoLexema);
                if (expresionRelacional == null) {
                    return null;
                }
                expresionLogica.setExpresionRelacional(expresionRelacional);
            }

            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_LOG_AND && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_LOG_OR) {
                return expresionLogica;
            }
            expresionLogica.setOperadorLogico(flujoLexema.getLexema());
            flujoLexema.avanzar();

            ExpresionLogica expreLogica = (ExpresionLogica) analizar(flujoLexema);
            if (expreLogica == null) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EXPRESION_LOGICA);
            }
            expresionLogica.setExpresionLogica(expreLogica);
        }

        return expresionLogica;
    }

}
