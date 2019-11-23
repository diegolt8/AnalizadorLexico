/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico_controlador;

import java.io.*;
import javax.swing.JFileChooser;

/**
 *
 * @author diegoul818
 */
public class CargadorArchivo {

    public JFileChooser seleccionar = new JFileChooser();
    public File archivo;
    public FileInputStream entrada;
    public FileOutputStream salida;

    /**
     * Metodo para cargar los archivos que se quieren mostrar en el textArea
     *
     * @param archivo recibe el archivo que se quiere cargar
     * @return retorna un String con el codigo cargado del archivo
     */
    public String CargarArchivo(File archivo) {
        String codigo = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while ((ascci = entrada.read()) != -1) {
                char caracter = (char) ascci;
                codigo += caracter;
            }
        } catch (IOException e) {
            System.out.println("Error al intentar cargar el archivo.");
        }
        return codigo;
    }

    public String GuardarArchivo(File archivo, String documento) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] text = documento.getBytes();
            salida.write(text);
            mensaje = "Archivo guardado";
        } catch (Exception e) {

        }
        return mensaje;
    }
}
