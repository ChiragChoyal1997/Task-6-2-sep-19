package com.ioexamples;

import java.io.Serializable;

/**
 *
 * @author Chirag
 */
public class ThreeDGame implements Serializable{
    private int xpos;
    private int ypos;
    private int zpos;

    @Override
    public String toString() {
        return "ThreeDGame{" + "xpos=" + xpos + ", ypos=" + ypos + ", zpos=" + zpos + '}';
    }

    public ThreeDGame(int xpos, int ypos, int zpos) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.zpos = zpos;
    }
    
    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public int getZpos() {
        return zpos;
    }

    public void setZpos(int zpos) {
        this.zpos = zpos;
    }
    
    
    
    
}
