/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Optimizadores;

import Clases.Particula;
import Clases.Poblacion;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import org.apache.commons.math3.random.RandomDataGenerator;
import pso2.Funcion;
import pso2.Optimizador;

/**
 *
 * @author brau
 */
public class PSO extends Optimizador {

    private LinkedList<Particula> p;
    private LinkedList<Particula> V;
    private RandomDataGenerator r;
    double fi = 4.1;
    double fi1 = 2.05;
    double fi2 = 2.05;
    double X = 2 / (fi - 2 + Math.sqrt(Math.pow(fi, 2) - 4 * fi));
     
    Particula Gbest;
    LinkedList<Particula> Pbest;
    public PSO(int iter, int Idividuos, int Dimensiones, Funcion funcion) {
        super(iter, Idividuos, Dimensiones, funcion);
        r = new RandomDataGenerator();
        calcular();
    }

    @Override
    public void calcular() {
        //System.out.println(X);
        Poblacion poblacion = new Poblacion(this.Idividuos, this.Dimensiones, this.funcion.getMin(), this.funcion.getMax());
        Poblacion vi = new Poblacion(this.Idividuos, this.Dimensiones, -1, 1);
        p = poblacion.Nueva();
        V = vi.Nueva();
        calcFit();
        Collections.sort(p);
        Gbest = p.get(0);
        Pbest = p;
        for (int i = 0; i < iter; i++) {
           // System.out.println("Iteracion");
            actualizarvi();
            actualizarp();
            calcFit();
            actualizarpbest();
            Gbest =actualizargbest(p);
            
        }

    }

    @Override
    public LinkedList<Particula> getP() {
        return p;
    }
    
    
    public void calcFit() {
        for (int i = 0; i < p.size(); i++) {
            p.get(i).setFitness(funcion.calcular(p.get(i).getVector()));
        }
    }
    public Particula actualizargbest(LinkedList<Particula> p){
        LinkedList<Particula> tmp = p;
        Collections.sort(tmp);
        System.out.println(tmp.get(0).getFitness()+"  "+Arrays.toString(tmp.get(0).getVector()));
        return tmp.get(0);
    }
    public void actualizarvi() {
        for (int i = 0; i < this.Idividuos; i++) {
            for (int j = 0; j < this.Dimensiones; j++) {
                V.get(i).getVector()[j] = this.X*(V.get(i).getVector()[j]+(r.nextUniform(0, fi1)*(Pbest.get(i).getVector()[j]- p.get(i).getVector()[j]))+(r.nextUniform(0, fi2)*(Gbest.getVector()[j]- p.get(i).getVector()[j])));
                if(V.get(i).getVector()[j] > 1){
                    V.get(i).getVector()[j] =1;
                }else if(V.get(i).getVector()[j]< -1){
                    V.get(i).getVector()[j] = -1;
                }
               // System.out.printf(" %f ",V.get(i).getVector()[j]);
            }
          //  System.out.println();
        }
    }
    public void actualizarp() {
        for (int i = 0; i < this.Idividuos; i++) {
            for (int j = 0; j < this.Dimensiones; j++) {
               p.get(i).getVector()[j]+=V.get(i).getVector()[j];
               if(p.get(i).getVector()[j] > funcion.getMax()){
                    p.get(i).getVector()[j] = funcion.getMax();
                }else if(p.get(i).getVector()[j]< funcion.getMin()){
                    p.get(i).getVector()[j] = funcion.getMin();
                }
            }
        }
    }
    public void actualizarpbest() {
        for (int i = 0; i < this.Idividuos; i++) {
            if(p.get(i).getFitness()< Pbest.get(i).getFitness()){
                Pbest.set(i, p.get(i));
            }
        }
    }
    public void ver(){
    }
}
