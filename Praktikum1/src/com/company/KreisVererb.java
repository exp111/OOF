package com.company;

public class KreisVererb extends Point
{
    private int r;

    public KreisVererb()
    {
        x = 0;
        y = 0;
        r = 0;
    }

    public KreisVererb(KreisVererb k)
    {
        x = k.x;
        y = k.x;
        r = k.r;
    }

    public KreisVererb(int x, int y, int r)
    {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    
    public void setRadius(int r)
    {
        this.r = r;
    }

    public int getRadius()
    {
        return r;
    }

    public String toString()
    {
        return "(x: " + x + ", y: " + y + ", r: "+ r +")";
    }
}
