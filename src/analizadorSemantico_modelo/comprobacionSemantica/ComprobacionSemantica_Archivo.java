/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo.comprobacionSemantica;

import analizadorSemantico_modelo.ComprobacionSemantica;
import analizadorSemantico_modelo.FlujoSentencias;
import analizadorSemantico_modelo.MetodosContexto;
import analizadorSemantico_modelo.ReglasSemanticas;
import analizadorSemantico_modelo.SemanticError;
import analizadorSemantico_modelo.VariablesContexto;
import analizadorSintactico_modelo.sentencias.Archivo;
import analizadorSintactico_modelo.sentencias.ListaMetodos;
import analizadorSintactico_modelo.sentencias.ListaParametros;
import analizadorSintactico_modelo.sentencias.Metodo;
import analizadorSintactico_modelo.sentencias.Parametro;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public class ComprobacionSemantica_Archivo implements ComprobacionSemantica {

    @Override
    public boolean comprobacionSemantica(FlujoSentencias flujoSentencia) {

        ReglasSemanticas reglas = new ReglasSemanticas();
        
        ComprobacionSemantica_Main comprobacionMain = new ComprobacionSemantica_Main();
        ComprobacionSemantica_Metodo comprobacionMetodo = new ComprobacionSemantica_Metodo(); 
        
        Archivo archivo = (Archivo) flujoSentencia.getNodoActual();
        ListaMetodos<Metodo> listaMetodos = archivo.getListaMetodos();        

        if (!listaMetodos.getMetodos().isEmpty()) {
            for (Metodo metodo : listaMetodos.getMetodos()) {
                MetodosContexto metodoContexto = new MetodosContexto();
                ArrayList<VariablesContexto> listaParametros = new ArrayList<>();
                
                metodoContexto.setNombre(metodo.getNombreMetodo().getLexema());
                ListaParametros<Parametro> Parametros = metodo.getListaParametros();
                for (Parametro parametro : Parametros.getParametros()) {
                    VariablesContexto paramContex = new VariablesContexto(parametro.getNombreParametro().getLexema(), parametro.getTipoDato().getTipoLexema());
                    if (reglas.unicidadNombreParametro(listaParametros, paramContex.getNombre())) {
                        throw new SemanticError(paramContex.getNombre(), 0, metodo.getNombreMetodo().getLinea());
                    }
                    listaParametros.add(paramContex);
                }  
                metodoContexto.setListaParametros(listaParametros);
                if (reglas.unicidadNombreMetodo(flujoSentencia.getListaMetodos(), metodo.getNombreMetodo().getLexema())) {
                   throw new SemanticError(metodo.getNombreMetodo().getLexema(), 1, metodo.getNombreMetodo().getLinea());
                }
                flujoSentencia.añadirMetodo(metodoContexto);
            }
        }

        flujoSentencia.setNodoActual(archivo.getMain());
        comprobacionMain.comprobacionSemantica(flujoSentencia);
        
        for (Metodo metodo : listaMetodos.getMetodos()) {
            flujoSentencia.setNodoActual(metodo);
            comprobacionMetodo.comprobacionSemantica(flujoSentencia);
        }
        
        return true;
    }
    
}
