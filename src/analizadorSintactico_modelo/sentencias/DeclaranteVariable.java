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
public class DeclaranteVariable extends Sentencia {

    private Lexema identificador;
    private Lexema operadorAsignacion;
    private InicializadorVariable inicializadorVariable;

    public DeclaranteVariable() {
    }

    public Lexema getOperadorAsignacion() {
        return operadorAsignacion;
    }

    public void setOperadorAsignacion(Lexema operadorAsignacion) {
        this.operadorAsignacion = operadorAsignacion;
    }

    public Lexema getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Lexema identificador) {
        this.identificador = identificador;
    }

    public InicializadorVariable getInicializadorVariable() {
        return inicializadorVariable;
    }

    public void setInicializadorVariable(InicializadorVariable inicializadorVariable) {
        this.inicializadorVariable = inicializadorVariable;
    }    
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        hijos.add(new Terminal(identificador));
        
        if (operadorAsignacion != null){
            hijos.add(new Terminal(operadorAsignacion));
        }
        
        if (inicializadorVariable != null){
            hijos.add(inicializadorVariable);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
          StringBuilder str = new StringBuilder();

        str.append(identificador.getLexema()).append(" ");
        if (operadorAsignacion != null) {
            str.append(operadorAsignacion.getLexema()).append(" ");
            str.append(inicializadorVariable.parse());
        }
        
        return str.toString();
    }

    @Override
    public String toString() {
        return "Declarante: " + identificador.getLexema();
    }
    
}
