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
import analizadorSintactico_modelo.sentencias.PeticionHTTP;
import analizadorSintactico_modelo.sentencias.VerboHTTP;

/**
 *
 * @author Pepe
 */
public class Gramatica_PeticionHTTP implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_VerboHTTP gramaticaVerboHTTP = new Gramatica_VerboHTTP();
        
        PeticionHTTP peticionHTTP = new PeticionHTTP();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.IDENTIFICADOR) {
            return null;
        }
        peticionHTTP.setIdentificador(flujoLexema.getLexema());
        flujoLexema.avanzar();
        
        if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO) {
            return null;
        }
        flujoLexema.avanzar();
        
        VerboHTTP verboHTTP = (VerboHTTP) gramaticaVerboHTTP.analizar(flujoLexema);
        if (verboHTTP == null) {
            throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.VERBO_HTTP);
        }
        peticionHTTP.setVerboHTTP(verboHTTP);
        
        return peticionHTTP;
    }
    
}
