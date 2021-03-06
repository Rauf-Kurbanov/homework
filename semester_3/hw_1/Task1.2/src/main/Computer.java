package main;

import java.util.Random;

public class Computer {
    
    public Computer(OS os, boolean isInfected) {
        this.os = os;
        this.isInfected = isInfected;
        this.isInjured = this.isInfected;
    }
    
    public void attack(Computer aim) {

        Random r = new Random();
        int num = r.nextInt(100) + 1;
        
        if (isInfected() && num < aim.os.getProb()) {
            //aim.infect();
            aim.injure();
        }
    }
    
    protected boolean isInfected() {
        return isInfected;
    }
    
    protected boolean isInjured() {
        return isInjured;
    }
    
    protected void infect() {
        isInfected = true;
    }
    
    protected void injure() {
        isInjured = true;
    }
    protected OS os;
    
    protected boolean isInfected;
    
    protected boolean isInjured;
}
