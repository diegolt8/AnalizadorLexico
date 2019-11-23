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
import analizadorSintactico_modelo.sentencias.ExpresionLogica;
import analizadorSintactico_modelo.sentencias.ExpresionNumerica;
import analizadorSintactico_modelo.sentencias.TerminoLogico;

/**
 *
 * @author Pepe
 */
public class Gramatica_TerminoLogico implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {

        Gramatica_ExpresionLogica gramaticaExpresionLogica = new Gramatica_ExpresionLogica();
        Gramatica_ExpresionNumerica gramatica_ExpresionNumerica = new Gramatica_ExpresionNumerica();

        TerminoLogico terminoLogico = new TerminoLogico();

        flujoLexema.guardarPosicion();

        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.OPE_LOG_NOT) {
            terminoLogico.setNegacion(flujoLexema.getLexema());
            flujoLexema.avanzar();

            if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VLR_VERDADERO || flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VLR_FALSO) {
                terminoLogico.setValorLogico(flujoLexema.getLexema());
                flujoLexema.avanzar();
                return terminoLogico;
            }

            if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PARENTESIS_ABIERTO) {
                terminoLogico.setParentesisAbierto(flujoLexema.getLexema());
                flujoLexema.avanzar();

                ExpresionLogica expresionLogica = (ExpresionLogica) gramaticaExpresionLogica.analizar(flujoLexema);
                if (expresionLogica == null) {
                    flujoLexema.backTrack();
                } else {
                    terminoLogico.setExpresionLogica(expresionLogica);

                    if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PARENTESIS_CERRADO) {
                        terminoLogico.setParentesisCerrado(flujoLexema.getLexema());
                        flujoLexema.avanzar();
                        return terminoLogico;
                    } else {
                        throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
                    }
                }
            }
        }

        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PARENTESIS_ABIERTO) {
            terminoLogico.setParentesisAbierto(flujoLexema.getLexema());
            flujoLexema.avanzar();

            ExpresionLogica expresionLogica = (ExpresionLogica) gramaticaExpresionLogica.analizar(flujoLexema);
            if (expresionLogica == null) {
                flujoLexema.backTrack();
            } else {
                terminoLogico.setExpresionLogica(expresionLogica);

                if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PARENTESIS_CERRADO) {
                    terminoLogico.setParentesisCerrado(flujoLexema.getLexema());
                    flujoLexema.avanzar();
                    return terminoLogico;
                } else {
                    throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
                }
            }
        }

        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VLR_VERDADERO || flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VLR_FALSO) {
            terminoLogico.setValorLogico(flujoLexema.getLexema());
            flujoLexema.avanzar();
            return terminoLogico;
        }
        
        if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VALOR_CADENA) {
            terminoLogico.setLiteralCadena1(flujoLexema.getLexema());
            flujoLexema.avanzar();
            
            if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PARENTESIS_CERRADO || flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.COMA ||
                    flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.PUNTO_Y_COMA) {

                return null;
            }
            
            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_IGUAL_IGUAL && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_DIFERENTE) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.OPERADOR_RELACIONAL);
            }
            terminoLogico.setOperadorRelacional(flujoLexema.getLexema());
            flujoLexema.avanzar();
            
            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VALOR_CADENA) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.VALOR_CADENA);
            }
            terminoLogico.setLiteralCadena2(flujoLexema.getLexema());
            flujoLexema.avanzar();
            return terminoLogico;
        }
        
        ExpresionNumerica expresionNumerica = (ExpresionNumerica) gramatica_ExpresionNumerica.analizar(flujoLexema);
        if (expresionNumerica != null) {
            terminoLogico.setExpresionNumerica1(expresionNumerica);
            
            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_IGUAL_IGUAL && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_DIFERENTE &&
                    flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_MAYOR && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_MENOR &&
                    flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_MAYOR_IGUAL && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_REL_MENOR_IGUAL) {
                return terminoLogico;
            }
            terminoLogico.setOperadorRelacional(flujoLexema.getLexema());
            flujoLexema.avanzar();
            
            ExpresionNumerica expreNumerica = (ExpresionNumerica) gramatica_ExpresionNumerica.analizar(flujoLexema);
            if (expreNumerica == null) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.EXPRESION_NUMERICA);
            }
            terminoLogico.setExpresionNumerica2(expreNumerica);
            return terminoLogico;
        }

        return null;
    }

}
