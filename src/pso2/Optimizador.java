/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso2;

import Clases.Particula;
import Clases.Poblacion;
import java.util.LinkedList;

/**
 *
 * @author brau
 */
public abstract class Optimizador {
    protected int Idividuos;
    protected int Dimensiones;
    protected Funcion funcion;
    protected int iter;
    public abstract void calcular();
    public abstract LinkedList<Particula> getP();
    public Optimizador(int iter,int Idividuos, int Dimensiones, Funcion funcion) {
        this.iter = iter;
        this.Idividuos = Idividuos;
        this.Dimensiones = Dimensiones;
        this.funcion = funcion;
    }

}
