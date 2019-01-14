/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vincent
 */
public class FuzzyNumber {
    private double a, b, c;

    public FuzzyNumber(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public FuzzyNumber() {
    }

    public double getBilA() {
        return a;
    }

    public double getBilB() {
        return b;
    }

    public double getBilC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

}
