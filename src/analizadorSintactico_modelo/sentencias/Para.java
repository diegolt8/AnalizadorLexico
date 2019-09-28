/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias;

import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pepe
 */
public class Para extends Sentencia {

    private DeclaracionVariable declaracionVariable;
    private DeclaranteVariable declaranteVariable;
    private ExpresionRelacional expresionRelacional;
    private ExpresionNumerica expresionNumerica;
    private ListaSentencias<Sentencia> listaSentencias;

    public Para() {
        this.listaSentencias = new ListaSentencias<>();
    }   

    public DeclaracionVariable getDeclaracionVariable() {
        return declaracionVariable;
    }

    public void setDeclaracionVariable(DeclaracionVariable declaracionVariable) {
        this.declaracionVariable = declaracionVariable;
    }

    public DeclaranteVariable getDeclaranteVariable() {
        return declaranteVariable;
    }

    public void setDeclaranteVariable(DeclaranteVariable declaranteVariable) {
        this.declaranteVariable = declaranteVariable;
    }

    public ExpresionRelacional getExpresionRelacional() {
        return expresionRelacional;
    }

    public void setExpresionRelacional(ExpresionRelacional expresionRelacional) {
        this.expresionRelacional = expresionRelacional;
    }

    public ExpresionNumerica getExpresionNumerica() {
        return expresionNumerica;
    }

    public void setExpresionNumerica(ExpresionNumerica ExcpresionNumerica) {
        this.expresionNumerica = ExcpresionNumerica;
    }

    public ListaSentencias<Sentencia> getListaSentencias() {
        return listaSentencias;
    }

    public void setListaSentencias(ListaSentencias<Sentencia> listaSentencias) {
        this.listaSentencias = listaSentencias;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (declaracionVariable != null) {
            hijos.add(declaracionVariable);
        }
        
        if (declaranteVariable != null) {
            hijos.add(declaranteVariable);
        }
        
        if (expresionRelacional != null) {
            hijos.add(expresionRelacional);
        }
        
        if (expresionNumerica != null) {
            hijos.add(expresionNumerica);
        }
        
        if (!listaSentencias.getSentencias().isEmpty()) {
            hijos.add(listaSentencias);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Estructura de control PARA";
    }
    
}
