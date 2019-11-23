/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico_modelo;

import analizadorLexico_modelo.Lexema;
import analizadorSintactico_modelo.Sentencia;
import java.util.ArrayList;

/**
 *
 * @author Pepe
 */
public class FlujoSentencias {
    
    private ArrayList<MetodosContexto> listaMetodos;
    private ArrayList<VariablesContexto> listaVariables;
    private Sentencia nodoPadre;
    private Sentencia nodoActual;
    private int contextoActual;

    public FlujoSentencias() {  
    }    

    public FlujoSentencias(Sentencia nodoPadre) {
        this.listaMetodos = new ArrayList<>();
        this.listaVariables = new ArrayList<>();
        this.nodoPadre = nodoPadre;
        this.nodoActual = nodoPadre;
        this.contextoActual = 0;
    }   
    
    public VariablesContexto buscarVariable(String nombre) {
        for (VariablesContexto variable : listaVariables) {
            if (variable.getNombre().equals(nombre)) {
                return variable;
            }
        }
        return null;
    }
    
    public void modificarValorVariable(String nombre, Lexema valor) {
        for (int i = 0; i < listaVariables.size(); i++) {
            if (listaVariables.get(i).getNombre().equals(nombre)) {
                listaVariables.get(i).setValor(valor);
            }
        }
    }
    
    public void limpiarContexto() {
        for (int i = 0; i < listaVariables.size(); i++) {
            if (listaVariables.get(i).getContexto() == contextoActual) {
                listaVariables.remove(i);
            }
        }
    }
    
    public void parametrosVariables(String nombreMetodo) {
        for (int i = 0; i < listaMetodos.size(); i++) {
            if (listaMetodos.get(i).getNombre().equals(nombreMetodo)) {
                ArrayList<VariablesContexto> lista = listaMetodos.get(i).getListaParametros();
                for (VariablesContexto variableContexto : lista) {
                    variableContexto.setContexto(contextoActual);
                    listaVariables.add(variableContexto);
                }                
            }
        }
    }
    
    public void añadirMetodo(MetodosContexto metodo) {
        listaMetodos.add(metodo);
    }
    
    public void añadirVariable(VariablesContexto variable) {
        listaVariables.add(variable);
    }
    
    public void aumentarContexto(){
        this.contextoActual++;
    }
    
    public void disminuirContexto(){
        this.contextoActual--;
    }
    
    public int getContextoActual() {
        return contextoActual;
    }

    public void setContextoActual(int contextoActual) {
        this.contextoActual = contextoActual;
    }

    public ArrayList<MetodosContexto> getListaMetodos() {
        return listaMetodos;
    }

    public void setListaMetodos(ArrayList<MetodosContexto> listaMetodos) {
        this.listaMetodos = listaMetodos;
    }

    public ArrayList<VariablesContexto> getListaVariables() {
        return listaVariables;
    }

    public void setListaVariables(ArrayList<VariablesContexto> listaVariables) {
        this.listaVariables = listaVariables;
    }

    public Sentencia getNodoPadre() {
        return nodoPadre;
    }

    public void setNodoPadre(Sentencia nodoPadre) {
        this.nodoPadre = nodoPadre;
    }

    public Sentencia getNodoActual() {
        return nodoActual;
    }

    public void setNodoActual(Sentencia nodoActual) {
        this.nodoActual = nodoActual;
    }
}
