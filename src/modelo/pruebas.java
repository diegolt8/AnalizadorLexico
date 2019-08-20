/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.automatas.Automata_Identificador;

/**
 *
 * @author Pepe
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] lexema = {'e','2',' ',' '};
        FlujoCaracteres flujo = new FlujoCaracteres(0, lexema, 0, 0);
        Automata_Identificador aul = new Automata_Identificador();
        Lexema lexem = aul.ejecutarAutomata(flujo);
        if(lexem != null){
            System.out.println(lexem.getLexema()+ " - Tipo: "+ lexem.getTipoLexema()+" - Token: "+lexem.getToken());
        } else {
            System.out.println("Error Lexico");
        }        
    }
}