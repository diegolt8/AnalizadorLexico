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
public class HTTPEliminar extends Sentencia{
    
    private Lexema url;
    private HTTPParametros parametros;

    public HTTPEliminar() {
    }

    public Lexema getUrl() {
        return url;
    }

    public void setUrl(Lexema url) {
        this.url = url;
    }

    public HTTPParametros getParametros() {
        return parametros;
    }

    public void setParametros(HTTPParametros parametros) {
        this.parametros = parametros;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (url != null) {
            hijos.add(new Terminal(url));
        }
        
        if (parametros != null) {
            hijos.add(parametros);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Eliminar";
    }
    
}
