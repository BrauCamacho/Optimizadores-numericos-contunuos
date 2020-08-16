/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author brau
 */
public class Particula implements Comparable<Particula>{
   private double Fitness;
   private double[] vector;

    public Particula(double Fitness, double[] vector) {
        this.Fitness = Fitness;
        this.vector = vector;
    }

    public Particula(double[] vector) {
        this.vector = vector;
    }

    public Particula() {
    }

    public double getFitness() {
        return Fitness;
    }

    public void setFitness(double Fitness) {
        this.Fitness = Fitness;
    }

    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    @Override
    public int compareTo(Particula t) {
   if(this.Fitness < t.getFitness()){
       return -1;
   }else if(this.Fitness == t.getFitness()){
       return 0;
   }else{
       return 1;
   }
}
   
}
