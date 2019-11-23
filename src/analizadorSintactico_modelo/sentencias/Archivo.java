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
public class Archivo extends Sentencia {

    private Main main;
    private ListaMetodos<Metodo> listaMetodos;

    /*
     * Constructor
     */
    public Archivo() {
        this.listaMetodos = new ListaMetodos<>();
    }

    // Gets y sets
    // ------------------------------------------------------------------------
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public ListaMetodos<Metodo> getListaMetodos() {
        return listaMetodos;
    }

    public void setListaMetodos(ListaMetodos<Metodo> listaMetodos) {
        this.listaMetodos = listaMetodos;
    }
    //-------------------------------------------------------------------------

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        if (main != null) {
            hijos.add(main);
        }

        if (!listaMetodos.getMetodos().isEmpty()) {
            hijos.add(listaMetodos);
        }

        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        str.append("<!DOCTYPE html>\n"
                + "   <html>\n"
                + "       <head>\n"
                + "           <script src=\"https://cdnjs.cloudflare.com/ajax/libs/axios/0.17.0/axios.js\"></script>\n"
                + "           <script>\n");
        str.append(main.parse());
        str.append(listaMetodos.parse());
        str.append("         \n\t</script>\n"
                + "       </head>\n"
                + "       <body onload=\"main();\">\n"
                + "       </body>\n"
                + "   </html>");
        return str.toString();
    }

    @Override
    public String toString() {
        return "Unidad de compilacion";
    }

}
