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
import analizadorSintactico_modelo.sentencias.ExpresionLogica;
import analizadorSintactico_modelo.sentencias.ExpresionNumerica;
import analizadorSintactico_modelo.sentencias.TerminoCadena;
import analizadorSintactico_modelo.sentencias.TerminoLiteral;
import analizadorSintactico_modelo.sentencias.Terminal;

/**
 *
 * @author Pepe
 */
public class Gramatica_Expresion implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {

        Gramatica_ExpresionLogica gramaticaExpresionLogica = new Gramatica_ExpresionLogica();
        Gramatica_ExpresionNumerica gramaticaExpresionNumerica = new Gramatica_ExpresionNumerica();
        Gramatica_TerminoLiteral gramaticaTerminoLiteral = new Gramatica_TerminoLiteral();
        Gramatica_TerminoCadena gramaticaTerminoCadena = new Gramatica_TerminoCadena();

        flujoLexema.guardarPosicion();      
        
        int posicion = flujoLexema.getPosActual();
        
        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VLR_NULO) {
            Terminal terminal = new Terminal(flujoLexema.getLexema());
            flujoLexema.avanzar();
            return terminal;
        }       

        ExpresionNumerica expresionNumerica = (ExpresionNumerica) gramaticaExpresionNumerica.analizar(flujoLexema);
        if (expresionNumerica != null) {
            if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PUNTO_Y_COMA) {
                return expresionNumerica; 
            }
        }
        flujoLexema.setPosActual(posicion);
        
        ExpresionLogica expresionLogica = (ExpresionLogica) gramaticaExpresionLogica.analizar(flujoLexema);
        if (expresionLogica != null) {
            return expresionLogica;
        }
        flujoLexema.setPosActual(posicion);       
        
        TerminoLiteral terminoLiteral = (TerminoLiteral) gramaticaTerminoLiteral.analizar(flujoLexema);
        if (terminoLiteral != null) {
            return terminoLiteral;
        }
        flujoLexema.setPosActual(posicion);
        
        TerminoCadena terminoCadena = (TerminoCadena) gramaticaTerminoCadena.analizar(flujoLexema);
        if (terminoCadena != null) {
            return terminoCadena;
        }
        flujoLexema.setPosActual(posicion);
        
        return null;
    }

}
