//Objects.java
//McKenzie Bradley for CS301, Fall 2013

package storage;

import java.awt.*;

public class Objects 
{
	Objects parent;
	Objects leftie;
	Objects rightie;
	int num;
	
	public Objects()
	{
		parent=leftie=rightie=null;
	}
	
	public void setValue(int num1) //Sets the value of this object
	{
		num = num1;
	}
	
	public int getValue() //Returns the value of this object
	{
		return num;
	}
	
	public void setLeftie(Objects l) //Sets the left leaf
	{
		leftie = l;
	}
	
	public void setRightie(Objects r) //Sets the right leaf
	{
		rightie = r;
	}
}
