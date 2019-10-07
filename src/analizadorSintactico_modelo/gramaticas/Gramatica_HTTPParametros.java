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
import analizadorSintactico_modelo.sentencias.HTTPParametros;
import analizadorSintactico_modelo.sentencias.JSON;
import analizadorSintactico_modelo.sentencias.TerminoLiteral;

/**
 *
 * @author Pepe
 */
public class Gramatica_HTTPParametros implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {

        Gramatica_JSON gramaticaJSON = new Gramatica_JSON();
        Gramatica_TerminoLiteral gramaticaTerminoLiteral = new Gramatica_TerminoLiteral();

        HTTPParametros httpParametros = new HTTPParametros();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.REQUEST_PARAMETROS) {
            return null;
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO);
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getLexema().equals("Path")) {
            flujoLexema.avanzar();

            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
            }
            flujoLexema.avanzar();

            TerminoLiteral terminoLiteral = (TerminoLiteral) gramaticaTerminoLiteral.analizar(flujoLexema);
            if (terminoLiteral == null) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.TERMINO_LITERAL);
            }
            httpParametros.setTerminoLiteral(terminoLiteral);

            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
            }
            flujoLexema.avanzar();
            
            return httpParametros;
        }
        
        if (flujoLexema.getLexema().getLexema().equals("Query")) {
            flujoLexema.avanzar();

            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
            }
            flujoLexema.avanzar();

            JSON json = (JSON) gramaticaJSON.analizar(flujoLexema);
            if (json == null) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.JSON);
            }
            httpParametros.setJson(json);

            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
            }
            flujoLexema.avanzar();
            
            return httpParametros;
        }

        return null;
    }

}
