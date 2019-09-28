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
import analizadorSintactico_modelo.sentencias.ListaParametros;
import analizadorSintactico_modelo.sentencias.ListaSentencias;
import analizadorSintactico_modelo.sentencias.Metodo;
import analizadorSintactico_modelo.sentencias.Parametro;

/**
 *
 * @author Pepe
 */
public class Gramatica_Metodo implements Gramatica{

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_ListaParametros gramaticaListaParametros = new Gramatica_ListaParametros();
        Gramatica_BloqueSentencias gramaticaBloqueSentencias = new Gramatica_BloqueSentencias();
                   
        Metodo metodo = new Metodo();
        flujoLexema.guardarPosicion();
              
        if (flujoLexema.posicionFinal()) {
            return null;
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.DEFINICION_METODO){
            return null;
        }        
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.IDENTIFICADOR){
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.IDENTIFICADOR);
        }
        metodo.setNombreMetodo(flujoLexema.getLexema());
        flujoLexema.avanzar();
    
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO){
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
        }
        flujoLexema.avanzar();
        
        ListaParametros<Parametro> listaParametros = (ListaParametros<Parametro>) gramaticaListaParametros.analizar(flujoLexema);
        if (listaParametros == null){
            flujoLexema.backTrack();
            return null;
        }
        metodo.setListaParametros(listaParametros);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO){
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
        }
        flujoLexema.avanzar();
        
        ListaSentencias<Sentencia> listaSentencias = (ListaSentencias<Sentencia>) gramaticaBloqueSentencias.analizar(flujoLexema);
        metodo.setListaSentencias(listaSentencias);        
        
        return metodo;
    }
    
}
