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
import analizadorSintactico_modelo.sentencias.DeclaracionVariable;
import analizadorSintactico_modelo.sentencias.DeclaranteVariable;
import analizadorSintactico_modelo.sentencias.InicializadorVariable;
import analizadorSintactico_modelo.sentencias.ListaDeclarante;
import analizadorSintactico_modelo.sentencias.LiteralNumerico;
import analizadorSintactico_modelo.sentencias.Terminal;
import analizadorSintactico_modelo.sentencias.TerminoLiteral;

/**
 *
 * @author Pepe
 */
public class ComprobacionSemantica_DeclaracionVariable implements ComprobacionSemantica {

    @Override
    public boolean comprobacionSemantica(FlujoSentencias flujoSentencia) {

        ReglasSemanticas reglas = new ReglasSemanticas();

        DeclaracionVariable declaracionVariable = (DeclaracionVariable) flujoSentencia.getNodoActual();
        Lexema tipoDato = declaracionVariable.getTipoDato();
        ListaDeclarante<DeclaranteVariable> listaDeclarantes = declaracionVariable.getListaDeclarantes();

        for (DeclaranteVariable declarante : listaDeclarantes.getDeclarantes()) {

            VariablesContexto variable = new VariablesContexto(declarante.getIdentificador().getLexema(), tipoDato.getTipoLexema(), flujoSentencia.getContextoActual());
            // validacion de que el indentificador exista
            if (reglas.unicidadNombreVariable(flujoSentencia.getListaVariables(), variable.getNombre())) {
                throw new SemanticError(variable.getNombre(), 0, declarante.getIdentificador().getLinea());
            }

            if (declarante.getInicializadorVariable() == null) {
                flujoSentencia.añadirVariable(variable);
            } else {
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
                    variable.setValor(flujoSentencia.buscarVariable(inicializador.getIdentificador().getLexema()).getValor());
                    flujoSentencia.añadirVariable(variable);
                } else {
                    TerminoLiteral terminoLiteral = (TerminoLiteral) inicializador.getExpresion();
                    System.out.println(terminoLiteral.getTerminoLiteral().getClass()+"");
                    if ((terminoLiteral.getTerminoLiteral().getClass()+"").equals("class analizadorSintactico_modelo.sentencias.Terminal")) {
                        // para una cadena

                        // validacion de tipos
                        if (!reglas.tiposDatosCompatiblesAsigancion(variable, terminoLiteral)) {
                             throw new SemanticError(variable.getTipoDato(), ((Terminal) terminoLiteral.getTerminoLiteral()).getLexema().getTipoLexema(), ((Terminal) terminoLiteral.getTerminoLiteral()).getLexema().getLinea());
                        }
                        variable.setValor(((Terminal) terminoLiteral.getTerminoLiteral()).getLexema());
                        flujoSentencia.añadirVariable(variable);
                    } else {
                        // para un numero VALIDAR PARA DECIMALES
                        
                        // validacion de tipos
                        if (!reglas.tiposDatosCompatiblesAsigancion(variable, terminoLiteral)) {
                            throw new SemanticError(variable.getTipoDato(), ((Terminal) terminoLiteral.getTerminoLiteral()).getLexema().getTipoLexema(), ((Terminal) terminoLiteral.getTerminoLiteral()).getLexema().getLinea());
                        }
                        
                        variable.setValor(((LiteralNumerico) terminoLiteral.getTerminoLiteral()).getParteEntera());
                        flujoSentencia.añadirVariable(variable);
                    }
                }
            }

        }

        return true;
    }
}
