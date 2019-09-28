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
import analizadorSintactico_modelo.sentencias.Hacer;
import analizadorSintactico_modelo.sentencias.ListaSentencias;

/**
 *
 * @author Pepe
 */
public class Gramatica_Hacer implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_ListaSentencias gramaticaListaSentencias = new Gramatica_ListaSentencias();
        Gramatica_ExpresionLogica gramaticaExpresionLogica = new Gramatica_ExpresionLogica();
        
        Hacer hacer = new Hacer();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.EST_HACER) {
            return null;
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE);
        }
        flujoLexema.avanzar();
        
        ListaSentencias listaSentencias = (ListaSentencias) gramaticaListaSentencias.analizar(flujoLexema);
        if (!listaSentencias.getSentencias().isEmpty()) {
            hacer.setListaSentencias(listaSentencias);
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE);
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.EST_MIENTRAS) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EST_MIENTRAS);
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
        }
        flujoLexema.avanzar();
      
        ExpresionLogica expresionLogica = (ExpresionLogica) gramaticaExpresionLogica.analizar(flujoLexema);
        if (expresionLogica == null){
            return null;
        }
        hacer.setExpresionLogica(expresionLogica);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);            
        }
        flujoLexema.avanzar();
        
        return hacer;
    }
    
}
