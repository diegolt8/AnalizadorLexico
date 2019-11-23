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
public class InicializadorVariable extends Sentencia {

    private Sentencia expresion;
    private HTTP http;
    private RespuestaHTTP respuestaHttp;
    private Lexema identificador;

    public InicializadorVariable() {
    }

    public Lexema getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Lexema identificador) {
        this.identificador = identificador;
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
        
        if (identificador != null) {
            hijos.add(new Terminal(identificador));
        }
        
        return hijos;
    }

    @Override
    public String parse() {       
        return "";
    }

    @Override
    public String toString() {
        return "Inicializador variable";
    }
    
}
