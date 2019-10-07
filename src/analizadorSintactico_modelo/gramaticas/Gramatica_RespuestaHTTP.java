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
import analizadorSintactico_modelo.sentencias.HTTP;
import analizadorSintactico_modelo.sentencias.RespuestaHTTP;

/**
 *
 * @author Pepe
 */
public class Gramatica_RespuestaHTTP implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_HTTP gramaticaHttp = new Gramatica_HTTP();
        
        RespuestaHTTP respuestaHttp = new RespuestaHTTP();
        
        HTTP http = (HTTP) gramaticaHttp.analizar(flujoLexema);
        if (http == null) {
            return null;
        }
                
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO) {
            return null;
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.REQUEST_RESPUESTA) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.REQUEST_RESPUESTA); 
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
        
        return respuestaHttp;
    }
    
}
