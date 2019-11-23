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
import analizadorSintactico_modelo.sentencias.ImprimirConsola;

/**
 *
 * @author Pepe
 */
public class ComprobacionSemantica_Imprimir implements ComprobacionSemantica {

    @Override
    public boolean comprobacionSemantica(FlujoSentencias flujoSentencia) {
        
        ReglasSemanticas reglas = new ReglasSemanticas();
        
        ImprimirConsola imprimir = (ImprimirConsola) flujoSentencia.getNodoActual();
        Lexema lexema = imprimir.getIdentificador();
        
        if (lexema != null) {
            // validacion de que el indentificador exista
            if (!reglas.unicidadNombreVariable(flujoSentencia.getListaVariables(), lexema.getLexema())) {
                throw new SemanticError(lexema.getLexema(), true, lexema.getLinea());
            }

            // validacion de que el identificadaor este inicializado
            if (reglas.variableInicializada(flujoSentencia.getListaVariables(), lexema.getLexema())) {
                throw new SemanticError(lexema.getLexema(), lexema.getLinea());
            }
        }
        
        return true;
    }
    
}
