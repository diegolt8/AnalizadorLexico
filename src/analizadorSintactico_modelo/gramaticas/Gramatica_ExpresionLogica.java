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
import analizadorSintactico_modelo.sentencias.TerminoLogico;

/**
 *
 * @author Pepe
 */
public class Gramatica_ExpresionLogica implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {

        Gramatica_TerminoLogico gramaticaTerminoLogico = new Gramatica_TerminoLogico();
        
        ExpresionLogica expresionLogica = new ExpresionLogica();

        TerminoLogico terminoLogico = (TerminoLogico) gramaticaTerminoLogico.analizar(flujoLexema);
        if (terminoLogico == null) {
            return null;
        }
        expresionLogica.setTerminoLogico(terminoLogico);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_LOG_OR && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_LOG_AND) {
            return expresionLogica;
        }
        expresionLogica.setOperador(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        ExpresionLogica expreLogica = (ExpresionLogica) analizar(flujoLexema);
        if (expreLogica == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EXPRESION_LOGICA);
        }
        expresionLogica.setExpresionLogica(expreLogica);
        
        return expresionLogica;
    }

}
