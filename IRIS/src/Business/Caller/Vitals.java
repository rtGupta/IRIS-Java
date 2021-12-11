/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Caller;

/**
 *
 * @author aarti
 */
public class Vitals {
    
    private double bodyTemp;
    private int lowBP;
    private int highBP;
    private int pulse;
    private int oxyLevel;

    public double getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(double bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public int getLowBP() {
        return lowBP;
    }

    public void setLowBP(int lowBP) {
        this.lowBP = lowBP;
    }

    public int getHighBP() {
        return highBP;
    }

    public void setHighBP(int highBP) {
        this.highBP = highBP;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public int getOxyLevel() {
        return oxyLevel;
    }

    public void setOxyLevel(int oxyLevel) {
        this.oxyLevel = oxyLevel;
    }
    
    
}
