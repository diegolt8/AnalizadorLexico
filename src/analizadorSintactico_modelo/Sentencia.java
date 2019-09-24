/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico_modelo;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Pepe
 */
public abstract class Sentencia implements TreeNode{
   
    protected Sentencia raiz;
    protected List<Sentencia> hijos;        
    
    
    public abstract List<Sentencia> llenarHijos();

    public abstract String parse();
    
    public List<Sentencia> getHijos() {
        if (hijos == null) {
            llenarHijos();
        }
        return hijos;
    }   
    
    @Override
    public abstract String toString();
    
    @Override
    public TreeNode getChildAt(int i) {
        return getHijos().get(i);
    }

    @Override
    public int getChildCount() {
        return getHijos().size();
    }

    @Override
    public TreeNode getParent() {
        return raiz;
    }

    @Override
    public int getIndex(TreeNode node) {
        return getHijos().indexOf(node);
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return getHijos() == null;
    }

    @Override
    public Enumeration children() {
        return Collections.enumeration(hijos);
    }
}
