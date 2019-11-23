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
public class HTTPCrear extends Sentencia {

    private Lexema url;
    private JSON json;

    public HTTPCrear() {
    }

    public Lexema getUrl() {
        return url;
    }

    public void setUrl(Lexema url) {
        this.url = url;
    }

    public JSON getJson() {
        return json;
    }

    public void setJson(JSON json) {
        this.json = json;
    }
    
    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();
        
        if (url != null) {
            hijos.add(new Terminal(url));
        }
        
        if (json != null) {
            hijos.add(json);
        }
        
        return hijos;
    }

    @Override
    public String parse() {
        StringBuilder str = new StringBuilder();
        str.append("\n\t\t").append("axios.post").append("(").append(url.getLexema()).append(", ");
        str.append(json.parse());
        str.append(")");
        str.append("\n\t\t.then( res => {" + "\n" + "\t\t  console.log(res.data) } )" + "\n" + "\t\t.catch(function (error) {" + "\n" + "\t\t console.log(error) })");
        return str.toString();
    }

    @Override
    public String toString() {
        return "Crear";
    }
    
}

/*
__main__()"
a.Crear('http://jsonplaceholder.typicode.com/posts').Cuerpo({'a':'3'});
a.Consultar('http://jsonplaceholder.typicode.com/posts').Parametros().Query({'id':'1'});
a.Eliminar('http://jsonplaceholder.typicode.com/posts').Parametros().Path({'1'});
Retorno 0;
"
*/

/*
__main__()"
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
a.Eliminar('http://jsonplaceholder.typicode.com/posts').Parametros().Path({'1'});
"

Met put()"
 
"



*/