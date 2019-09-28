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
import analizadorSintactico_modelo.sentencias.DeclaracionVariable;
import analizadorSintactico_modelo.sentencias.DeclaranteVariable;
import analizadorSintactico_modelo.sentencias.ListaDeclarante;

/**
 *
 * @author Pepe
 */
public class Gramatica_DeclaracionVariable implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_ListaDeclarante gramaticaListaDeclaramte = new Gramatica_ListaDeclarante();
        
        DeclaracionVariable declaracionVariable = new DeclaracionVariable();
             
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_BOL && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_CAD &&
            flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_CAR && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_DEC &&
            flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_ENT && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.TIPO_DATO_VAR) {            
            return null;
        }
        declaracionVariable.setTipoDato(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        ListaDeclarante<DeclaranteVariable> listaDeclarante = (ListaDeclarante<DeclaranteVariable>) gramaticaListaDeclaramte.analizar(flujoLexema);
        if (listaDeclarante.getDeclarantes().isEmpty()) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.IDENTIFICADOR);
        }
        declaracionVariable.setListaDeclarantes(listaDeclarante);
        
        return declaracionVariable;
    }
    
}
