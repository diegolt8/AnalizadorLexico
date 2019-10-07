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
import analizadorSintactico_modelo.sentencias.HTTPConsultar;
import analizadorSintactico_modelo.sentencias.HTTPParametros;

/**
 *
 * @author Pepe
 */
public class Gramatica_HTTPConsultar implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {

        Gramatica_HTTPParametros gramaticaHTTPParametros = new Gramatica_HTTPParametros();

        HTTPConsultar httpConsultar = new HTTPConsultar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VERBO_HTTP_GET) {
            return null;
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.IDENTIFICADOR && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VALOR_CADENA) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.URL);
        }
        httpConsultar.setUrl(flujoLexema.getLexema());
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PUNTO) {
            flujoLexema.avanzar();
            
            HTTPParametros httpParametros = (HTTPParametros) gramaticaHTTPParametros.analizar(flujoLexema);
            if (httpParametros == null) {
               throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.HTTP_PARAMETROS);
            }
            httpConsultar.setParametros(httpParametros);
        }        

        return httpConsultar;
    }

}
