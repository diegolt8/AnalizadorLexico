/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_controlador;

import analizadorSemantico_modelo.FlujoSentencias;
import analizadorSemantico_modelo.comprobacionSemantica.ComprobacionSemantica_Archivo;
import analizadorSintactico_modelo.Sentencia;

/**
 *
 * @author Pepe
 */
public class AnalizadorSemantico {

    public AnalizadorSemantico() {
    }
    
    public boolean analizar(Sentencia nodoPadre) {
        FlujoSentencias flujoSentencia = new FlujoSentencias(nodoPadre);
        
        ComprobacionSemantica_Archivo archivo = new ComprobacionSemantica_Archivo();
       
        return archivo.comprobacionSemantica(flujoSentencia);
    }
    
}
