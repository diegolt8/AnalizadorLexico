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
import analizadorSintactico_modelo.sentencias.LiteralNumerico;
import analizadorSintactico_modelo.sentencias.TerminoNumerico;

/**
 *
 * @author Pepe
 */
public class Gramatica_TerminoNumerico implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_LiteralNumerico gramaticaLiteralNumerico = new Gramatica_LiteralNumerico();
        
        TerminoNumerico terminoNumerico = new TerminoNumerico();
        
        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.OPE_RESTA) {
            terminoNumerico.setSigno(flujoLexema.getLexema());
            flujoLexema.avanzar();
            
            LiteralNumerico literalNumerico = (LiteralNumerico) gramaticaLiteralNumerico.analizar(flujoLexema);
            if (literalNumerico == null) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.LITERAL_NUMERICO); 
            } 
            terminoNumerico.setLiteralNuerico(literalNumerico);
            return terminoNumerico;           
        } else {
            LiteralNumerico literalNumerico = (LiteralNumerico) gramaticaLiteralNumerico.analizar(flujoLexema);
            if (literalNumerico != null) {
                terminoNumerico.setLiteralNuerico(literalNumerico);
                return terminoNumerico;
            }
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.IDENTIFICADOR) {
            return null;
        }
        terminoNumerico.setIdentificador(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.OPE_ESP_SUMA || flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.OPE_ESP_RESTA){
            terminoNumerico.setOperadorEspecial(flujoLexema.getLexema());
            flujoLexema.avanzar();
        }
        
        return terminoNumerico;
    }
    
}
