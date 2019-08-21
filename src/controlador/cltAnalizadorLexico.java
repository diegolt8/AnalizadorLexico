/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.ErrorLexico;
import modelo.FlujoCaracteres;
import modelo.Lexema;
import modelo.automatas.Automatas;

/**
 *
 * @author diegoul818
 */
public class cltAnalizadorLexico {

    private ArrayList<Lexema> listaLexemas;
    private ArrayList<ErrorLexico> listaErrorLexico;
    private Automatas automata;

    public void instanciarClases() {
        listaLexemas = new ArrayList<>();
        listaErrorLexico = new ArrayList<>();
        automata = new Automatas();
    }

    public void analizadorLexico(FlujoCaracteres flujoC) {
        instanciarClases();
        Lexema lexema;
        FlujoCaracteres flujo = flujoC;
        while (flujo.getPosicionActual() < flujo.getCantidadCaracteres()) {
            if (flujo.getCaracter() == 10) {
                flujo.siguienteFila();
                flujo.setColumna(1);
                flujo.moverAdelante();
                continue;
            } else if (flujo.getCaracter() == 32) {
                flujo.siguienteColumna();
                flujo.moverAdelante();
                continue;
            }

            lexema = automata.automataIdentificador(flujo);
            if (lexema != null) {
                System.out.println(lexema.getLexema() + " - Tipo: " + lexema.getTipoLexema() + " - Token: " + lexema.getToken() + " - fila: " + lexema.getLinea() + " - columna: " + lexema.getColumna());
                continue;
            } else {
                System.out.println("error");
            }
            lexema = automata.automataDelimitador(flujo);
            if (lexema != null) {
                System.out.println(lexema.getLexema() + " - Tipo: " + lexema.getTipoLexema() + " - Token: " + lexema.getToken() + " - fila: " + lexema.getLinea() + " - columna: " + lexema.getColumna());
            } else {
                System.out.println("Error Lexico");
            }
        }

    }
}
