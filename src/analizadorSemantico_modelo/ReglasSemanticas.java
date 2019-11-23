/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo;

import analizadorLexico_modelo.Lexema;
import analizadorLexico_modelo.TipoLexemaEnum;
import analizadorSintactico_modelo.Sentencia;
import analizadorSintactico_modelo.sentencias.LiteralNumerico;
import analizadorSintactico_modelo.sentencias.TerminoLiteral;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public class ReglasSemanticas {

    public ReglasSemanticas() {
    }

    /**
     * *
     * Metodo que retorna true si el nombre ya esta en la lista de metodos
     *
     * @param listaMetodos
     * @param nombreMetodo
     * @return
     */
    public boolean unicidadNombreMetodo(ArrayList<MetodosContexto> listaMetodos, String nombreMetodo) {
        return listaMetodos.stream().anyMatch((metodo) -> (metodo.getNombre().equals(nombreMetodo)));
    }

    /**
     * *
     * Metoo que retorna true si el nombre ya esta en la lista de variables
     *
     * @param listaVariables
     * @param nombreVariable
     * @return
     */
    public boolean unicidadNombreVariable(ArrayList<VariablesContexto> listaVariables, String nombreVariable) {
        return listaVariables.stream().anyMatch((variable) -> (variable.getNombre().equals(nombreVariable)));
    }

    /**
     * *
     * Metodo que retorna true si el nombre ya esta en la lista de parametros
     *
     * @param listaParametros
     * @param nombreParametro
     * @return
     */
    public boolean unicidadNombreParametro(ArrayList<VariablesContexto> listaParametros, String nombreParametro) {
        return listaParametros.stream().anyMatch((parametro) -> (parametro.getNombre().equals(nombreParametro)));
    }

    /**
     * *
     * Metodo que retorna true si el valor de la variable no se encuentra
     * inicializado
     *
     * @param listaVariables
     * @param nombreVariable
     * @return
     */
    public boolean variableInicializada(ArrayList<VariablesContexto> listaVariables, String nombreVariable) {
        return listaVariables.stream().filter((variable) -> (variable.getNombre().equals(nombreVariable))).anyMatch((variable) -> (variable.getValor() == null));
    }

    /**
     * *
     * Metodo que retorna true si los tipos de datos entre variables son
     * compatibles
     *
     * @param variable
     * @param valor
     * @return
     */
    public boolean tiposDatosCompatiblesVariable(VariablesContexto variable, Lexema valor) {
        return variable.getTipoDato() == valor.getTipoLexema();
    }

    /**
     * *
     * Metodo que retorna true si los tipos de datos son validos en una
     * asigancion de valores primitivos
     *
     * @param variable
     * @param valor
     * @return
     */
    public boolean tiposDatosCompatiblesAsigancion(VariablesContexto variable, TerminoLiteral valor) {
        if (valor.getTerminoLiteral() != null) {
            if ("class analizadorSintactico_modelo.sentencias.LiteralNumerico".equals(valor.getTerminoLiteral().getClass() + "")) {
                LiteralNumerico literal = (LiteralNumerico) valor.getTerminoLiteral();
                if (literal.getParteDecimal() == null) {
                    if (variable.getTipoDato() == TipoLexemaEnum.TIPO_DATO_ENT) {
                        return true;
                    }
                } else {
                    if (variable.getTipoDato() == TipoLexemaEnum.TIPO_DATO_ENT || variable.getTipoDato() == TipoLexemaEnum.TIPO_DATO_DEC) {
                        return true;
                    }
                }
            } else {
                if (variable.getTipoDato() == TipoLexemaEnum.TIPO_DATO_CAD || variable.getTipoDato() == TipoLexemaEnum.TIPO_DATO_CAR) {
                    return true;
                }
            }
        } else {
            if (variable.getTipoDato() == TipoLexemaEnum.TIPO_DATO_CAD || variable.getTipoDato() == TipoLexemaEnum.TIPO_DATO_CAR) {
                return true;
            }
        }
        return false;
    }

    public boolean invocacionMetodos() {
        return true;
    }

    public String nombreClase(Sentencia sentencia) {
        String nombreClase = sentencia.getClass() + "";
        String[] partes = nombreClase.split(" ");
        String aux = partes[1];
        String[] partes2 = aux.split(".sentencias.");
        String aux2 = partes2[1];
        return aux2;
    }

}
