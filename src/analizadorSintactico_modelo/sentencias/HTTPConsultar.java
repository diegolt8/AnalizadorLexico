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
public class HTTPConsultar extends Sentencia {

    private Lexema url;
    private HTTPParametros parametros;

    public HTTPConsultar() {
    }

    public Lexema getUrl() {
        return url;
    }

    public void setUrl(Lexema url) {
        this.url = url;
    }

    public HTTPParametros getParametros() {
        return parametros;
    }

    public void setParametros(HTTPParametros parametros) {
        this.parametros = parametros;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        if (url != null) {
            hijos.add(new Terminal(url));
        }

        if (parametros != null) {
            hijos.add(parametros);
        }

        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        str.append("\n\t\t").append("axios.get").append("(").append(url.getLexema());

        if (parametros != null) {
            if (parametros.getTerminoLiteral() != null) {
                str.append("/").append(parametros.getTerminoLiteral().parse());
            } else {
                str.append(", {" + "\n" + "\t\t params: \n");
                str.append("\t\t").append(parametros.parse());
                str.append("}");
            }
        }

        str.append(")");
        str.append("\n\t\t.then( res => {" + "\n" + "\t\t  console.log(res.data) } )" + "\n" + "\t\t.catch(function (error) {" + "\n" + "\t\t console.log(error) })");

        return str.toString();
    }

    @Override
    public String toString() {
        return "Consultar";
    }
    
    /**
     *__main__()"
Retorno 0;
"

Met hola_mundo()"
Impr('Hola mundo');
"

Met post()"
 a.Crear('http://jsonplaceholder.typicode.com/posts').Cuerpo({'a':'3'});
"

Met getOne()"
a.Consultar('http://jsonplaceholder.typicode.com/posts').Parametros().Query({'id':'1'});
"

Met get()"
a.Consultar('http://jsonplaceholder.typicode.com/posts');
"

Met delete()"
a.Eliminar('http://jsonplaceholder.typicode.com/posts').Parametros().Path('1');
"

Met put()"
a.Modificar('http://jsonplaceholder.typicode.com/posts/1').Parametros().Query({'userId':'1'}).Cuerpo({'userId':'2'});
"

Met unoAlDiez()"
 Para(Ent i = 0; i<10; i++)"
   Impr('i');
"
"

Met mientras()"
Mientras(i<10)"
  Impr('i');
"
"

Met hacerMientras()"
Hacer"
 Impr('i');
"Mientras(i<10);
"

Met entrada()"
Entr(a);
"

Met si()"
 Si(Verdadero)"
   Impr('i');
 " Sino "
   Impr('j');
"
"
Met parametro(Ent i)"
  Impr('Parametro');
"
Met listaParametro(Ent a, Var a)"
  Impr('Lista parametros');
"
     */

}
