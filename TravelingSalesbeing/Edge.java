//Edge.java
//McKenzie Bradley for CS 301, Fall 2013

package travelingSalesbeing;

import java.awt.*;

public class Edge
{
	Vertex toVertex; //Vertex it is going to
	Vertex fromVertex; //Vertex it is coming from
	double length;

	public Edge( Vertex f, Vertex t )
	{
		fromVertex = f;
		toVertex = t;

		length = getLength();
	}

	public double getLength()
	{
		length = Math.sqrt(  ((toVertex.x-fromVertex.x)*(toVertex.x-fromVertex.x)) + ((toVertex.y-fromVertex.y)*(toVertex.y-fromVertex.y))  );
		return length;
	}

	public void drawMe(Graphics g, Color color)
	{
		Vertex f = fromVertex;
		Vertex t = toVertex;

		g.setColor(color);

		g.drawLine( f.x, f.y, t.x, t.y);
	}
}
