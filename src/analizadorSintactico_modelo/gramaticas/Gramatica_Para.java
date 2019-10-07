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
import analizadorSintactico_modelo.sentencias.ExpresionLogica;
import analizadorSintactico_modelo.sentencias.ExpresionNumerica;
import analizadorSintactico_modelo.sentencias.ListaSentencias;
import analizadorSintactico_modelo.sentencias.Para;

/**
 *
 * @author Pepe
 */
public class Gramatica_Para implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_DeclaracionVariable gramaticaDeclaracionVariable = new Gramatica_DeclaracionVariable();
        Gramatica_DeclaranteVariable gramaticaDeclaranteVariable = new Gramatica_DeclaranteVariable();
        Gramatica_ExpresionLogica gramaticaExpresionLogica = new Gramatica_ExpresionLogica();
        Gramatica_ExpresionNumerica gramaticaExpresionNumerica = new Gramatica_ExpresionNumerica();
        Gramatica_ListaSentencias gramaticaListaSentencias = new Gramatica_ListaSentencias();
        
        Para para = new Para();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.EST_PARA) {
            return null;
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO); 
        }
        flujoLexema.avanzar();
        
        DeclaracionVariable declaracionVariable = (DeclaracionVariable) gramaticaDeclaracionVariable.analizar(flujoLexema);
        if (declaracionVariable == null) {
            DeclaranteVariable declaranteVariable = (DeclaranteVariable) gramaticaDeclaranteVariable.analizar(flujoLexema);
            if (declaranteVariable == null) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.DECLARANTE); 
            }
            para.setDeclaranteVariable(declaranteVariable);
        } else {
            para.setDeclaracionVariable(declaracionVariable);
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO_Y_COMA) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO_Y_COMA); 
        }
        flujoLexema.avanzar();
        
        ExpresionLogica expresionLogica = (ExpresionLogica) gramaticaExpresionLogica.analizar(flujoLexema);
        if (expresionLogica == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EXPRESION_RELACIONAL); 
        }
        para.setExpresionLogica(expresionLogica);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO_Y_COMA) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO_Y_COMA); 
        }
        flujoLexema.avanzar();
        
        ExpresionNumerica expresionNumerica = (ExpresionNumerica) gramaticaExpresionNumerica.analizar(flujoLexema);
        if (expresionNumerica == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EXPRESION_NUMERICA); 
        }
        para.setExpresionNumerica(expresionNumerica);
        
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
            para.setListaSentencias(listaSentencias);
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE); 
        }
        flujoLexema.avanzar();
        
        return para;
    }
    
}
