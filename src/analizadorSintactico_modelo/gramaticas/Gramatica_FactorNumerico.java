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
import analizadorSintactico_modelo.sentencias.ExpresionNumerica;
import analizadorSintactico_modelo.sentencias.FactorNumerico;
import analizadorSintactico_modelo.sentencias.LiteralNumerico;

/**
 *
 * @author Pepe
 */
public class Gramatica_FactorNumerico implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_ExpresionNumerica gramaticaExpresionNumerica = new Gramatica_ExpresionNumerica();
        Gramatica_LiteralNumerico gramaticaLiteralNumerico = new Gramatica_LiteralNumerico();
        
        FactorNumerico factorNumerico = new FactorNumerico();
        
        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.OPE_RESTA) {
            factorNumerico.setNegativo(flujoLexema.getLexema());
            flujoLexema.avanzar();
        }
        
        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PARENTESIS_ABIERTO) {
            factorNumerico.setParentesisAbierto(flujoLexema.getLexema());
            flujoLexema.avanzar();
            
            ExpresionNumerica expresionNumerica = (ExpresionNumerica) gramaticaExpresionNumerica.analizar(flujoLexema);
            if (expresionNumerica == null) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EXPRESION_NUMERICA);
            }
            factorNumerico.setExpresionNumerica(expresionNumerica);
            
            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
                // error
            }
            factorNumerico.setParentesisCerrado(flujoLexema.getLexema());
            flujoLexema.avanzar();
            
            return factorNumerico;
        }        
        
        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.IDENTIFICADOR) {
            factorNumerico.setIdentificador(flujoLexema.getLexema());
            flujoLexema.avanzar();
            
            if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.OPE_ESP_SUMA || flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.OPE_ESP_RESTA) {
                factorNumerico.setOperadorEspecial(flujoLexema.getLexema());
                flujoLexema.avanzar();
            }
            
            return factorNumerico;
        }
        
        LiteralNumerico literalNumerico = (LiteralNumerico) gramaticaLiteralNumerico.analizar(flujoLexema);
        if (literalNumerico != null) {
            factorNumerico.setLiteralNumerico(literalNumerico);
            return factorNumerico;
        }        
        
        return null;
    }
    
}
