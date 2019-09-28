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
import analizadorSintactico_modelo.sentencias.TerminoLiteral;
import analizadorSintactico_modelo.sentencias.newpackage.Terminal;

/**
 *
 * @author Pepe
 */
public class Gramatica_TerminoLiteral implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_LiteralNumerico gramaticaLiteralNumerico = new Gramatica_LiteralNumerico();
        
        TerminoLiteral terminoLiteral = new TerminoLiteral();
        
        LiteralNumerico literalNumerico = (LiteralNumerico) gramaticaLiteralNumerico.analizar(flujoLexema);
        if (literalNumerico != null) {
            terminoLiteral.setTerminoLiteral(terminoLiteral);
            return terminoLiteral;
        }
        
        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VALOR_CADENA) {
            terminoLiteral.setTerminoLiteral(new Terminal(flujoLexema.getLexema()));
        }
        flujoLexema.avanzar();
        
        return terminoLiteral;
    }
    
}
