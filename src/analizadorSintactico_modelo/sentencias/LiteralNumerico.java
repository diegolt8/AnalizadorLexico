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
public class LiteralNumerico extends Sentencia {

    private Lexema signo;
    private Lexema parteEntera;
    private Lexema parteDecimal;

    public LiteralNumerico() {
    }

    public Lexema getSigno() {
        return signo;
    }

    public void setSigno(Lexema signo) {
        this.signo = signo;
    }

    public Lexema getParteEntera() {
        return parteEntera;
    }

    public void setParteEntera(Lexema parteEntera) {
        this.parteEntera = parteEntera;
    }

    public Lexema getParteDecimal() {
        return parteDecimal;
    }

    public void setParteDecimal(Lexema parteDecimal) {
        this.parteDecimal = parteDecimal;
    }   
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (signo != null) {
            hijos.add(new Terminal(signo));
        }
        
        hijos.add(new Terminal(parteEntera));
        
        if (parteDecimal != null) {
            hijos.add(new Terminal(parteDecimal));
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Literal numerico";
    }
    
}
