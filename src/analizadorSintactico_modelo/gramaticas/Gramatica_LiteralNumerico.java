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
import analizadorSintactico_modelo.sentencias.LiteralNumerico;

/**
 *
 * @author Pepe
 */
public class Gramatica_LiteralNumerico implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        LiteralNumerico literalNumerico = new LiteralNumerico();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VALOR_NUMERICO) {
            return null;
        }
        literalNumerico.setParteEntera(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO) {
            return literalNumerico;
        } 
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VALOR_NUMERICO) {
            //error sintactico
            return null;
        }
        literalNumerico.setParteDecimal(flujoLexema.getLexema());
        flujoLexema.avanzar();
                
        return literalNumerico;
    }
    
}
