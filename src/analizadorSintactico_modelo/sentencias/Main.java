/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo.sentencias;

import analizadorSintactico_modelo.Sentencia;
import analizadorSintactico_modelo.sentencias.medios.ListaSentencia;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public class Main extends Sentencia{

    ListaSentencia<Sentencia> listaSentencia;
    
    @Override
    public ArrayList<Sentencia> llenarHijos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String parse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Main() {
        this.listaSentencia = new ListaSentencia<>();
    }

    public ListaSentencia<Sentencia> getListaSentencia() {
        return listaSentencia;
    }

    public void setListaSentencia(ListaSentencia<Sentencia> listaSentencia) {
        this.listaSentencia = listaSentencia;
    }
    
    
    
}
