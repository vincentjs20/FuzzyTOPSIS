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
    private int a, b, c;

    public FuzzyNumber(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public FuzzyNumber() {
    }

    public int getBilA() {
        return a;
    }

    public int getBilB() {
        return b;
    }

    public int getBilC() {
        return c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

}
