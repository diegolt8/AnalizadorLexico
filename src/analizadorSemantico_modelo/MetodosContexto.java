/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo;

import analizadorLexico_modelo.TipoLexemaEnum;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public class MetodosContexto {
    
    private String nombre;
    private ArrayList<VariablesContexto> listaParametros;
    private String retorno;
    private TipoLexemaEnum tipoDatoRetorno;

    public MetodosContexto(String nombre) {
        this.nombre = nombre;
    }

    public MetodosContexto(String nombre, ArrayList<VariablesContexto> listaParametros) {
        this.nombre = nombre;
        this.listaParametros = listaParametros;
    }

    public MetodosContexto() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<VariablesContexto> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(ArrayList<VariablesContexto> listaParametros) {
        this.listaParametros = listaParametros;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public TipoLexemaEnum getTipoDatoRetorno() {
        return tipoDatoRetorno;
    }

    public void setTipoDatoRetorno(TipoLexemaEnum tipoDatoRetorno) {
        this.tipoDatoRetorno = tipoDatoRetorno;
    }
    
    
    
}
