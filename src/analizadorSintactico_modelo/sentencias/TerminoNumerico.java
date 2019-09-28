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
public class TerminoNumerico extends Sentencia {

    private Lexema signo;
    private LiteralNumerico literalNuerico;
    private Lexema identificador;
    private Lexema operadorEspecial;

    public TerminoNumerico() {
    }

    public Lexema getSigno() {
        return signo;
    }

    public void setSigno(Lexema signo) {
        this.signo = signo;
    }

    public LiteralNumerico getLiteralNuerico() {
        return literalNuerico;
    }

    public void setLiteralNuerico(LiteralNumerico literalNuerico) {
        this.literalNuerico = literalNuerico;
    }

    public Lexema getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Lexema identificador) {
        this.identificador = identificador;
    }

    public Lexema getOperadorEspecial() {
        return operadorEspecial;
    }

    public void setOperadorEspecial(Lexema operadorEspecial) {
        this.operadorEspecial = operadorEspecial;
    }
    
    
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (signo != null) {
            hijos.add(new Terminal(signo));
        }
        
        if (literalNuerico != null) {
            hijos.add(literalNuerico);
        }
        
        if (identificador != null) {
            hijos.add(new Terminal(identificador));
        }
        
        if (operadorEspecial != null) {
            hijos.add(new Terminal(operadorEspecial));
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "terminoNumerico";
    }
    
}
