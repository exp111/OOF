package com.company;

import java.security.cert.PolicyNode;

public class Point
{
    protected int x;
    protected int y;

    public boolean equals(Point p)
    {
        return p.x == x && p.y == y;
    }

    public Point getLocation()
    {
        return this;
    }

    public void move(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

    public Point()
    {
        x = 0;
        y = 0;
    }

    public Point(Point p)
    {
        x = p.x;
        y = p.y;
    }

    public Point(int nx, int ny)
    {
        x = nx;
        y = ny;
    }

    public void setLocation(Point p)
    {
        x = p.x;
        y = p.y;
    }

    public void setLocation(int nx, int ny)
    {
        x = nx;
        y = ny;
    }

    public String toString()
    {
        return "(x: " + x + ", y: " + y + ")";
    }
}
