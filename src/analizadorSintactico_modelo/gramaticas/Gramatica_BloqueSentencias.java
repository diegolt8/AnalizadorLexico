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
import analizadorSintactico_modelo.sentencias.ListaSentencias;

/**
 *
 * @author Pepe
 */
public class Gramatica_BloqueSentencias implements Gramatica{

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_ListaSentencias gramaticaListaSentencias = new Gramatica_ListaSentencias();
        
        ListaSentencias<Sentencia> listaSentencias;
        flujoLexema.guardarPosicion();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE){
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE);
        }
        flujoLexema.avanzar();
        
        listaSentencias = (ListaSentencias<Sentencia>) gramaticaListaSentencias.analizar(flujoLexema);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE){
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE);
        }
        flujoLexema.avanzar();
        
        return listaSentencias;
    }
    
}
