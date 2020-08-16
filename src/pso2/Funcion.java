/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pso2;

/**
 *
 * @author brau
 */
public abstract class Funcion {
    protected double Min;
    protected double Max;
    public abstract double calcular(double[] vector);

    public Funcion(double Min, double Max) {
        this.Min = Min;
        this.Max = Max;
    }

    public double getMin() {
        return Min;
    }

    public double getMax() {
        return Max;
    }
    
}
