/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_controlador;

import analizadorLexico_modelo.Lexema;
import analizadorSintactico_modelo.FlujoLexema;
import analizadorSintactico_modelo.gramaticas.Gramatica_Archivo;
import analizadorSintactico_modelo.sentencias.Archivo;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public class AnalizadorSintactico {
    
    private Archivo archivo;     
    
    public void analisar(ArrayList<Lexema> listaLexemas){
        FlujoLexema flujoLexemas = new FlujoLexema(listaLexemas);
        Gramatica_Archivo gramaticaArchivo = new Gramatica_Archivo();
        
        archivo = (Archivo) gramaticaArchivo.analizar(flujoLexemas);
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }
    
    
    
}
