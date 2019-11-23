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
    public String parse() {StringBuilder str = new StringBuilder();
        str.append("\n\t\t").append("axios.put").append("(").append(url.getLexema()).append(", ");
        str.append(json.parse());
        str.append(")");
        str.append("\n\t\t.then( res => {" + "\n" + "\t\t  console.log(res.data) } )" + "\n" + "\t\t.catch(function (error) {" + "\n" + "\t\t console.log(error) })");
        return str.toString();
    }

    @Override
    public String toString() {
        return verboHttp.getLexema();
    }
    
}
