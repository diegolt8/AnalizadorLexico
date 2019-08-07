/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.*;
import javax.swing.JFileChooser;
import vista.VentanaPrincipal;

/**
 *
 * @author diegoul818
 */
public class ctlCargadorArchivo{
    
    public JFileChooser seleccionar = new JFileChooser();
    public File archivo;
    public FileInputStream entrada;
    public FileOutputStream salida;
    /**
     * Metodo para cargar los archivos que se quieren mostrar en el textArea
     * @param archivo recibe el archivo que se quiere cargar
     * @return retorna el archivo que se cargo 
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

        } catch (Exception e) {

        }

        return codigo;

    }

}
