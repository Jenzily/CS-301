//Map.java
//McKenzie Bradley for CS 301, Fall 2013

package travelingSalesbeing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Map extends Graph
{
	LinkedList <Vertex> vertices; //List of vertices
	TravelingSalesbeing theTravelingSalesman;
	int amount = 1; //How many to start with
	int amount2 = 1; //How many to add each button press
	
	Path bestPath; //The most efficient path

	public Map( TravelingSalesbeing f1 )
	{
		theTravelingSalesman = f1;
		vertices = new LinkedList <Vertex> ();

		makeDots(amount);
	}

	//Method called by the button (kept separate in order to change how many start with)
	public void addMoreDots(int amount2)
	{
		Random coorMaker = new Random();
		for(int i = 0; i<amount2; i++)
		{
			int x = coorMaker.nextInt(400)+50;
			int y = coorMaker.nextInt(400)+50;
			Vertex v = new Vertex();
			v.setCoor(x,y);
			vertices.add(v);
		}

		makeLines();
	}

	//Method to make dots initially
	public void makeDots(int amount)
	{
		Random coorMaker = new Random();
		for(int i = 0; i<amount; i++)
		{
			int x = coorMaker.nextInt(400)+50;
			int y = coorMaker.nextInt(400)+50;
			Vertex v = new Vertex();
			v.setCoor(x,y);
			vertices.add(v);
		}
		
		//assign idents to vertices
		/*Iterator <Vertex> it = vertices.iterator();
		int r = 0;
		while(it.hasNext())
		{
			Vertex n = it.next();
			n.setIdent(r);

			r++;
		}*/
		
		makeLines();
	}

	//Method to make edges. 
	public void makeLines()
	{
		int vertexNums = vertices.size(); //Number of vertices
		int j = 0;

		for(int l = 0; l<vertexNums; l++)
		{
			Vertex n = vertices.get(j); //Finds the jth item in list

			//Adds edge to every other vertex from j that is not j
			Iterator <Vertex> it = vertices.iterator();
			while(it.hasNext())
			{
				Vertex p = it.next();

				if(n.ident != p.ident)
				{
					Edge m = new Edge(n,p);
					p.edges.add(m);
				}

			}

			j++;
		}
	}

	//Gets bestPath
	public void bestPath(Graphics g)
	{
		Vertex v = vertices.get(0);

		bestPath = v.finishCircuit(vertices.size()-1, v, g);
		//v.finishCircuit(0,v);
		System.out.println("Finished bestPath");
	}

	public void drawMe( Graphics g )
	{
		
		//Draws all the vertices
		Iterator <Vertex> it = vertices.iterator();
		while( it.hasNext())
		{
			Vertex a = it.next();
			a.drawMe(g);
		}
		
		bestPath(g);

		//Draws the best path
		bestPath.drawMe(g);
	}


}