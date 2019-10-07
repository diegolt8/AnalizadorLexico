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
import analizadorSintactico_modelo.sentencias.JSON;
import analizadorSintactico_modelo.sentencias.TerminoJSON;

/**
 *
 * @author Pepe
 */
public class Gramatica_JSON implements Gramatica{

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_TerminoJSON gramaticaTerminoJSON = new Gramatica_TerminoJSON();
        
        JSON json = new JSON();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.LLAVE_ABIERTA) {
            return null;
        }
        flujoLexema.avanzar();
        
        TerminoJSON terminoJSON = (TerminoJSON) gramaticaTerminoJSON.analizar(flujoLexema);
        if (terminoJSON != null) {
            json.setTerminoJSON(terminoJSON);
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.LLAVE_CERRADA) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.LLAVE_CERRADA);
        }
        flujoLexema.avanzar();        
        
        return json;
    }
    
}
