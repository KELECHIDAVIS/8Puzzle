import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable
{
	
	private Thread gameThread; 
	public int MOVES = 0, zeroX=2,zeroY=2; 
	public Block block1 = new Block(0, 20,100,100,145) ;
	public Block block2 = new Block(270, 20,255,100,145) ;
	public Block block3 = new Block(540, 20,155,100,145) ;
	public Block block4 = new Block(0, 290,55,0,145) ;
	public Block block5 = new Block(270,290,255,155,145) ;
	public Block block6 = new Block(540,290,55,100,145) ;
	public Block block7 = new Block(0,560,255,0,145) ;
	public Block block8 = new Block(270, 560,100,100,245) ;
	
	public final int WIDTH  =830  , HEIGHT = 870; 
	public ArrayList<Block> blocks = new ArrayList<Block>(); 
	public Block[][] table = new Block[3][3];
	public int[][] realtable= new int[3][3]; 
	
	
	
	
	
	Panel()
	{
		this.setSize(new Dimension(WIDTH,HEIGHT)); 
		this.setOpaque(true);
		
		gameThread = new Thread(this); 
		gameThread.start();
		
		/*blocks.add(block1); 
		blocks.add(block2); 
		blocks.add(block3); 
		blocks.add(block4); 
		blocks.add(block5); 
		blocks.add(block6); 
		blocks.add(block7); 
		blocks.add(block8); */
	
		table[0][0]=block1; 
		realtable[0][0]=block1.getNum(); 
		
		table[0][1]=block2; 
		realtable[0][1]=block2.getNum(); 
		table[0][2]=block3;
		realtable[0][2]=block3.getNum(); 
		table[1][0]=block4; 
		realtable[1][0]=block4.getNum(); 
		table[1][1]=block5; 
		realtable[1][1]=block5.getNum(); 
		table[1][2]=block6; 
		realtable[1][2]=block6.getNum(); 
		table[2][0]=block7;
		realtable[2][0]=block7.getNum(); 
		table[2][1]=block8; 
		realtable[2][1]=block8.getNum(); 
		realtable[2][2]=0; 
		
		printRealTable(); 
		
	}

	@Override
	public void run()
	{
		long lastTime = System.nanoTime() ; 
		long timer = System.currentTimeMillis(); 
		
		final double ns = 1000000000.0/ 60.0; 
		double delta = 0; 
		int frames=0;
		int updates = 0; 
		while(true)
		{
			
			long now = System.nanoTime(); 
			delta += (now-lastTime)/ns; 
			lastTime=now; 
			while(delta>=1)
			{
				update(); 
				updates++; 
				delta--; 
			}
			
			frames++; 
			
			if(System.currentTimeMillis()-timer>1000)
			{
				timer+=1000; 
				
				frames=0; 
				updates=0; 
				repaint(); 
			}
		}
		
	}
	
	public void printRealTable()
	{
		for(int i=0 ; i<realtable.length; i++)
		{
			for(int y=0 ; y<realtable[i].length; y++)
			{
				System.out.print(realtable[i][y]+ " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
	}
	
	public void right()
	{
		// change position with zero 
		int dummy; 
		dummy = realtable[zeroY][zeroX-1] ; 
		realtable[zeroY][zeroX-1] =realtable[zeroY][zeroX]; 
		realtable[zeroY][zeroX] = dummy;  
		
		zeroX-=1; 
		
		// print the result 
		printRealTable(); 
	}
	public void left()
	{
		// change position with zero 
		int dummy; 
		dummy = realtable[zeroY][zeroX+1] ; 
		realtable[zeroY][zeroX+1] =realtable[zeroY][zeroX]; 
		realtable[zeroY][zeroX] = dummy;  
		
		zeroX+=1; 
		
		// print the result 
		printRealTable(); 
	}
	public void up()
	{
		// change position with zero 
		int dummy; 
		dummy = realtable[zeroY+1][zeroX] ; 
		realtable[zeroY+1][zeroX] =realtable[zeroY][zeroX]; 
		realtable[zeroY][zeroX] = dummy;  
		
		zeroY+=1; 
		
		// print the result 
		printRealTable(); 
	}
	public void down()
	{
		// change position with zero 
		int dummy; 
		dummy = realtable[zeroY-1][zeroX] ; 
		realtable[zeroY-1][zeroX] =realtable[zeroY][zeroX]; 
		realtable[zeroY][zeroX] = dummy;  
		
		zeroY-=1; 
		
		// print the result 
		printRealTable(); 
	}
	
	public void update()
	{
		// game logic
		
	}
	
	public void paint(Graphics g )
	{
		//rendering
		super.paint(g);
		g.setFont(new Font("Sans Seriff", Font.BOLD, 15));
		g.drawString("MOVES: "+MOVES, 3, 14);
		
		for(int i =0; i<table.length; i++)
		{
			for(int y = 0; y<table[i].length; y++)
			{
				if(table[i][y]!=null)
				{
					table[i][y].draw(g);
				}
			}
		}
		
		
		
		
	}

	
	
	
}
