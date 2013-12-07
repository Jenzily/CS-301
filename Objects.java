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
	
	public void setValue(int num1)
	{
		num = num1;
	}
	
	public int getValue()
	{
		return num;
	}
	
	/*public void setParent(String parent1)
	{
		parent = parent1;
	}*/
	
	public void setLeftie(Objects l)
	{
		leftie = l;
	}
	
	public void setRightie(Objects r)
	{
		rightie = r;
	}
	
    public boolean isLeftie()
    {
        boolean isLeftie = false;
        if ( parent != null )
        {
            if ( parent.leftie == this ) { isLeftie = true; }
        }
        return isLeftie;
    }
    
    public boolean isRightie()
    {
        boolean isRightie = false;
        if ( parent != null )
        {
            if ( parent.rightie == this ) { isRightie = true; }
        }
        return isRightie;
    }
    
    public boolean isLeaf()
    {
    	boolean isLeaf = false;
    	if(rightie==null && leftie==null)
    	{
    		isLeaf = true;
    	}
    	return isLeaf;
    }
}
