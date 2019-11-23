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
public class TerminoCadena extends Sentencia {

    private TerminoLiteral terminoLiteral;
    private TerminoCadena terminoCadena;

    public TerminoCadena() {
    }

    public TerminoLiteral getTerminoLiteral() {
        return terminoLiteral;
    }

    public void setTerminoLiteral(TerminoLiteral terminoLiteral) {
        this.terminoLiteral = terminoLiteral;
    }

    public TerminoCadena getTerminoCadena() {
        return terminoCadena;
    }

    public void setTerminoCadena(TerminoCadena terminoCadena) {
        this.terminoCadena = terminoCadena;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        if (terminoLiteral != null) {
            hijos.add(terminoLiteral);
        }

        if (terminoCadena != null) {
            hijos.add(terminoCadena);
        }

        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        if (terminoCadena != null) {
            str.append(terminoCadena.parse());
        }

        if (terminoLiteral != null) {
            str.append(terminoLiteral.parse());
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "Termino cadena";
    }

}
