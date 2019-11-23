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
public class ImprimirConsola extends Sentencia {

    private Sentencia expresion;
    private Lexema identificador;

    public ImprimirConsola() {
    }

    public Lexema getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Lexema identificador) {
        this.identificador = identificador;
    }

    public Sentencia getExpresion() {
        return expresion;
    }

    public void setExpresion(Sentencia expresion) {
        this.expresion = expresion;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (expresion != null) {
            hijos.add(expresion);
        }
        
        if (identificador != null) {
            hijos.add(new Terminal(identificador));
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        str.append("console.log").append("(");
        if (expresion != null) {
            str.append(expresion.parse());
        }
        if (identificador != null) {
            str.append(identificador.getLexema());
        }
        str.append(")").append(";");
        return str.toString();
    }

    @Override
    public String toString() {
        return "Imprimir en consola";
    }
    
}
