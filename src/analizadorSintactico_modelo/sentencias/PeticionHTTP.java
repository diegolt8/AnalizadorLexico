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
public class PeticionHTTP extends Sentencia {

    private Lexema identificador;
    private VerboHTTP verboHTTP;

    public PeticionHTTP() {
    }

    public Lexema getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Lexema identificador) {
        this.identificador = identificador;
    }

    public VerboHTTP getVerboHTTP() {
        return verboHTTP;
    }

    public void setVerboHTTP(VerboHTTP verboHTTP) {
        this.verboHTTP = verboHTTP;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (identificador != null) {
            hijos.add(new Terminal(identificador));
        }
        
        if (verboHTTP != null) {
            hijos.add(verboHTTP);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        return "";
    }

    @Override
    public String toString() {
        return "Peticion HTTP";
    }
    
}
