//Storage.java
//McKenzie Bradley for CS301, Fall 2013
/*
 * McKenzie:	"So...it didn't work...and then it did."
 * Allison:		"Eclipse is magic!"
 * 				"All hail the Eclipse!"
 * Elizabeth:	"Hooray!"
 * McKenzie:	"What religion are you? I'm a Finals-Week Ecliptist."
 * Allison:		"Last-days Church of Eclipse."
 * 				"Armaments Chapter 12, Verses 9 to 21:"
 * 				" 'First shalt thou take out the Holy Eclipse, 
 * 				then shalt thou count to 10 million, no more, no less. 
 * 				10 million shall be the number thou shalt count, 
 * 				and the number of the counting shall be 10 million. 
 * 				Four shalt thou not count, neither count thou two, 
 * 				excepting that thou then proceed to 10 million. Five is right out!!!' "
 */

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
		
		Objects y; //Object to travel around tree

		for(int i=0; i<10000000; i++)
		{
			int num = (int) (Math.random()*2000000000);
			
			if(tree.size()!=0) //Not first in tree
			{
				y = tree.get(0);
				addNumber(num, y);
			}
			else //First in tree
			{
				Objects x = new Objects(); //Object to store in tree
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
		if(y.getValue()<num) //Number being added on is greater than object value currently visiting - move right
		{	
			if(y.rightie!=null) //More to traverse
			{
				y = y.rightie;
				addNumber(num, y);
			}
			else //Reached end, attach
			{
				Objects x = new Objects();
				x.setValue(num);
				tree.add(x);
				y.setRightie(x);
			}
		}
		else if(y.getValue()>num) //Number being added on is less than object value currently visiting - move left
		{
			if(y.leftie!=null) //More to traverse
			{
				y = y.leftie;
				addNumber(num, y);
			}
			else //Reached end, attach
			{
				Objects x = new Objects();
				x.setValue(num);
				tree.add(x);
				y.setLeftie(x);
			}
		}
		else {} //If number is equal it has been attached to tree before, do not make duplicate
	}
	
	public static void newNumbers() //Generates next 10million numbers
	{
		int matches = 0; //Counts how many times a match is found
		
		for(int i=0; i<10000000; i++)
		{
			int numM = (int) (Math.random()*2000000000);
			Objects q = new Objects(); //Object to travel around tree
			q = tree.get(0);
			matches = matchNumbers(matches, numM, q);
		}
		
		System.out.println("There were " + matches + " matches");
	}
	
	public static int matchNumbers(int matches, int numM, Objects q) //Checks for matches
	{
		if(q.getValue()<numM) //Number to be matched is greater than the value of the currently visited object - move right
		{	
			if(q.rightie!=null) //More to traverse
			{
				q = q.rightie;
				matches = matchNumbers(matches, numM, q);
			}
			else{} //Nothing remains, no match
		}
		else if(q.getValue()>numM) //Number to be matched is less than the value of the currently visited object - move left
		{
			if(q.leftie!=null) //More to traverse
			{
				q = q.leftie;
				matches = matchNumbers(matches, numM, q);
			}
			else{} //Nothing remains, no match
		}
		else //Equals! Matches! Hooray! Increment matches
		{
			matches++; 
		}
		return matches;
	}
}
