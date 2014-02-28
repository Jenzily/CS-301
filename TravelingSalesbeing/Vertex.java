//Vertex.java
//McKenzie Bradley for CS 301, Fall 2013

package travelingSalesbeing;

import java.awt.*;
import java.util.*;

public class Vertex
{
	LinkedList <Edge> edges; //Edges connected to this vertex

	int x,y; //Coordinates
	int ident; //Identifying number of this vertex
	static int identCount = 0; //Identifying number of next vertex
	String identS; //String of ident for printing
	Boolean visited; //True if has been visited in search


	public Vertex()
	{
		visited = false;
		edges = new LinkedList <Edge> ();
		ident = Vertex.identCount;
		Vertex.identCount++;
		identS = Integer.toString(ident);
	}

	public void setCoor(int x1, int y1)
	{
		x=x1;
		y=y1;
	}

	/*public void setIdent(int ident1)
	{
		ident = ident1;
		identS = Integer.toString(ident);
	}*/

	public Path finishCircuit(int dispair, Vertex home, Graphics g)
	{
		visited = true;

		Path bestPath = new Path();
		bestPath.cost = 100000000;

		if(dispair == 0) //Last being visited
		{
			Iterator <Edge> it = edges.iterator();
			Boolean match = false;
			
			//Looks through all this vertex's edges and find the one that goes home
			while(!match && it.hasNext()) 
			{
				Edge f = it.next();

				if(f.fromVertex.ident == home.ident)
				{
					Path p = new Path();
					bestPath = p;
					bestPath.add(f);
					match = true;
				}
			}
		}
		else
		{
			Iterator <Edge> it = edges.iterator();
			
			//Finds all possible paths through nodes not visited
			while(it.hasNext())
			{
				Edge e = it.next();
				Vertex c = e.fromVertex;

				if(!c.visited)
				{
					e.drawMe(g, Color.black); //Draws edge
					Path p = c.finishCircuit(dispair-1, home, g);
					p.add(e);
					e.drawMe(g, Color.green); //Un-draws edge

					if(p.cost<bestPath.cost) //Sets bestPath
					{
						bestPath = p;
					}
				}
			}

		}


		visited = false;
		return bestPath;
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
