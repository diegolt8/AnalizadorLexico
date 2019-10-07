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
import analizadorSintactico_modelo.sentencias.TerminoJSON;
import analizadorSintactico_modelo.sentencias.TerminoLiteral;

/**
 *
 * @author Pepe
 */
public class Gramatica_TerminoJSON implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_TerminoLiteral gramaticaTerminoLiteral = new Gramatica_TerminoLiteral();
        
        TerminoJSON terminoJSON = new TerminoJSON();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VALOR_CADENA) {
            return null;
        }
        terminoJSON.setLiteralCadena(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.DOS_PUNTOS) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.DOS_PUNTOS);
        }
        flujoLexema.avanzar();
        
        TerminoLiteral terminoLiteral = (TerminoLiteral) gramaticaTerminoLiteral.analizar(flujoLexema);
        if (terminoLiteral == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.TERMINO_LITERAL);
        }
        terminoJSON.setTerminoLiteral(terminoLiteral);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMA) {
            return terminoJSON;
        }
        flujoLexema.avanzar();
        
        TerminoJSON terJSON = (TerminoJSON) analizar(flujoLexema);
        if (terJSON == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.TERMINO_JSON);
        }
        terminoJSON.setTerminoJSON(terJSON);
        
        return terminoJSON;
    }
    
}
