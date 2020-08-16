/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Optimizadores;

import Clases.Particula;
import java.util.LinkedList;
import pso2.Funcion;
import pso2.Optimizador;

/**
 *
 * @author brau
 */
public class Genetico extends Optimizador{

    public Genetico(int iter, int Idividuos, int Dimensiones, Funcion funcion) {
        super(iter, Idividuos, Dimensiones, funcion);
    }

    @Override
    public void calcular() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Particula> getP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
