/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo.comprobacionSemantica;

import analizadorLexico_modelo.Lexema;
import analizadorSemantico_modelo.ComprobacionSemantica;
import analizadorSemantico_modelo.FlujoSentencias;
import analizadorSemantico_modelo.ReglasSemanticas;
import analizadorSemantico_modelo.SemanticError;
import analizadorSemantico_modelo.VariablesContexto;
import analizadorSintactico_modelo.sentencias.DeclaranteVariable;
import analizadorSintactico_modelo.sentencias.InicializadorVariable;
import analizadorSintactico_modelo.sentencias.LiteralNumerico;
import analizadorSintactico_modelo.sentencias.Terminal;
import analizadorSintactico_modelo.sentencias.TerminoLiteral;

/**
 *
 * @author Pepe
 */
public class ComprobacionSemantica_DeclaranteVariable implements ComprobacionSemantica {

    @Override
    public boolean comprobacionSemantica(FlujoSentencias flujoSentencia) {

        ReglasSemanticas reglas = new ReglasSemanticas();
        DeclaranteVariable declarante = (DeclaranteVariable) flujoSentencia.getNodoActual();
        VariablesContexto variable = flujoSentencia.buscarVariable(declarante.getIdentificador().getLexema());
        if (variable == null) {
            throw new SemanticError(declarante.getIdentificador().getLexema(), true, declarante.getIdentificador().getLinea());
        }
        
        InicializadorVariable inicializador = declarante.getInicializadorVariable();
        if (inicializador.getExpresion() == null) {
            // para un identificador

            // validacion de que el indentificador exista
            if (!reglas.unicidadNombreVariable(flujoSentencia.getListaVariables(), inicializador.getIdentificador().getLexema())) {
                throw new SemanticError(inicializador.getIdentificador().getLexema(), true, inicializador.getIdentificador().getLinea());
            }

            // validacion de que el identificadaor este inicializado
            if (reglas.variableInicializada(flujoSentencia.getListaVariables(), inicializador.getIdentificador().getLexema())) {
                throw new SemanticError(inicializador.getIdentificador().getLexema(), inicializador.getIdentificador().getLinea());
            }

            // validacion de tipos
            if (!reglas.tiposDatosCompatiblesVariable(variable, (flujoSentencia.buscarVariable(inicializador.getIdentificador().getLexema())).getValor())) {
                throw new SemanticError(variable.getTipoDato(), inicializador.getIdentificador().getTipoLexema(), inicializador.getIdentificador().getLinea());
            }            
            flujoSentencia.modificarValorVariable(variable.getNombre(), flujoSentencia.buscarVariable(inicializador.getIdentificador().getLexema()).getValor());
        } else {
            TerminoLiteral terminoLiteral = (TerminoLiteral) inicializador.getExpresion();
            
            if ((terminoLiteral.getTerminoLiteral().getClass() + "").equals("class analizadorSintactico_modelo.sentencias.Terminal")) {
                // para una cadena

                // validacion de tipos
                if (!reglas.tiposDatosCompatiblesAsigancion(variable, terminoLiteral)) {
                    throw new SemanticError(variable.getTipoDato(), ((Terminal) terminoLiteral.getTerminoLiteral()).getLexema().getTipoLexema(), ((Terminal) terminoLiteral.getTerminoLiteral()).getLexema().getLinea());
                }
                
                flujoSentencia.modificarValorVariable(variable.getNombre(), ((Terminal)terminoLiteral.getTerminoLiteral()).getLexema());
            } else {
                // para un numero VALIDAR PARA DECIMALES

                // validacion de tipos
                if (!reglas.tiposDatosCompatiblesAsigancion(variable, terminoLiteral)) {
                    throw new SemanticError(variable.getTipoDato(), ((Terminal) terminoLiteral.getTerminoLiteral()).getLexema().getTipoLexema(), ((Terminal) terminoLiteral.getTerminoLiteral()).getLexema().getLinea());
                }

                variable.setValor(((LiteralNumerico) terminoLiteral.getTerminoLiteral()).getParteEntera());
                flujoSentencia.modificarValorVariable(variable.getNombre(), ((LiteralNumerico) terminoLiteral.getTerminoLiteral()).getParteEntera());
            }
        }

        return true;
    }

}
