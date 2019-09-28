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
import analizadorSintactico_modelo.sentencias.Parametro;

/**
 *
 * @author Pepe
 */
public class Gramatica_Parametro implements Gramatica{

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Parametro parametro = new Parametro();
        flujoLexema.guardarPosicion();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_BOL && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_CAD &&
            flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_CAR && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_DEC &&
            flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_ENT && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_VAR) {            
            return null;
        }
        parametro.setTipoDato(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.IDENTIFICADOR){
            // error sintactico
            flujoLexema.backTrack();
            return null;
        }
        parametro.setNombreParametro(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        return parametro;
    }


}
