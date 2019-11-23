/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias;

import analizadorLexico_modelo.Lexema;
import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pepe
 */
public class EntradaTeclado extends Sentencia{
    
    private Lexema identificador;

    public EntradaTeclado() {
    }

    public Lexema getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Lexema identificador) {
        this.identificador = identificador;
    }
       
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (identificador != null) {
            hijos.add(new Terminal(identificador)); 
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        str.append("\t    ").append(identificador.getLexema());
        str.append(" = ");
        str.append("prompt();");
        return str.toString();
    }

    @Override
    public String toString() {
        return "Entrada de teclado";
    }
    
}
