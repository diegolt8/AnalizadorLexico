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
import analizadorSintactico_modelo.sentencias.HTTP;
import analizadorSintactico_modelo.sentencias.InicializadorVariable;
import analizadorSintactico_modelo.sentencias.RespuestaHTTP;

/**
 *
 * @author Pepe
 */
public class Gramatica_InicializadorVariable implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_Expresion gramaticaExpresion = new Gramatica_Expresion();
        Gramatica_HTTP gramaticaHTTP = new Gramatica_HTTP();
        Gramatica_RespuestaHTTP gramaticaRespuestaHTTP = new Gramatica_RespuestaHTTP();
        
        InicializadorVariable inicializadorVariable = new InicializadorVariable();
        
        int posicion = flujoLexema.getPosActual();
        
        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.IDENTIFICADOR) {
            flujoLexema.avanzar();
            if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.COMA || flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PUNTO_Y_COMA) {
                flujoLexema.setPosActual(posicion);
                inicializadorVariable.setIdentificador(flujoLexema.getLexema());
                flujoLexema.avanzar();
                return inicializadorVariable;
            } else {
                flujoLexema.setPosActual(posicion);
            }
        }
        
        Sentencia expresion = gramaticaExpresion.analizar(flujoLexema);
        if (expresion != null) {
            inicializadorVariable.setExpresion(expresion);
            return inicializadorVariable;
        }
        flujoLexema.setPosActual(posicion);
        
        RespuestaHTTP respuestaHTTP = (RespuestaHTTP) gramaticaRespuestaHTTP.analizar(flujoLexema);
        if (respuestaHTTP != null) {
            inicializadorVariable.setRespuestaHttp(respuestaHTTP);
            return inicializadorVariable;
        }
        flujoLexema.setPosActual(posicion);

        HTTP http = (HTTP) gramaticaHTTP.analizar(flujoLexema);
        if (http != null) {
            inicializadorVariable.setHttp(http);
            return inicializadorVariable;
        }
        flujoLexema.setPosActual(posicion);
        
        return null;
    }
    
}
