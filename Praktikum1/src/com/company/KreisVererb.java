package com.company;

public class KreisVererb extends Point
{
    private int r;

    public KreisVererb()
    {
        super();
        r = 0;
    }

    public KreisVererb(KreisVererb k)
    {
        super(k);
        r = k.r;
    }

    public KreisVererb(int x, int y, int r)
    {
        super(x, y);
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
