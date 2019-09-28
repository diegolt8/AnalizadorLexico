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
import analizadorSintactico_modelo.sentencias.ListaSentencias;
import analizadorSintactico_modelo.sentencias.ParaCada;

/**
 *
 * @author Pepe
 */
public class Gramatica_ParaCada implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
       
        Gramatica_DeclaracionVariable gramaticaDeclaracionVariable = new Gramatica_DeclaracionVariable();     
        Gramatica_ListaSentencias gramaticaListaSentencias = new Gramatica_ListaSentencias();
        
        ParaCada paraCada = new ParaCada();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.EST_PARA_CADA) {
            return null;
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO); 
        }
        flujoLexema.avanzar();
        
        DeclaracionVariable declaracionVariable = (DeclaracionVariable) gramaticaDeclaracionVariable.analizar(flujoLexema);
        if (declaracionVariable == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.DECLARACION_VARIABLE); 
        }
        paraCada.setDeclaracion(declaracionVariable);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.DOS_PUNTOS) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.DOS_PUNTOS); 
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.IDENTIFICADOR) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.IDENTIFICADOR); 
        }
        paraCada.setIdentificador(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO); 
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE); 
        }
        flujoLexema.avanzar();
        
        ListaSentencias<Sentencia> listaSentencias = (ListaSentencias<Sentencia>) gramaticaListaSentencias.analizar(flujoLexema);
        if (!listaSentencias.getSentencias().isEmpty()) {
            paraCada.setListaSentencias(listaSentencias);
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE); 
        }
        flujoLexema.avanzar();
        
        return paraCada;
    }
    
}
