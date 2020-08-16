/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Optimizadores;

import Clases.Particula;
import Clases.Poblacion;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import org.apache.commons.math3.distribution.NormalDistribution;
import pso2.Funcion;
import pso2.Optimizador;

/**
 *
 * @author brau
 */
public class UMDA extends Optimizador{
    
    private LinkedList<Particula> p;

    public UMDA(int iter, int Idividuos, int Dimensiones, Funcion funcion) {
        super(iter, Idividuos, Dimensiones, funcion);
        calcular();
    }

    @Override
    public LinkedList<Particula> getP() {
        return p;
    }

    @Override
    public void calcular() {
    Poblacion poblacion = new Poblacion(this.Idividuos, this.Dimensiones, this.funcion.getMin(), this.funcion.getMax());
    p = poblacion.Nueva();
    for(int i =0;i < iter; i++){
    calcFit();
    Collections.sort(p);
    System.out.println(p.get(0).getFitness()+"  "+Arrays.toString(p.get(0).getVector()));
    //ver();
    //truncado();
    double [] medias = Medias();
    double [] varianzas = Varianzas(medias);
    Generar(medias, varianzas);
    }
    calcFit();
    }
    public double[] Medias(){
        double trunc =(double)p.size()*.30;
        double [] medias = new double[Dimensiones];
         for(int j =0; j < this.Dimensiones;j++){
            double sum =0;
        for(int i =0; i < (int)trunc;i++){
            sum += p.get(i).getVector()[j];
        }
        medias[j] = sum/trunc;
       }
       return medias;
    }
    public void calcFit(){
        for(int i =0; i < p.size();i++){
            p.get(i).setFitness(funcion.calcular(p.get(i).getVector()));
        }
    }
    public double[] Varianzas(double medias[]){
        double trunc =(double)p.size()*.30;
        double [] varianzas = new double[Dimensiones];
         for(int j =0; j < this.Dimensiones;j++){
            double sum =0;
        for(int i =0; i < (int)trunc;i++){
            sum +=Math.pow( p.get(i).getVector()[j] - medias[j],2);
        }
        varianzas[j] = sum/trunc;
       }
       return varianzas;
    }
    public void Generar(double[] Medias, double[] Desviaciones) {
       for(int i =0;i< Dimensiones; i++){
            if( Desviaciones[i] ==0){
           NormalDistribution nd = new NormalDistribution(Medias[i], Math.sqrt(1));
           for(int j =0;j< Idividuos; j++){
              p.get(j).getVector()[i] = nd.sample();
           }
            }else{
            NormalDistribution nd = new NormalDistribution(Medias[i], Math.sqrt(Desviaciones[i]));
           for(int j =0;j< Idividuos; j++){
              p.get(j).getVector()[i] = nd.sample();
           }
          }
       }
    }
    public void ver(){
        System.out.println("Completo");
        for(Particula par:  p){
            System.out.println(par.getFitness()+"  "+Arrays.toString(par.getVector()));
        }
        
    }
    public void truncado(){
        System.out.println("truncado");
        double trunc = Idividuos*.3;
        int d =0;
        for(Particula par:  p){
            if(d < (int)trunc){
            System.out.println(par.getFitness()+"  "+Arrays.toString(par.getVector()));
            }
            d++;
        }
        
    }
    
}
