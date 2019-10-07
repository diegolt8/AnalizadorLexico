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
import analizadorSintactico_modelo.sentencias.DeclaracionVariable;
import analizadorSintactico_modelo.sentencias.DeclaranteVariable;
import analizadorSintactico_modelo.sentencias.EntradaTeclado;
import analizadorSintactico_modelo.sentencias.Hacer;
import analizadorSintactico_modelo.sentencias.ImprimirConsola;
import analizadorSintactico_modelo.sentencias.ListaSentencias;
import analizadorSintactico_modelo.sentencias.Mientras;
import analizadorSintactico_modelo.sentencias.Para;
import analizadorSintactico_modelo.sentencias.ParaCada;
import analizadorSintactico_modelo.sentencias.PeticionHTTP;
import analizadorSintactico_modelo.sentencias.Si;

/**
 *
 * @author Pepe
 */
public class Gramatica_ListaSentencias implements Gramatica {

    @Override
    public Sentencia analizar(FlujoLexema flujoLexema) {
        
        Gramatica_DeclaracionVariable gramaticaDeclaracionVariable = new Gramatica_DeclaracionVariable();
        Gramatica_DeclaranteVariable gramaticaDeclaranteVariable = new Gramatica_DeclaranteVariable();
        Gramatica_Para gramaticaPara = new Gramatica_Para();
        Gramatica_Si gramaticaSi = new Gramatica_Si();
        Gramatica_ParaCada gramaticaParaCada = new Gramatica_ParaCada();
        Gramatica_Hacer gramaticaHacer = new Gramatica_Hacer();
        Gramatica_Mientras gramaticaMientras = new Gramatica_Mientras();
        Gramatica_ImprimirConsola gramaticaImprimirConsola = new Gramatica_ImprimirConsola();
        Gramatica_EntradaTeclado gramaticaEntradaTeclado = new Gramatica_EntradaTeclado();
        Gramatica_PeticionHTTP gramaticaPeticionHTTP = new Gramatica_PeticionHTTP();
        
        ListaSentencias<Sentencia> listaSentencias = new ListaSentencias<>();
        flujoLexema.guardarPosicion();
        
        DeclaracionVariable declaracionVariable;
        DeclaranteVariable declaranteVariable;
        Si si;
        Para para;
        ParaCada paraCada;
        Hacer hacer;
        Mientras mientras;
        ImprimirConsola imprimirConsola;
        EntradaTeclado entradaTeclado;
        PeticionHTTP peticionHTTP;
        
        do {            
            if (flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.COMILLA_DOBLE || flujoLexema.getLexema().getTipoLexema() == TipoLexemaEnum.VLR_RETORNO) {
                break;
            }                 
            
            si = (Si) gramaticaSi.analizar(flujoLexema);
            if (si != null) {
                listaSentencias.add(si);
                flujoLexema.guardarPosicion();
                continue;
            }
            flujoLexema.backTrack();
            
            para = (Para) gramaticaPara.analizar(flujoLexema);
            if (para != null) {
                listaSentencias.add(para);
                flujoLexema.guardarPosicion();
                continue;
            }
            flujoLexema.backTrack();

            paraCada = (ParaCada) gramaticaParaCada.analizar(flujoLexema);
            if (paraCada != null) {
                listaSentencias.add(paraCada);
                flujoLexema.guardarPosicion();
                continue;
            }
            flujoLexema.backTrack();            
            
            hacer = (Hacer) gramaticaHacer.analizar(flujoLexema);
            if (hacer != null) {
                listaSentencias.add(hacer);                
                if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO_Y_COMA) {
                    throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO_Y_COMA);
                }
                flujoLexema.avanzar();
                flujoLexema.guardarPosicion();
                continue;
            }
            flujoLexema.backTrack();  
            
            mientras = (Mientras) gramaticaMientras.analizar(flujoLexema);
            if (mientras != null) {
                listaSentencias.add(mientras);
                flujoLexema.guardarPosicion();
                continue;
            }
            flujoLexema.backTrack(); 
            
            imprimirConsola = (ImprimirConsola) gramaticaImprimirConsola.analizar(flujoLexema);
            if (imprimirConsola != null) {
                listaSentencias.add(imprimirConsola);                
                if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO_Y_COMA) {
                    throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO_Y_COMA);
                }
                flujoLexema.avanzar();
                flujoLexema.guardarPosicion();
                continue;
            }
            flujoLexema.backTrack(); 
            
            entradaTeclado = (EntradaTeclado) gramaticaEntradaTeclado.analizar(flujoLexema);
            if (entradaTeclado != null) {
                listaSentencias.add(entradaTeclado);                
                if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO_Y_COMA) {
                    throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO_Y_COMA);
                }
                flujoLexema.avanzar();
                flujoLexema.guardarPosicion();
                continue;
            }
            flujoLexema.backTrack(); 
            
            peticionHTTP = (PeticionHTTP) gramaticaPeticionHTTP.analizar(flujoLexema);
            if (peticionHTTP != null) {
                listaSentencias.add(peticionHTTP);                
                if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO_Y_COMA) {
                    throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO_Y_COMA);
                }
                flujoLexema.avanzar();
                flujoLexema.guardarPosicion();
                continue;
            }
            flujoLexema.backTrack();  
            
            declaracionVariable = (DeclaracionVariable) gramaticaDeclaracionVariable.analizar(flujoLexema);
            if (declaracionVariable != null) {
                listaSentencias.add(declaracionVariable);
                if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO_Y_COMA) {
                    throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO_Y_COMA);
                }
                flujoLexema.avanzar();
                flujoLexema.guardarPosicion();
                continue;
            } 
            flujoLexema.backTrack();
            
            declaranteVariable = (DeclaranteVariable) gramaticaDeclaranteVariable.analizar(flujoLexema);
            if (declaranteVariable != null) {
                listaSentencias.add(declaranteVariable);
                if (flujoLexema.getLexema().getTipoLexema() != TipoLexemaEnum.PUNTO_Y_COMA) {
                    throw new SintacticException(flujoLexema.getLexema(), TipoLexemaEnum.PUNTO_Y_COMA);
                }
                flujoLexema.avanzar();
                flujoLexema.guardarPosicion();
                continue;
            } 
            flujoLexema.backTrack();     
            
            break;
        } while (true);       
        return listaSentencias;
    }
    
}
   