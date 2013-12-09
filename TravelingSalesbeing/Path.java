package travelingSalesbeing;

import java.awt.*;
import java.util.*;

public class Path 
{
	int cost;

	LinkedList <Edge> pathSteps;

	public Path()
	{
		pathSteps = new LinkedList <Edge> ();
	}

	public void add(Edge e)
	{
		pathSteps.add(e);
		setCost();
	}

	public void setCost()
	{
		cost = 0;
		Iterator <Edge> it = pathSteps.iterator();

		while(it.hasNext())
		{
			Edge e = it.next();
			cost += e.length;
		}
	}

	public void drawMe(Graphics g)
	{
		Iterator <Edge> it = pathSteps.iterator();

		while(it.hasNext())
		{
			Edge e = it.next();
			e.drawMe(g, Color.black);
			System.out.println("Line is from " + e.fromVertex.ident + " to " + e.toVertex.ident);
		}

		System.out.println("The cost was " + cost);
	}
}
