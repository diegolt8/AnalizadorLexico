/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo.comprobacionSemantica;

import analizadorLexico_modelo.TipoLexemaEnum;
import analizadorSemantico_modelo.ComprobacionSemantica;
import analizadorSemantico_modelo.FlujoSentencias;
import analizadorSemantico_modelo.ReglasSemanticas;
import analizadorSemantico_modelo.SemanticError;
import analizadorSemantico_modelo.VariablesContexto;
import analizadorSintactico_modelo.sentencias.FactorNumerico;

/**
 *
 * @author Pepe
 */
public class ComprobacionSemantica_FactorNumerico implements ComprobacionSemantica {

    @Override
    public boolean comprobacionSemantica(FlujoSentencias flujoSentencia) {

        ComprobacionSemantica_ExpresionNumerica comprobacionExpresionNumerica = new ComprobacionSemantica_ExpresionNumerica();

        ReglasSemanticas reglas = new ReglasSemanticas();

        FactorNumerico factorNumerico = (FactorNumerico) flujoSentencia.getNodoActual();
        if (factorNumerico.getIdentificador() != null) {
            // validacion de que el indentificador exista
            if (!reglas.unicidadNombreVariable(flujoSentencia.getListaVariables(), factorNumerico.getIdentificador().getLexema())) {
                throw new SemanticError(factorNumerico.getIdentificador().getLexema(), true, factorNumerico.getIdentificador().getLinea());
            }

            // validacion de que el identificadaor este inicializado
            if (reglas.variableInicializada(flujoSentencia.getListaVariables(), factorNumerico.getIdentificador().getLexema())) {
                throw new SemanticError(factorNumerico.getIdentificador().getLexema(), factorNumerico.getIdentificador().getLinea());
            }
            
            VariablesContexto variable = flujoSentencia.buscarVariable(factorNumerico.getIdentificador().getLexema());
            if (variable.getTipoDato() != TipoLexemaEnum.TIPO_DATO_ENT) {
                throw new SemanticError(variable.getTipoDato(), TipoLexemaEnum.TIPO_DATO_ENT, factorNumerico.getIdentificador().getLinea());
            }
        }
        if (factorNumerico.getExpresionNumerica() != null) {
            flujoSentencia.setNodoActual(factorNumerico.getExpresionNumerica());
            comprobacionExpresionNumerica.comprobacionSemantica(flujoSentencia);
        }

        return true;
    }

}
