/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico_modelo.automatas;

import analizadorLexico_modelo.FlujoCaracteres;
import analizadorLexico_modelo.Lexema;

/**
 *
 * @author Pepe
 */
public class Automatas {

    private final Automata_Delimitador automataDelimitador;
    private final Automata_EstructurasControl automataEstructurasControl;
    private final Automata_Identificador automataIdentificador;
    private final Automata_TiposDatos automataTiposDatos;
    private final Automata_Operador_Aritmetico automataOperadorAritmetico;
    private final Automata_Operador_Asignacion automataOperadorAsignacion;
    private final Automata_Operador_Especial automataOperadorEspecial;
    private final Automata_Operador_Logico automataOperadorLogico;
    private final Automata_Operador_Relacional automataOperadorRelacional;
    private final Automata_PalabrasReservada_Bucles automataReservadaBucles;
    private final Automata_PalabrasReservada_Cast automataReservadaCast;
    private final Automata_PalabrasReservada_Http automataReservadaHttp;
    private final Automata_PalabrasReservada_HttpRequest automataReservadaHttpRequest;
    private final Automata_PalabrasReservada_Main automataReservadaMain;
    private final Automata_PalabrasReservada_Nulo automataReservadaNulo;
    private final Automata_PalabrasReservada_Stream automataReservadaStream;
    private final Automata_PalabrasReservada_ValorLogico automataReservadaValorLogico;
    private final Automata_PalabrasReservada_VerbosHttp automataReservadaVerbosHttp;
    private final Automata_ValorNumerico automataValorNumerico;
    private final Automata_ValorCadena automataValorCadena;
    private final Automata_Comentario automataComentario;

    public Automatas() {
        automataDelimitador = new Automata_Delimitador();
        automataEstructurasControl = new Automata_EstructurasControl();
        automataIdentificador = new Automata_Identificador();
        automataTiposDatos = new Automata_TiposDatos();
        automataOperadorAritmetico = new Automata_Operador_Aritmetico();
        automataOperadorAsignacion = new Automata_Operador_Asignacion();
        automataOperadorEspecial = new Automata_Operador_Especial();
        automataOperadorLogico = new Automata_Operador_Logico();
        automataOperadorRelacional = new Automata_Operador_Relacional();
        automataReservadaBucles = new Automata_PalabrasReservada_Bucles();
        automataReservadaCast = new Automata_PalabrasReservada_Cast();
        automataReservadaHttp = new Automata_PalabrasReservada_Http();
        automataReservadaHttpRequest = new Automata_PalabrasReservada_HttpRequest();
        automataReservadaMain = new Automata_PalabrasReservada_Main();
        automataReservadaNulo = new Automata_PalabrasReservada_Nulo();
        automataReservadaStream = new Automata_PalabrasReservada_Stream();
        automataReservadaValorLogico = new Automata_PalabrasReservada_ValorLogico();
        automataReservadaVerbosHttp = new Automata_PalabrasReservada_VerbosHttp();
        automataValorNumerico = new Automata_ValorNumerico();
        automataValorCadena = new Automata_ValorCadena();
        automataComentario = new Automata_Comentario();
    }

    public Lexema automataComentario(FlujoCaracteres flujo) {
        return automataComentario.ejecutarAutomata(flujo);
    }

    public Lexema automataDelimitador(FlujoCaracteres flujo) {
        return automataDelimitador.ejecutarAutomata(flujo);
    }

    public Lexema automataEstructurasControl(FlujoCaracteres flujo) {
        return automataEstructurasControl.ejecutarAutomata(flujo);
    }

    public Lexema automataIdentificador(FlujoCaracteres flujo) {
        return automataIdentificador.ejecutarAutomata(flujo);
    }

    public Lexema automataTiposDatos(FlujoCaracteres flujo) {
        return automataTiposDatos.ejecutarAutomata(flujo);
    }

    public Lexema automataOperadorAritmetico(FlujoCaracteres flujo) {
        return automataOperadorAritmetico.ejecutarAutomata(flujo);
    }

    public Lexema automataOperadorAsignacion(FlujoCaracteres flujo) {
        return automataOperadorAsignacion.ejecutarAutomata(flujo);
    }

    public Lexema automataOperadorEspecial(FlujoCaracteres flujo) {
        return automataOperadorEspecial.ejecutarAutomata(flujo);
    }

    public Lexema automataOperadorLogico(FlujoCaracteres flujo) {
        return automataOperadorLogico.ejecutarAutomata(flujo);
    }

    public Lexema automataOperadorRelacional(FlujoCaracteres flujo) {
        return automataOperadorRelacional.ejecutarAutomata(flujo);
    }

    public Lexema automataReservadaBucles(FlujoCaracteres flujo) {
        return automataReservadaBucles.ejecutarAutomata(flujo);
    }

    public Lexema automataReservadaCast(FlujoCaracteres flujo) {
        return automataReservadaCast.ejecutarAutomata(flujo);
    }

    public Lexema automataReservadaHttp(FlujoCaracteres flujo) {
        return automataReservadaHttp.ejecutarAutomata(flujo);
    }

    public Lexema automataReservadaHttpRequest(FlujoCaracteres flujo) {
        return automataReservadaHttpRequest.ejecutarAutomata(flujo);
    }

    public Lexema automataReservadaMain(FlujoCaracteres flujo) {
        return automataReservadaMain.ejecutarAutomata(flujo);
    }

    public Lexema automataReservadaNulo(FlujoCaracteres flujo) {
        return automataReservadaNulo.ejecutarAutomata(flujo);
    }

    public Lexema automataReservadaStream(FlujoCaracteres flujo) {
        return automataReservadaStream.ejecutarAutomata(flujo);
    }

    public Lexema automataReservadaValorLogico(FlujoCaracteres flujo) {
        return automataReservadaValorLogico.ejecutarAutomata(flujo);
    }

    public Lexema automataReservadaVerbosHttp(FlujoCaracteres flujo) {
        return automataReservadaVerbosHttp.ejecutarAutomata(flujo);
    }

    public Lexema automataValorNumerico(FlujoCaracteres flujo) {
        return automataValorNumerico.ejecutarAutomata(flujo);
    }

    public Lexema automataValorCadena(FlujoCaracteres flujo) {
        return automataValorCadena.ejecutarAutomata(flujo);
    }
}
