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
import analizadorSintactico_modelo.sentencias.TerminoCadena;
import analizadorSintactico_modelo.sentencias.TerminoLiteral;

/**
 *
 * @author Pepe
 */
public class Gramatica_TerminoCadena implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_TerminoLiteral gramaticaTerminoLiteral = new Gramatica_TerminoLiteral();
        
        TerminoCadena terminoCadena = new TerminoCadena();
        
        TerminoLiteral terminoLiteral = (TerminoLiteral) gramaticaTerminoLiteral.analizar(flujoLexema);
        if (terminoLiteral == null) {
            return null;
        }
        terminoCadena.setTerminoLiteral(terminoLiteral);
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMA) {
            return terminoCadena;
        }
        flujoLexema.avanzar();
        
        TerminoCadena termiCadena = (TerminoCadena) analizar(flujoLexema);
        if (termiCadena == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.TERMINO_CADENA); 
        }
        terminoCadena.setTerminoCadena(termiCadena);
        
        return terminoCadena;
    }    
}
