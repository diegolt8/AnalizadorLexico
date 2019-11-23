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
public class InicializadorVariable extends Sentencia {

    private Sentencia expresion;
    private HTTP http;
    private RespuestaHTTP respuestaHttp;

    public InicializadorVariable() {
    }

    public Sentencia getExpresion() {
        return expresion;
    }

    public void setExpresion(Sentencia expresion) {
        this.expresion = expresion;
    }

    public HTTP getHttp() {
        return http;
    }

    public void setHttp(HTTP http) {
        this.http = http;
    }

    public RespuestaHTTP getRespuestaHttp() {
        return respuestaHttp;
    }

    public void setRespuestaHttp(RespuestaHTTP respuestaHttp) {
        this.respuestaHttp = respuestaHttp;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        if (expresion != null) {
            hijos.add(expresion);
        }

        if (http != null) {
            hijos.add(http);
        }

        if (respuestaHttp != null) {
            hijos.add(respuestaHttp);
        }

        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        if (expresion != null) {
            str.append(expresion.parse());
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "Inicializador variable";
    }

}
