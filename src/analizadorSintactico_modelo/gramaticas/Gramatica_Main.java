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
import analizadorSintactico_modelo.sentencias.ListaSentencias;
import analizadorSintactico_modelo.sentencias.Main;


/**
 *
 * @author Pepe
 */
public class Gramatica_Main implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_ListaSentencias gramaticaListaSentencias = new Gramatica_ListaSentencias();
        
        flujoLexema.guardarPosicion();
        Main main = new Main();

        if (flujoLexema.posicionFinal()) {
            return null;
        }
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PR_MAIN) {
            return null;
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE);
        }
        flujoLexema.avanzar();

        ListaSentencias<Sentencia> listaSentencias = (ListaSentencias<Sentencia>) gramaticaListaSentencias.analizar(flujoLexema);
        main.setListaSentencia(listaSentencias);

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VLR_RETORNO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.VLR_RETORNO);
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VALOR_NUMERICO && flujoLexema.getLexema().getLexema().equals("0")) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.VALOR_NUMERICO);
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO_Y_COMA) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO_Y_COMA);
        }
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE);
        }
        flujoLexema.avanzar();
        return main;
    }

}
