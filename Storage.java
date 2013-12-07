package storage;

import java.util.*;

public class Storage 
{
	static LinkedList<Objects> tree;
	
	public static void main(String[] args)
	{
		new Storage();
	}
	
	public Storage()
	{
		tree = new LinkedList<Objects>();
		
		generate();
	}
	
	public static void generate() //Method to generate first 10million numbers
	{
		Random numberGenerator = new Random();
		
		Objects y;

		for(int i=0; i<10000000; i++)
		{
			int num = (int) (Math.random()*2000000000);
			
			if(tree.size()!=0)
			{
				y = tree.get(0);
				addNumber(num, y);
			}
			else
			{
				Objects x = new Objects();
				x.setValue(num);
				tree.add(x);
				System.out.println("Starting generation");
			}
		}
		
		System.out.println("Finished generation");
		newNumbers();
	}
	
	public static void addNumber(int num, Objects y) //Puts first 10million numbers into tree
	{
		if(y.getValue()<num)
		{	
			if(y.rightie!=null)
			{
				y = y.rightie;
				addNumber(num, y);
			}
			else
			{
				Objects x = new Objects();
				x.setValue(num);
				tree.add(x);
				y.setRightie(x);
			}
		}
		else if(y.getValue()>num)
		{
			if(y.leftie!=null)
			{
				y = y.leftie;
				addNumber(num, y);
			}
			else
			{
				Objects x = new Objects();
				x.setValue(num);
				tree.add(x);
				y.setLeftie(x);
			}
		}
		else {}
	}
	
	public static void newNumbers() //Generates next 10million numbers
	{
		int matches = 0;
		
		for(int i=0; i<10000000; i++)
		{
			int numM = (int) (Math.random()*2000000000);
			Objects q = new Objects();
			q = tree.get(0);
			matches = matchNumbers(matches, numM, q);
		}
		
		System.out.println("There were " + matches + " matches");
	}
	
	public static int matchNumbers(int matches, int numM, Objects q) //Checks for matches
	{
		if(q.getValue()<numM)
		{	
			if(q.rightie!=null)
			{
				q = q.rightie;
				matches = matchNumbers(matches, numM, q);
			}
			else{}
		}
		else if(q.getValue()>numM)
		{
			if(q.leftie!=null)
			{
				q = q.leftie;
				matches = matchNumbers(matches, numM, q);
			}
			else{}
		}
		else
		{
			matches++; 
		}
		return matches;
	}
}
