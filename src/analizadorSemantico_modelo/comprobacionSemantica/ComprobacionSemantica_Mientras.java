/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo.comprobacionSemantica;

import analizadorSemantico_modelo.ComprobacionSemantica;
import analizadorSemantico_modelo.FlujoSentencias;
import analizadorSemantico_modelo.ReglasSemanticas;
import analizadorSintactico_modelo.Sentencia;
import analizadorSintactico_modelo.sentencias.ListaSentencias;
import analizadorSintactico_modelo.sentencias.Mientras;

/**
 *
 * @author Pepe
 */
public class ComprobacionSemantica_Mientras implements ComprobacionSemantica {

    @Override
    public boolean comprobacionSemantica(FlujoSentencias flujoSentencia) {
        ComprobacionSemantica_ExpresionLogica comprobacionExpresionLogica = new ComprobacionSemantica_ExpresionLogica();
        ComprobacionSemantica_DeclaracionVariable a = new ComprobacionSemantica_DeclaracionVariable();
        ComprobacionSemantica_DeclaranteVariable b = new ComprobacionSemantica_DeclaranteVariable();
        ComprobacionSemantica_Si c = new ComprobacionSemantica_Si();
        ComprobacionSemantica_Para d = new ComprobacionSemantica_Para();
        ComprobacionSemantica_Hacer e = new ComprobacionSemantica_Hacer();
        ComprobacionSemantica_Mientras f = new ComprobacionSemantica_Mientras();

        Mientras mientras = (Mientras) flujoSentencia.getNodoActual();
        ListaSentencias<Sentencia> listaSentencia = mientras.getListaSentencias();
        ReglasSemanticas reglasSemanticas = new ReglasSemanticas();
        
        flujoSentencia.setNodoActual(mientras.getExpresionLogica());
        comprobacionExpresionLogica.comprobacionSemantica(flujoSentencia);

        flujoSentencia.aumentarContexto();
        //ciclo para las sentencias aumentando el contexto
        for (Sentencia sentencia : listaSentencia.getSentencias()) {
            if (reglasSemanticas.nombreClase(sentencia).equals("DeclaracionVariable")) {
                flujoSentencia.setNodoActual(sentencia);
                a.comprobacionSemantica(flujoSentencia);
            }
            if (reglasSemanticas.nombreClase(sentencia).equals("DeclaranteVariable")) {
                flujoSentencia.setNodoActual(sentencia);
                b.comprobacionSemantica(flujoSentencia);
            }
            if (reglasSemanticas.nombreClase(sentencia).equals("Si")) {
                flujoSentencia.setNodoActual(sentencia);
                c.comprobacionSemantica(flujoSentencia);
            }
            if (reglasSemanticas.nombreClase(sentencia).equals("Para")) {
                flujoSentencia.setNodoActual(sentencia);
                d.comprobacionSemantica(flujoSentencia);
            }
            if (reglasSemanticas.nombreClase(sentencia).equals("Hacer")) {
                flujoSentencia.setNodoActual(sentencia);
                e.comprobacionSemantica(flujoSentencia);
            }
            if (reglasSemanticas.nombreClase(sentencia).equals("Mientras")) {
                flujoSentencia.setNodoActual(sentencia);
                f.comprobacionSemantica(flujoSentencia);
            }
        }
        //terminado el ciclo eliminar las variables de dicho contexto y restar en el flujo 1     
        flujoSentencia.limpiarContexto();
        flujoSentencia.disminuirContexto();
        return true;
    }

}
