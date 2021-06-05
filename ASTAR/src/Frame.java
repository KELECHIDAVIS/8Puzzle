import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame
{
	Frame()
	{
		this.setTitle("8 PUZZLE");
		this.setResizable(false);
		this.setVisible(true); 
		Panel panel = new Panel();
		this.setSize(new Dimension(panel.WIDTH,panel.HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		
		this.addKeyListener(new Key(panel));
		this.add(panel); 
		
	}
}
