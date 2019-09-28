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
import analizadorSintactico_modelo.sentencias.ListaParametros;
import analizadorSintactico_modelo.sentencias.Parametro;

/**
 *
 * @author Pepe
 */
public class Gramatica_ListaParametros implements Gramatica{

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_Parametro gramaticaParametro = new Gramatica_Parametro();
        Parametro parametro;        
        
        ListaParametros<Parametro> listaParamentros = new ListaParametros<>();
        flujoLexema.guardarPosicion();    
            
        
        parametro = (Parametro) gramaticaParametro.analizar(flujoLexema);
        if (parametro == null) {
            return listaParamentros;
        }
        listaParamentros.add(parametro);
        
        do {
            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMA) {
                break;
            }
            flujoLexema.avanzar();
            
            parametro = (Parametro) gramaticaParametro.analizar(flujoLexema);
            if (parametro == null) {
                // error lexico
                flujoLexema.backTrack();
                return null;
            }
            listaParamentros.add(parametro);  
        } while (true);
        
        return listaParamentros;
    }
}
