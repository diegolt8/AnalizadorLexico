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
import analizadorSintactico_modelo.sentencias.Main;
import analizadorSintactico_modelo.sentencias.medios.ListaSentencia;

/**
 *
 * @author Pepe
 */
public class Gramatica_Main implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {

        flujoLexema.guardarPosicion();
        Main main = new Main();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PR_MAIN) {
            return null;
        }
        flujoLexema.avanzar();

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_ABIERTO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_ABIERTO);
        }

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PARENTESIS_CERRADO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PARENTESIS_CERRADO);
        }

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE);
        }

        ListaSentencia<Sentencia> listasentencia = (ListaSentencia) new GramaticaSentencia().analizar(flujoLexema);

        if (!listasentencia.getSentencias().isEmpty()) {
            main.setListaSentencia(listasentencia);
            flujoLexema.avanzar();
        }

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.VLR_RETORNO) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.VLR_RETORNO);
        }

        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMILLA_DOBLE) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.COMILLA_DOBLE);
        }
        return null;
    }

}
