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
import analizadorSintactico_modelo.sentencias.ImprimirConsola;

/**
 *
 * @author Pepe
 */
public class Gramatica_ImprimirConsola implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {

        Gramatica_Expresion gramaticaExpresion = new Gramatica_Expresion();

        ImprimirConsola imprimirConsola = new ImprimirConsola();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.STR_IMPR) {
            return null;
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
        }
        flujoLexema.avanzar();
        int posicion = flujoLexema.getPosActual();

        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.IDENTIFICADOR) {
            flujoLexema.avanzar();
            if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PARENTESIS_CERRADO) {
                flujoLexema.setPosActual(posicion);
                imprimirConsola.setIdentificador(flujoLexema.getLexema());
                flujoLexema.avanzar();
            } else {
                flujoLexema.setPosActual(posicion);
            }
        }

        if (imprimirConsola.getIdentificador() == null) {
            Sentencia expresion = gramaticaExpresion.analizar(flujoLexema);
            if (expresion != null) {
                imprimirConsola.setExpresion(expresion);
            } 
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
        }
        flujoLexema.avanzar();

        return imprimirConsola;
    }

}
