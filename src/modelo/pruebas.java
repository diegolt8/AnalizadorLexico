/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pepe
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] lexema = {':','+'};
        FlujoCaracteres flujo = new FlujoCaracteres(0, lexema, 0, 0);
        Automata_Operador_Especial aul = new Automata_Operador_Especial();
        Lexema lexem = aul.ejecutarAutomata(flujo);
        if(lexem != null){
            System.out.println(lexem.getToken() + " - Tipo: "+ lexem.getTipoLexema());
        } else {
            System.out.println("Error Lexico");
        }
    }
    
}
