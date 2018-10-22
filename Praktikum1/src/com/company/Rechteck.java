package com.company;

import com.company.Point;

public class Rechteck
{
	private int w;
	private int h;
	private Point p;

	public Rechteck()
    {
        this.w = 0;
        this.h = 0;
        this.p = new Point();
	}

	public Rechteck(int x, int y, int w, int h)
    {
        this.w = w;
        this.h = h;
        this.p = new Point(x,y);
	}

	public Rechteck(Rechteck r)
    {
        this.w = r.w;
        this.h = r.h;
        this.p = new Point(r.p);
	}

	public Rechteck clone()
    {
		return new Rechteck(this);
	}

	public boolean equals(Rechteck r)
    {
		return this.w == r.w && this.h == r.h && this.p.equals(r.p);
	}

	public int flächenInhalt()
    {
		return w * h;
	}

	public String toString()
    {
	    return "(x: " + this.p.x + ", y: " + this.p.y + ", w: " + w + ", h: " + h + ")";
	}
}