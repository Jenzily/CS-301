//Vertex.java
//McKenzie Bradley for CS 301, Fall 2013

package travelingSalesbeing;

import java.awt.*;
import java.util.*;

public class Vertex
{
	LinkedList <Edge> edges; //Edges connected to this vertex

	int x,y; //Coordinates
	int ident;
	String identS;
	Boolean visited;

	Path bestPath;

	public Vertex()
	{
		visited = false;
		edges = new LinkedList <Edge> ();
		bestPath = new Path();
	}

	public void setCoor(int x1, int y1)
	{
		x=x1;
		y=y1;
	}

	public void setIdent(int ident1)
	{
		ident = ident1;
		identS = Integer.toString(ident);
	}

	public Path finishCircuit(int dispair, Vertex v)
	{
		doSpace(10-dispair);
		System.out.println(ident);
		visited = true;

		bestPath.cost = 100000000;

		if(dispair == 0) //Last being visited
		{
			Iterator <Edge> it = edges.iterator();
			Boolean match = false;
			while(!match && it.hasNext())
			{
				Edge f = it.next();

				if(f.fromVertex==v)
				{
					Path p = new Path();
					p.add(f);
					bestPath = p;
					match = true;
				}
			}
		}
		else
		{
			for(int i = 0; i<dispair; i++)
			{
				Iterator <Edge> it = edges.iterator();
				while(it.hasNext())
				{
					Edge e = it.next();
					Vertex c = e.fromVertex;

					if(!c.visited)
					{
						Path p = new Path();
						p = c.finishCircuit(dispair-1, v);
						p.add(e);

						if(p.cost<bestPath.cost)
						{
							bestPath = p;
						}
					}
				}
			}
		}


		visited = false;
		return bestPath;
	}
	
	public void doSpace(int spaces)
	{
		for(int i = 0; i<spaces; i++)
		{
			System.out.print("  ");
		}
	}

	public void drawMe(Graphics g)
	{
		g.setColor(Color.blue);

		g.fillOval( x, y, 10, 10 );
		g.drawString(identS,x,y);

		Iterator <Edge> it = edges.iterator();
		while( it.hasNext() )
		{
			Edge f = it.next();
			f.drawMe(g, Color.green);
		}
	}
}
