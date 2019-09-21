/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.ErrorLexico;
import modelo.FlujoCaracteres;
import modelo.Lexema;
import modelo.automatas.Automatas;

/**
 *
 * @author diegoul818
 */
public class AnalizadorLexico {

    private static ArrayList<Lexema> listaLexemas;
    private static ArrayList<ErrorLexico> listaErrorLexico;
    private Automatas automata;

    /**
     * *
     * Contructor del analizador lexico, que instancia las variables que se
     * usaran
     */
    public void instanciarClases() {
        listaLexemas = new ArrayList<>();
        listaErrorLexico = new ArrayList<>();
        automata = new Automatas();
    }

    /**
     * *
     * Metodo que se encarga de llevar el flujo de control del analizador lexico
     *
     * @param caracteres
     */
    public void analizadorLexico(String caracteres) {
        FlujoCaracteres flujo = crearFlujo(caracteres);
        instanciarClases();
        Lexema lexema;

        while (flujo.getPosicionActual() < flujo.getCantidadCaracteres()) {
            if (validarFinLinea(flujo)) {
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
            lexema = automata.automataReservadaHttpRequest(flujo);
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

            lexema = automata.automataOperadorAsignacion(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataOperadorRelacional(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }

            lexema = automata.automataOperadorEspecial(flujo);
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

            lexema = automata.automataEstructurasControl(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }

            lexema = automata.automataDelimitador(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataOperadorLogico(flujo);
            if (lexema != null) {
                listaLexemas.add(lexema);
                continue;
            }

            lexema = automata.automataComentario(flujo);
            if (lexema != null) {
                //listaLexemas.add(lexema);
                continue;
            }
            lexema = automata.automataValorCadena(flujo);
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

    /**
     * *
     * Metodo que se encarga de iniciarlizar el flujo de caracteres segun un
     * String entrante, y retorna el Flujo de caracteres creado.
     *
     * @param caracteres
     * @return
     */
    private FlujoCaracteres crearFlujo(String caracteres) {
        char[] flujoCaracteres = new char[caracteres.length()];
        for (int i = 0; i < caracteres.length(); i++) {
            flujoCaracteres[i] = caracteres.charAt(i);
        }
        return new FlujoCaracteres(flujoCaracteres);
    }

    /**
     * *
     * Metodo que se encarga de crear el objeto de error lexico, segun el flujo
     * de caracteres, retorna el error lexico
     *
     * @param flujo
     */
    private void capturaErrorLexico(FlujoCaracteres flujo) {
        String errorLexico = "";
        int columna = flujo.getColumna();
        while (flujo.getPosicionActual() < flujo.getCantidadCaracteres()) {
            if (flujo.getCaracter() == 32 || flujo.getCaracter() == 10) {
                break;
            }
            errorLexico += flujo.getCaracter();
            flujo.moverAdelante();
            flujo.siguienteColumna();
        }
        listaErrorLexico.add(new ErrorLexico(flujo.getFila(), columna, errorLexico));
    }

    /**
     * *
     * Metodo que retorna la lista de lexemas identificados
     *
     * @return
     */
    public ArrayList<Lexema> getListaLexema() {
        return listaLexemas;
    }

    /**
     * *
     * Metodo que retorna la lista de errores lexicos identificados
     *
     * @return
     */
    public ArrayList<ErrorLexico> getListaErroresLexico() {
        return listaErrorLexico;
    }

    /**
     * *
     * Metodo que valida si el caracter actual es un salto de linea o un
     * espacio, retorna true, cuando encuentra un espacio o salto de lina,
     * retorna false cuando no encuentra un espacio o salto de linea
     *
     * @param flujo
     * @return
     */
    public boolean validarFinLinea(FlujoCaracteres flujo) {
        boolean valor = false;
        if (flujo.getCaracter() == 10 || flujo.getCaracter() == 13) {
            flujo.siguienteFila();
            flujo.setColumna(1);
            valor = true;
            flujo.moverAdelante();
        } else if (flujo.getCaracter() == 32) {
            flujo.siguienteColumna();
            flujo.moverAdelante();
            valor = true;
        }
        return valor;
    }
}
