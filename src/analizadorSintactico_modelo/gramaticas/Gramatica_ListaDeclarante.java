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
import analizadorSintactico_modelo.sentencias.DeclaranteVariable;
import analizadorSintactico_modelo.sentencias.ListaDeclarante;

/**
 *
 * @author Pepe
 */
public class Gramatica_ListaDeclarante implements Gramatica{

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_DeclaranteVariable gramaticaDeclaranteVariable = new Gramatica_DeclaranteVariable();
        
        ListaDeclarante<DeclaranteVariable> listaDeclarantes = new ListaDeclarante<>();
        DeclaranteVariable declaranteVariable;
        
        declaranteVariable = (DeclaranteVariable) gramaticaDeclaranteVariable.analizar(flujoLexema);
        if (declaranteVariable == null){
            return listaDeclarantes;
        }
        listaDeclarantes.add(declaranteVariable);        
        
        do {            
            if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.COMA) {
                break;
            }
            flujoLexema.avanzar();
            
            declaranteVariable = (DeclaranteVariable) gramaticaDeclaranteVariable.analizar(flujoLexema);
            if (declaranteVariable == null) {
                throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.DECLARANTE); 
            }
            listaDeclarantes.add(declaranteVariable);  
            
            break;
        } while (true);
        
        return listaDeclarantes;
    }
    
}
