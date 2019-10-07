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
import analizadorSintactico_modelo.sentencias.DeclaranteVariable;
import analizadorSintactico_modelo.sentencias.InicializadorVariable;

/**
 *
 * @author Pepe
 */
public class Gramatica_DeclaranteVariable implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_InicializadorVariable gramaticaInicializadorVariable = new Gramatica_InicializadorVariable();
        
        DeclaranteVariable declaranteVariable = new DeclaranteVariable();
     
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.IDENTIFICADOR) {
            return null;
        }
        declaranteVariable.setIdentificador(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_ASIG_IGUAL && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_ASIG_DIVISION &&
            flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_ASIG_MULTIPLICACION && flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_ASIG_RESTA &&
            flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.OPE_ASIG_SUMA) {
            return declaranteVariable;
        }
        declaranteVariable.setOperadorAsignacion(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        InicializadorVariable inicializadorVariable = (InicializadorVariable) gramaticaInicializadorVariable.analizar(flujoLexema);
        if (inicializadorVariable == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.INICIALIZADOR_VARIABLE);
        }
        declaranteVariable.setInicializadorVariable(inicializadorVariable);
        
        return declaranteVariable;
    }
    
}
