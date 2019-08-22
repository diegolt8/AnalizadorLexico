/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.automatas;

import modelo.FlujoCaracteres;
import modelo.Lexema;

/**
 *
 * @author Pepe
 */
public class Automatas {
    
    private final Automata_Delimitador automataDelimitador;
    private final Automata_EstructurasControl_1 automataEstructurasControl1;
    private final Automata_EstructurasControl_2 automataEstructurasControl2;
    private final Automata_Identificador automataIdentificador;
    private final Automata_TiposDatos automataTiposDatos;
    private final Automata_Operador_Aritmetico automataOperadorAritmetico;
    private final Automata_Operador_Asignacion automataOperadorAsignacion;
    private final Automata_Operador_Especial_1 automataOperadorEspecial1;
    private final Automata_Operador_Especial_2 automataOperadorEspecial2;
    private final Automata_Operador_Logico automataOperadorLogico; 
    private final Automata_Operador_Relacional_1 automataOperadorRelacional1;
    private final Automata_Operador_Relacional_2 automataOperadorRelacional2;
    private final Automata_PalabrasReservada_Bucles automataReservadaBucles;
    private final Automata_PalabrasReservada_Cast automataReservadaCast;
    private final Automata_PalabrasReservada_Http automataReservadaHttp;
    private final Automata_PalabrasReservada_HttpRequest_1 automataReservadaHttpRequest1;
    private final Automata_PalabrasReservada_HttpRequest_2 automataReservadaHttpRequest2;
    private final Automata_PalabrasReservada_Main automataReservadaMain;
    private final Automata_PalabrasReservada_Nulo automataReservadaNulo;
    private final Automata_PalabrasReservada_Stream automataReservadaStream;
    private final Automata_PalabrasReservada_ValorLogico automataReservadaValorLogico;
    private final Automata_PalabrasReservada_VerbosHttp automataReservadaVerbosHttp;
    private final Automata_ValorNumerico automataValorNumerico;
    private final Automata_ValorCadena automataValorCadena;
    
    public Automatas() {
        automataDelimitador = new Automata_Delimitador();
        automataEstructurasControl1 = new Automata_EstructurasControl_1();
        automataEstructurasControl2 = new Automata_EstructurasControl_2();
        automataIdentificador = new Automata_Identificador();
        automataTiposDatos = new Automata_TiposDatos();
        automataOperadorAritmetico = new Automata_Operador_Aritmetico();
        automataOperadorAsignacion = new Automata_Operador_Asignacion();
        automataOperadorEspecial1 = new Automata_Operador_Especial_1();
        automataOperadorEspecial2 = new Automata_Operador_Especial_2();
        automataOperadorLogico = new Automata_Operador_Logico();
        automataOperadorRelacional1 = new Automata_Operador_Relacional_1();
        automataOperadorRelacional2 = new Automata_Operador_Relacional_2();
        automataReservadaBucles = new Automata_PalabrasReservada_Bucles();
        automataReservadaCast = new Automata_PalabrasReservada_Cast();
        automataReservadaHttp = new Automata_PalabrasReservada_Http();
        automataReservadaHttpRequest1 = new Automata_PalabrasReservada_HttpRequest_1();
        automataReservadaHttpRequest2 = new Automata_PalabrasReservada_HttpRequest_2();
        automataReservadaMain = new Automata_PalabrasReservada_Main();
        automataReservadaNulo = new Automata_PalabrasReservada_Nulo();
        automataReservadaStream = new Automata_PalabrasReservada_Stream();
        automataReservadaValorLogico = new Automata_PalabrasReservada_ValorLogico();
        automataReservadaVerbosHttp = new Automata_PalabrasReservada_VerbosHttp();
        automataValorNumerico = new Automata_ValorNumerico();
        automataValorCadena = new Automata_ValorCadena();
    }
    
    public Lexema automataDelimitador(FlujoCaracteres flujo){
        return automataDelimitador.ejecutarAutomata(flujo);
    }
    
    public Lexema automataEstructurasControl1(FlujoCaracteres flujo){
        return automataEstructurasControl1.ejecutarAutomata(flujo);
    }
    
    public Lexema automataEstructurasControl2(FlujoCaracteres flujo){
        return automataEstructurasControl2.ejecutarAutomata(flujo);
    }
    
    public Lexema automataIdentificador(FlujoCaracteres flujo){
        return automataIdentificador.ejecutarAutomata(flujo);
    }
    
    public Lexema automataTiposDatos(FlujoCaracteres flujo){
        return automataTiposDatos.ejecutarAutomata(flujo);
    }
    
    public Lexema automataOperadorAritmetico(FlujoCaracteres flujo){
        return automataOperadorAritmetico.ejecutarAutomata(flujo);
    }
    
    public Lexema automataOperadorAsignacion(FlujoCaracteres flujo){
        return automataOperadorAsignacion.ejecutarAutomata(flujo);
    }
    
    public Lexema automataOperadorEspecial1(FlujoCaracteres flujo){
        return automataOperadorEspecial1.ejecutarAutomata(flujo);
    }
    
    public Lexema automataOperadorEspecial2(FlujoCaracteres flujo){
        return automataOperadorEspecial2.ejecutarAutomata(flujo);
    }
    
    public Lexema automataOperadorLogico(FlujoCaracteres flujo){
        return automataOperadorLogico.ejecutarAutomata(flujo);
    }
    
    public Lexema automataOperadorRelacional1(FlujoCaracteres flujo){
        return automataOperadorRelacional1.ejecutarAutomata(flujo);
    }
    
    public Lexema automataOperadorRelacional2(FlujoCaracteres flujo){
        return automataOperadorRelacional2.ejecutarAutomata(flujo);
    }
    
    public Lexema automataReservadaBucles(FlujoCaracteres flujo){
        return automataReservadaBucles.ejecutarAutomata(flujo);
    }
    
    public Lexema automataReservadaCast(FlujoCaracteres flujo){
        return automataReservadaCast.ejecutarAutomata(flujo);
    }
    
    public Lexema automataReservadaHttp(FlujoCaracteres flujo){
        return automataReservadaHttp.ejecutarAutomata(flujo);
    }
    
    public Lexema automataReservadaHttpRequest1(FlujoCaracteres flujo){
        return automataReservadaHttpRequest1.ejecutarAutomata(flujo);
    }
    
    public Lexema automataReservadaHttpRequest2(FlujoCaracteres flujo){
        return automataReservadaHttpRequest2.ejecutarAutomata(flujo);
    }
    
    public Lexema automataReservadaMain(FlujoCaracteres flujo){
        return automataReservadaMain.ejecutarAutomata(flujo);
    }
    
    public Lexema automataReservadaNulo(FlujoCaracteres flujo){
        return automataReservadaNulo.ejecutarAutomata(flujo);
    }
    
    public Lexema automataReservadaStream(FlujoCaracteres flujo){
        return automataReservadaStream.ejecutarAutomata(flujo);
    }
    
    public Lexema automataReservadaValorLogico(FlujoCaracteres flujo){
        return automataReservadaValorLogico.ejecutarAutomata(flujo);
    }
    
    public Lexema automataReservadaVerbosHttp(FlujoCaracteres flujo){
        return automataReservadaVerbosHttp.ejecutarAutomata(flujo);
    }
    
    public Lexema automataValorNumerico(FlujoCaracteres flujo){
        return automataValorNumerico.ejecutarAutomata(flujo);
    }
    
     public Lexema automataValorCadena(FlujoCaracteres flujo){
        return automataValorCadena.ejecutarAutomata(flujo);
    }
}
