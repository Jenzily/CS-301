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
	LinkedList <Vertex> vertices;
	TravelingSalesbeing theFriendsBasic;
	int amount = 4;
	int amount2 = 1;

	public Map( TravelingSalesbeing f1 )
	{
		theFriendsBasic = f1;
		vertices = new LinkedList <Vertex> ();

		makeDots(amount);
	}

	public void addMoreDots(int amount2)
	{
		Random coorMaker = new Random();
		for(int i = 0; i<amount2; i++)
		{
			int x = coorMaker.nextInt(400)+20;
			int y = coorMaker.nextInt(400)+50;
			Vertex v = new Vertex();
			v.setCoor(x,y);
			vertices.add(v);
		}

		makeLines();
	}

	public void makeDots(int amount)
	{
		Random coorMaker = new Random();
		for(int i = 0; i<amount; i++)
		{
			int x = coorMaker.nextInt(400)+20;
			int y = coorMaker.nextInt(400)+50;
			Vertex v = new Vertex();
			v.setCoor(x,y);
			vertices.add(v);
		}

		makeLines();
	}

	public void makeLines()
	{
		int vertexNums = vertices.size();
		//int lineNums = vertexNums-1;
		int j = 0;

		for(int l = 0; l<vertexNums; l++)
		{
			
			Vertex n = vertices.get(j);


			Iterator <Vertex> it = vertices.iterator();
			while(it.hasNext())
			{
				Vertex p = it.next();

				if(n!=p)
				{
					Edge m = new Edge(n,p);
					p.edges.add(m);
				}

			}

			j++;
		}


		Iterator <Vertex> it = vertices.iterator();
		int r = 0;

		while(it.hasNext())
		{
			Vertex n = it.next();
			n.setIdent(r);

			r++;
		}

		bestPath();
	}

	public void bestPath()
	{
		Vertex v = vertices.get(0);

		v.finishCircuit(vertices.size()-1, v);
		//v.finishCircuit(0,v);
		System.out.println("Finished bestPath");
	}

	public void drawMe( Graphics g )
	{
		Iterator <Vertex> it = vertices.iterator();
		while( it.hasNext())
		{
			Vertex a = it.next();
			a.drawMe(g);
		}

		Vertex b = vertices.get(0);
		b.bestPath.drawMe(g);
	}


}