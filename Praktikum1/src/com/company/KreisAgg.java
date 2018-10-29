package com.company;

public class KreisAgg implements IArea
{
	private int r;
	private Point p;

	public KreisAgg(int x, int y, int r)
    {
        this.r = r;
        this.p = new Point(x,y);
	}

	public KreisAgg()
    {
        this.r = 0;
        this.p = new Point();
	}

	public KreisAgg(KreisAgg k)
    {
        this.r = k.r;
        this.p = new Point(k.p);
	}

	public KreisAgg clone()
    {
		return new KreisAgg(this);
	}

	public boolean equals(KreisAgg k)
    {
		return this.r == k.r && this.p.equals(k.p);
	}

	public double flaechenInhalt()
    {
		return Math.PI * this.r * this.r;
	}

	public String toString()
    {
		return "(x: " + this.p.x + ", y: " + this.p.y + ", r: " + r + ")";
	}
}