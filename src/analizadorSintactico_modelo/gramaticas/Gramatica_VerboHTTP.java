/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.gramaticas;

import analizadorSintactico_modelo.FlujoLexema;
import analizadorSintactico_modelo.Gramatica;
import analizadorSintactico_modelo.Sentencia;
import analizadorSintactico_modelo.sentencias.HTTPConsultar;
import analizadorSintactico_modelo.sentencias.HTTPCrear;
import analizadorSintactico_modelo.sentencias.HTTPEliminar;
import analizadorSintactico_modelo.sentencias.HTTPModificar;
import analizadorSintactico_modelo.sentencias.VerboHTTP;

/**
 *
 * @author Pepe
 */
public class Gramatica_VerboHTTP implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_HTTPConsultar gramaticaHTTPConsultar = new Gramatica_HTTPConsultar();
        Gramatica_HTTPCrear gramaticaHTTPCrear = new Gramatica_HTTPCrear();
        Gramatica_HTTPEliminar gramaticaHTTPEliminar = new Gramatica_HTTPEliminar();
        Gramatica_HTTPModificar gramaticaHTTPModificar = new Gramatica_HTTPModificar();
        
        VerboHTTP verboHTTP = new VerboHTTP();
        
        flujoLexema.guardarPosicion();
        
        HTTPConsultar httpConsultar = (HTTPConsultar) gramaticaHTTPConsultar.analizar(flujoLexema);
        if (httpConsultar != null) {
            verboHTTP.setVerboHTTP(httpConsultar);
            return verboHTTP;
        }
        flujoLexema.backTrack();
        
        HTTPCrear httpCrear = (HTTPCrear) gramaticaHTTPCrear.analizar(flujoLexema);
        if (httpCrear != null) {
            verboHTTP.setVerboHTTP(httpCrear);
            return verboHTTP;
        }
        flujoLexema.backTrack();
        
        HTTPEliminar httpEliminar = (HTTPEliminar) gramaticaHTTPEliminar.analizar(flujoLexema);
        if (httpEliminar != null) {
            verboHTTP.setVerboHTTP(httpEliminar);
            return verboHTTP;
        }
        flujoLexema.backTrack();
        
        HTTPModificar httpModificar = (HTTPModificar) gramaticaHTTPModificar.analizar(flujoLexema);
        if (httpModificar != null) {
            verboHTTP.setVerboHTTP(httpModificar);
            return verboHTTP;
        }
        flujoLexema.backTrack();
        
        return null;
    }
    
}
