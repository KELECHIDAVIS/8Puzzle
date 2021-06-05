import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener
{
	private Panel panel ; 
	
	public Key(Panel panel )
	{
		this.panel= panel ; 
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		
		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP: 
			System.out.println("up ");
			
			boolean breaker =false; 
			for(int i = 0; i<panel.table.length; i++)
			{
				for(int y=0; y<panel.table[i].length; y++)
				{
					if(panel.table[i][y]!=null)
					{
						if(i!=0)//seeing if the block is already on the edge 
						{
							if(panel.table[i-1][y]==null)
							{
								if(panel.table[i][y].getY()>50)
								{
									panel.table[i][y].setyPos((int)(panel.table[i][y].getY()-270));
									panel.MOVES++; 
									Block temp ;
									temp = panel.table[i][y]; 
									panel.table[i][y] = null; 
									panel.table[i-1][y] = temp;  // this switches the places
									
									
									
									panel.up(); 
									breaker =true; 
									break;  
								}else
								{
									
								} 
							}
						}
						
					}
					
				}
				if(breaker)
				{
					break; 
				}
			}
			
			
			break; 
		case KeyEvent.VK_DOWN: 
			
			System.out.println("down");
			boolean b2 =false; 
			for(int i = 0; i<panel.table.length; i++)
			{
				for(int y=0; y<panel.table[i].length; y++)
				{
					if(panel.table[i][y]!=null)
					{
						if(i!=2)//seeing if the block is already on the edge 
						{
							if(panel.table[i+1][y]==null)
							{
								if(panel.table[i][y].getY()+270<panel.HEIGHT-60)
								{
									panel.table[i][y].setyPos((int)( panel.table[i][y].getY()+270));
									panel.MOVES++; 
									Block temp ;
									temp = panel.table[i][y]; 
									panel.table[i][y] = null; 
									panel.table[i+1][y] = temp;  // this switches the places 
									
									
									panel.down(); 
									b2 = true; 
									break; 
									
								}else
								{
									System.out.println("no");
								} 
							}
						}
						
					}
					
				}
				if(b2)
				{
					break; 
				}
			}
			
			
			
			break; 
		case KeyEvent.VK_LEFT: 
			System.out.println("left");
			boolean b3 = false;  
			for(int i = 0; i<panel.table.length; i++)
			{
				for(int y=0; y<panel.table[i].length; y++)
				{
					
					if(panel.table[i][y]!=null)
					{
						if(y!=0)//seeing if the block is already on the edge 
						{
							if(panel.table[i][y-1]==null)//seeing if the place they want to go is empty
							{
								if(panel.table[i][y].getX()>0)
								{
									panel.table[i][y].setxPos((int)( panel.table[i][y].getX()-270));
									panel.MOVES++; 
									Block temp ;
									temp = panel.table[i][y]; 
									panel.table[i][y] = null; 
									panel.table[i][y-1] = temp;  // this switches the places 
									
									
									panel.left();
									b3 =true; 
									break ;
								}else
								{
									
								}
							}
								
						}
					}
					
				}
				if(b3)
				{
					break; 
				}
			}
			
			
			break; 
		case KeyEvent.VK_RIGHT: 
			System.out.println("right");
			boolean b4 = false; 
			for(int i = 0; i<panel.table.length; i++)
			{
				for(int y=0; y<panel.table[i].length; y++)
				{
					if(panel.table[i][y]!=null)
					{
						if(y!=2)//seeing if the block is already on the edge 
						{
							if(panel.table[i][y+1]==null)//seeing if the place they want to go is empty 
							{
								if(panel.table[i][y].getX()+270<panel.WIDTH-30)
								{
									panel.table[i][y].setxPos((int)( panel.table[i][y].getX()+270));
									panel.MOVES++; 
									Block temp ;
									temp = panel.table[i][y]; 
									panel.table[i][y] = null; 
									panel.table[i][y+1] = temp; 
									
									panel.right();
									
									b4 = true; 
									break; 
									
								}else
								{
									
								}
							}
						}else
						{
							
						}
					}
					
				}
				if(b4)
				{
					break ; 
				}
			}
			
			
			
			
			break; 
		}

	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

}
