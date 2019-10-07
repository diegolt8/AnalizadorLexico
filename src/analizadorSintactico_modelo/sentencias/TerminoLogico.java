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
public class TerminoLogico extends Sentencia {

    private Lexema literalCadena1, literalCadena2;
    private ExpresionNumerica expresionNumerica1, expresionNumerica2;
    private Lexema operadorRelacional;
    private Lexema negacion;
    private Lexema parentesisAbierto, parentesisCerrado;
    private ExpresionLogica expresionLogica;
    private Lexema valorLogico;

    public TerminoLogico() {
    }

    public Lexema getLiteralCadena1() {
        return literalCadena1;
    }

    public void setLiteralCadena1(Lexema literalCadena1) {
        this.literalCadena1 = literalCadena1;
    }

    public Lexema getLiteralCadena2() {
        return literalCadena2;
    }

    public void setLiteralCadena2(Lexema literalCadena2) {
        this.literalCadena2 = literalCadena2;
    }

    public ExpresionNumerica getExpresionNumerica1() {
        return expresionNumerica1;
    }

    public void setExpresionNumerica1(ExpresionNumerica expresionNumerica1) {
        this.expresionNumerica1 = expresionNumerica1;
    }

    public ExpresionNumerica getExpresionNumerica2() {
        return expresionNumerica2;
    }

    public void setExpresionNumerica2(ExpresionNumerica expresionNumerica2) {
        this.expresionNumerica2 = expresionNumerica2;
    }

    public Lexema getOperadorRelacional() {
        return operadorRelacional;
    }

    public void setOperadorRelacional(Lexema operadorRelacional) {
        this.operadorRelacional = operadorRelacional;
    }

    public Lexema getNegacion() {
        return negacion;
    }

    public void setNegacion(Lexema negacion) {
        this.negacion = negacion;
    }

    public Lexema getParentesisAbierto() {
        return parentesisAbierto;
    }

    public void setParentesisAbierto(Lexema parentesisAbierto) {
        this.parentesisAbierto = parentesisAbierto;
    }

    public Lexema getParentesisCerrado() {
        return parentesisCerrado;
    }

    public void setParentesisCerrado(Lexema parentesisCerrado) {
        this.parentesisCerrado = parentesisCerrado;
    }

    public ExpresionLogica getExpresionLogica() {
        return expresionLogica;
    }

    public void setExpresionLogica(ExpresionLogica expresionLogica) {
        this.expresionLogica = expresionLogica;
    }

    public Lexema getValorLogico() {
        return valorLogico;
    }

    public void setValorLogico(Lexema valorLogico) {
        this.valorLogico = valorLogico;
    }  
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (literalCadena1 != null) {
            hijos.add(new Terminal(literalCadena1));
        }
        
        if (expresionNumerica1 != null) {
            hijos.add(expresionNumerica1);
        }
        
        if (operadorRelacional != null) {
            hijos.add(new Terminal(operadorRelacional));
        }
        
        if (literalCadena2 != null) {
            hijos.add(new Terminal(literalCadena2));
        }
        
        if (expresionNumerica2 != null) {
            hijos.add(expresionNumerica2);
        }
        
        if (negacion != null) {
            hijos.add(new Terminal(negacion));
        }

        if (valorLogico != null) {
            hijos.add(new Terminal(valorLogico));
        }
        
        if (parentesisAbierto != null) {
            hijos.add(new Terminal(parentesisAbierto));
        }
        
        if (expresionLogica != null) {
            hijos.add(expresionLogica);
        }
        
        if (parentesisCerrado != null) {
            hijos.add(new Terminal(parentesisCerrado));
        }
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Termino Relacional";
    }
    
}
