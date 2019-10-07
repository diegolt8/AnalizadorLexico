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
public class HTTPModificar extends Sentencia {

    private Lexema verboHttp;
    private Lexema url;
    private HTTPParametros httpParametros;
    private JSON json;

    public HTTPModificar() {
    }

    public Lexema getVerboHttp() {
        return verboHttp;
    }

    public void setVerboHttp(Lexema verboHttp) {
        this.verboHttp = verboHttp;
    }

    public Lexema getUrl() {
        return url;
    }

    public void setUrl(Lexema url) {
        this.url = url;
    }

    public HTTPParametros getHttpParametros() {
        return httpParametros;
    }

    public void setHttpParametros(HTTPParametros httpParametros) {
        this.httpParametros = httpParametros;
    }

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (verboHttp != null) {
            hijos.add(new Terminal(verboHttp));
        }
        
        if (url != null) {
            hijos.add(new Terminal(url));
        }
        
        if (httpParametros != null) {
            hijos.add(httpParametros);
        }
        
        if (json != null) {
            hijos.add(json);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return verboHttp.getLexema();
    }
    
}
