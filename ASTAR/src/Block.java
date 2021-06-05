import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Block extends Rectangle
{
	public static ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8));
	public static int range = 8; 
	
	private int c1, c2 , c3, num ; 
	public Block(int x, int y, int c1, int c2 , int c3)
	{
		this.height = 270; 
		this.width = 270; 
		
		this.x = x; 
		this.y=y; 
		this.c1 = c1; 
		this.c2 = c2; 
		this.c3 = c3; 
		setNum(); 
	}
	
	public void setxPos(int newx)
	{
		this.x = newx; 
		
	}
	public void setyPos( int newy )
	{
		this.y = newy; 
		
	}
	
	public void draw(Graphics g)
	{
		g.setColor(new Color(this.c1,this.c2,this.c3));
		g.fillRect(this.x, this.y,width, height);
		
		g.setColor(Color.white);
		g.setFont(new Font("Sans Seriff", Font.BOLD, 30));
		g.drawString(""+num, this.x+(width/2), this.y+(height/2));
		
		
		
	}

	public int getNum()
	{
		return num;
	}

	public void setNum()
	{
		boolean looking = true; 
		Random rand = new Random(); 
		while(looking)
		{
			try
			{
				int randNum = rand.nextInt(Block.range);
				this.num=Block.numbers.get(randNum); 
				
				Block.numbers.remove(randNum); 
				looking =false; 
			}catch(Exception e )
			{
				continue; 
			}
		}
		
		Block.range-=1; 
		/*while(looking)
		{
			
		}*/
	}
}
