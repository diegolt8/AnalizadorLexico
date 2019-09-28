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
import analizadorSintactico_modelo.sentencias.ExpresionLogica;
import analizadorSintactico_modelo.sentencias.ListaSentencias;
import analizadorSintactico_modelo.sentencias.Mientras;

/**
 *
 * @author Pepe
 */
public class Gramatica_Mientras implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_ExpresionLogica gramaticaExpresionLogica = new Gramatica_ExpresionLogica();
        Gramatica_ListaSentencias gramaticaListaSentencias = new Gramatica_ListaSentencias();
        
        Mientras mientras = new Mientras();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.EST_MIENTRAS) {
            return null;
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO); 
        }
        flujoLexema.avanzar();
        
        ExpresionLogica expresionLogica = (ExpresionLogica) gramaticaExpresionLogica.analizar(flujoLexema);
        if (expresionLogica == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EXPRESION_LOGICA); 
        }
        mientras.setExpresionLogica(expresionLogica);
        
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
            mientras.setListaSentencias(listaSentencias);
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE); 
        }
        flujoLexema.avanzar();
        
        return mientras;
    }
    
}
