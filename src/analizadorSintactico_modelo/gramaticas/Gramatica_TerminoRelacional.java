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
import analizadorSintactico_modelo.sentencias.ExpresionNumerica;
import analizadorSintactico_modelo.sentencias.TerminoRelacional;

/**
 *
 * @author Pepe
 */
public class Gramatica_TerminoRelacional implements Gramatica{
    
    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_ExpresionNumerica gramaticaExpresionNumerica = new Gramatica_ExpresionNumerica();
        
        TerminoRelacional terminoRelacional = new TerminoRelacional();
        
        ExpresionNumerica expresionNumerica = (ExpresionNumerica) gramaticaExpresionNumerica.analizar(flujoLexema);
        if (expresionNumerica != null) {
            terminoRelacional.setExpresionNumerica(expresionNumerica);
            return terminoRelacional;
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VALOR_CADENA) {
            return null;
        }
        terminoRelacional.setLiteralCadena(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        return terminoRelacional;
    }
    
    
    
}
