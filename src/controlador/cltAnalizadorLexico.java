/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.ErrorLexico;
import modelo.FlujoCaracteres;
import modelo.Lexema;
import modelo.automatas.Automatas;

/**
 *
 * @author diegoul818
 */
public class cltAnalizadorLexico {

    private static ArrayList<Lexema> listaLexemas;
    private static ArrayList<ErrorLexico> listaErrorLexico;
    private Automatas automata;
    

    public void instanciarClases() {
        listaLexemas = new ArrayList<>();
        listaErrorLexico = new ArrayList<>();
        automata = new Automatas();
    }

    public void analizadorLexico(String caracteres) {
        FlujoCaracteres flujo = crearFlujo(caracteres);
        instanciarClases();
        Lexema lexema;
        boolean banderaCadenas = false;
        
        while (flujo.getPosicionActual() < flujo.getCantidadCaracteres()) {
            if (flujo.getCaracter() == 10) {
                flujo.siguienteFila();
                flujo.setColumna(1);
                flujo.moverAdelante();
                continue;
            } else if (flujo.getCaracter() == 32) {
                flujo.siguienteColumna();
                flujo.moverAdelante();
                continue;
            }                           
            
            lexema = automata.automataReservadaValorLogico(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataReservadaStream(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataReservadaNulo(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataReservadaMain(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataReservadaVerbosHttp(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataReservadaHttpRequest1(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataReservadaHttpRequest2(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataReservadaHttp(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataReservadaCast(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataReservadaBucles(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            
            
           
            lexema = automata.automataOperadorRelacional2(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataOperadorRelacional1(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }  
            
            
            lexema = automata.automataOperadorEspecial1(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataOperadorEspecial2(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataOperadorAsignacion(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataOperadorAritmetico(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            
            
            lexema = automata.automataTiposDatos(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            
            
            lexema = automata.automataEstructurasControl1(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataEstructurasControl2(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            
            
            lexema = automata.automataDelimitador(flujo);
            if (lexema != null) {
               listaLexemas.add(lexema);
               if(lexema.getLexema().equals("\'")){
                    banderaCadenas = !banderaCadenas;
                    if(banderaCadenas){
                        lexema = automata.automataValorCadena(flujo);
                        if (lexema != null) {
                            listaLexemas.add(lexema);
                            continue;
                        }
                    }
               }
               continue;
            }
            lexema = automata.automataOperadorLogico(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            
            
            lexema = automata.automataValorNumerico(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataIdentificador(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
            } else {
                capturaErrorLexico(flujo);
            }
        }
    }
    
    private FlujoCaracteres crearFlujo(String caracteres){
        char[] flujoCaracteres = new char[caracteres.length()];
        for (int i = 0; i < caracteres.length(); i++) {
            flujoCaracteres[i] = caracteres.charAt(i);
        }
        return new FlujoCaracteres(flujoCaracteres);
    }
    
    private void capturaErrorLexico(FlujoCaracteres flujo){
        String errorLexico = "";
        int columna = flujo.getColumna();
        while (flujo.getPosicionActual() < flujo.getCantidadCaracteres()){
            if(flujo.getCaracter() == 32 || flujo.getCaracter() == 10)
                break;
            errorLexico += flujo.getCaracter();
            flujo.moverAdelante();
            flujo.siguienteColumna();
        }
        listaErrorLexico.add(new ErrorLexico(flujo.getFila(), columna, errorLexico));
    }
    
    public DefaultTableModel tablaLexemas(){
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("#");
        model.addColumn("Lexema");
        model.addColumn("Tipo Lexema");
        model.addColumn("Token");
        model.addColumn("Fila");
        model.addColumn("Columna");
 
        for(int i = 0; i < listaLexemas.size(); i++){
            model.addRow(new Object[]{
                (i+1),
                listaLexemas.get(i).getLexema(),
                listaLexemas.get(i).getTipoLexema(),
                listaLexemas.get(i).getToken(),
                listaLexemas.get(i).getLinea(),
                listaLexemas.get(i).getColumna()
            });
        }

        return model;
    }
    
    public DefaultTableModel tablaErrorLexico(){
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("#");
        model.addColumn("Error");
        model.addColumn("Fila");
        model.addColumn("Columna");
 
        for(int i = 0; i < listaErrorLexico.size(); i++){
            model.addRow(new Object[]{
                (i+1),
                listaErrorLexico.get(i).getToken(),
                listaErrorLexico.get(i).getFila(),
                listaErrorLexico.get(i).getColumna()
            });
        }

        return model;
    }
    
}
