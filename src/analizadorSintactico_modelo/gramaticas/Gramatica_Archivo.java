/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.gramaticas;

import analizadorSintactico_modelo.FlujoLexema;
import analizadorSintactico_modelo.Gramatica;
import analizadorSintactico_modelo.Sentencia;
import analizadorSintactico_modelo.SintacticException;
import analizadorSintactico_modelo.sentencias.Archivo;
import analizadorSintactico_modelo.sentencias.Main;
import analizadorSintactico_modelo.sentencias.Metodo;

/**
 *
 * @author Pepe
 */
public class Gramatica_Archivo implements Gramatica{

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {        
        Gramatica_Main gramaticaMain = new Gramatica_Main();
        Gramatica_Metodo gramaticaMetodo = new Gramatica_Metodo();
        
        Archivo archivo = new Archivo();        
        
        do {
            if (flujoLexema.posicionFinal()){
                break;
            }
            
            Main main = (Main) gramaticaMain.analizar(flujoLexema);
            if (main != null){
                if (archivo.getMain() == null){
                    archivo.setMain(main);
                    continue;
                } else {
                    throw new SintacticException("Error sintactico: Solo se puede definir un metodo main");
                }
            }
            
            Metodo metodo = (Metodo) gramaticaMetodo.analizar(flujoLexema);
            if (metodo != null){
                archivo.getListaMetodos().add(metodo);
                continue;
            }
            
            break;
        } while(true);
        
        if (archivo.getMain() == null) {
            throw new SintacticException("Error sintactico: Falta definir el metodo main");
        }
        
        return archivo;
    }
    
}
