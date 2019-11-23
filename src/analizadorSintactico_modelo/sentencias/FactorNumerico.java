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
public class FactorNumerico extends Sentencia {

    private Lexema negativo;
    private LiteralNumerico literalNumerico;
    private Lexema identificador;
    private Lexema operadorEspecial;
    private Lexema parentesisAbierto;
    private ExpresionNumerica expresionNumerica;
    private Lexema parentesisCerrado;

    public FactorNumerico() {
    }

    public Lexema getNegativo() {
        return negativo;
    }

    public void setNegativo(Lexema negativo) {
        this.negativo = negativo;
    }

    public LiteralNumerico getLiteralNumerico() {
        return literalNumerico;
    }

    public void setLiteralNumerico(LiteralNumerico literalNumerico) {
        this.literalNumerico = literalNumerico;
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

    public Lexema getParentesisAbierto() {
        return parentesisAbierto;
    }

    public void setParentesisAbierto(Lexema parentesisAbierto) {
        this.parentesisAbierto = parentesisAbierto;
    }

    public ExpresionNumerica getExpresionNumerica() {
        return expresionNumerica;
    }

    public void setExpresionNumerica(ExpresionNumerica expresionNumerica) {
        this.expresionNumerica = expresionNumerica;
    }

    public Lexema getParentesisCerrado() {
        return parentesisCerrado;
    }

    public void setParentesisCerrado(Lexema parentesisCerrado) {
        this.parentesisCerrado = parentesisCerrado;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        if (negativo != null) {
            hijos.add(new Terminal(negativo));
        }

        if (literalNumerico != null) {
            hijos.add(literalNumerico);
        }

        if (identificador != null) {
            hijos.add(new Terminal(identificador));
        }

        if (operadorEspecial != null) {
            hijos.add(new Terminal(operadorEspecial));
        }

        if (parentesisAbierto != null) {
            hijos.add(new Terminal(parentesisAbierto));
        }

        if (expresionNumerica != null) {
            hijos.add(expresionNumerica);
        }

        if (parentesisCerrado != null) {
            hijos.add(new Terminal(parentesisCerrado));
        }

        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        
        if(negativo != null) {
            str.append("-");
        }
        
        if(literalNumerico != null) {
            str.append(literalNumerico.parse());
        } else if(identificador != null) {
            str.append(identificador.getLexema());
            if(operadorEspecial != null){
                str.append(operadorEspecial.getLexema());
            }
        } else {
            str.append("(");
            str.append(expresionNumerica.parse());
            str.append(")");
        }

        return str.toString();
    }

    @Override
    public String toString() {
        return "Factor numerico";
    }

}
