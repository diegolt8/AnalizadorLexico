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
    private ExpresionLogica expresionLogica;
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

    public ExpresionLogica getExpresionLogica() {
        return expresionLogica;
    }

    public void setExpresionLogica(ExpresionLogica expresionLogica) {
        this.expresionLogica = expresionLogica;
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
        
        if (expresionLogica != null) {
            hijos.add(expresionLogica);
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
       StringBuilder str = new StringBuilder();

        str.append("for").append(" ").append("(");

        if (declaracionVariable != null) {
            str.append(declaracionVariable.parse());
            str.append(expresionLogica.parse());
            str.append(";").append(" ");
            str.append(expresionNumerica.parse());
            str.append(")").append(" ").append("{");
            for (Sentencia sentencia : listaSentencias.getSentencias()) {
                str.append("\n").append(sentencia.parse());
            }
            str.append("\n}");
        } 
        
        if (declaranteVariable != null) {
            str.append(declaranteVariable.parse());
            str.append(expresionLogica.parse());
            str.append(";").append(" ");
            str.append(expresionNumerica.parse());
            str.append(")").append(" ").append("{\n");
            for (Sentencia sentencia : listaSentencias.getSentencias()) {
                str.append(sentencia.parse());
            }
        }
        

        return str.toString();
    }

    @Override
    public String toString() {
        return "Estructura de control PARA";
    }
    
}
