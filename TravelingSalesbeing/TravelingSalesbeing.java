//TravelingSalesbeing.java
//McKenzie Bradley for CS301, Fall 2013

package travelingSalesbeing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TravelingSalesbeing extends JFrame implements ActionListener
{
	Map theMap;
	JPanel northPanel;
	JButton add;
	int amount2;

	public static void main (String[] args )
	{
		new TravelingSalesbeing();
	}

	public TravelingSalesbeing()
	{
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setTitle("Traveling Salesbeing");
		setLayout(new BorderLayout());

		northPanel= new JPanel();
		add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FlowLayout() );

		add = new JButton("More Points");
		northPanel.add(add);
		add.addActionListener(this);

		theMap = new Map( this );

		setSize( new Dimension(600,600) );
		setVisible(true);
	}

	@Override
	public void paint( Graphics g )
	{
		super.paint(g);

		theMap.drawMe(g);
	}


	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==add) {theMap.addMoreDots(1);}

		repaint();
	}
}
