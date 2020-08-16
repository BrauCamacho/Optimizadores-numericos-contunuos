/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.LinkedList;
import org.apache.commons.math3.random.RandomDataGenerator;

/**
 *
 * @author brau
 */
public class Poblacion {
    private int P;
    private int D;
    private double Min;
    private double Max;

    public Poblacion(int P, int D, double Min, double Max) {
        this.P = P;
        this.D = D;
        this.Min = Min;
        this.Max = Max;
    }
    public LinkedList<Particula> Nueva(){
        LinkedList<Particula> p = new LinkedList<>();
         RandomDataGenerator rd = new RandomDataGenerator();
         for(int i =0; i < P;i++){
             double[] vector = new double[D];
             for(int j =0;j< D;j++){
                 vector[j] = rd.nextUniform(Min, Max);
             }
             p.add(new Particula(vector));
         }
         return p;
    }
}
