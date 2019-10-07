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
import analizadorSintactico_modelo.sentencias.HTTPModificar;
import analizadorSintactico_modelo.sentencias.HTTPParametros;
import analizadorSintactico_modelo.sentencias.JSON;

/**
 *
 * @author Pepe
 */
public class Gramatica_HTTPModificar implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_HTTPParametros gramaticaHTTPParametros = new Gramatica_HTTPParametros();
        Gramatica_JSON gramaticaJSON = new Gramatica_JSON();
        
        HTTPModificar httpModificar = new HTTPModificar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VERBO_HTTP_PATCH && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VERBO_HTTP_PUT) {
            return null;
        }
        httpModificar.setVerboHttp(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.IDENTIFICADOR && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VALOR_CADENA) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.URL);
        }
        httpModificar.setUrl(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO);
        }
        flujoLexema.avanzar();
        
        HTTPParametros httpParametros = (HTTPParametros) gramaticaHTTPParametros.analizar(flujoLexema);
        if (httpParametros == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.HTTP_PARAMETROS);
        }
        httpModificar.setHttpParametros(httpParametros);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO);
        }
        flujoLexema.avanzar();
        
        if (!flujoLexema.getLexema().getLexema().equals("Cuerpo")) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.CUERPO);
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
        }
        flujoLexema.avanzar();
        
        JSON json = (JSON) gramaticaJSON.analizar(flujoLexema);
        if (json == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.JSON);
        }
        httpModificar.setJson(json);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
        }
        flujoLexema.avanzar();
        
        return httpModificar;
    }
    
}
