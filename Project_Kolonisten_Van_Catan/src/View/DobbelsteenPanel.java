package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DobbelsteenPanel extends JPanel {
	private ImageIcon dice;	
	private JLabel label1;

	private JButton myButton;
	private BufferedImage image;
	public DobbelsteenPanel() {

		myButton = new JButton("Throw Dice");
		
	
		
		// Dit is ff ORANGE voor een test, mag je weghalen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int Height = (int) (screenSize.getHeight() * 0.19);
		this.add(myButton);
		this.setPreferredSize(new Dimension(256, Height));
		this.setBackground(Color.WHITE);
		
		myButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				remove(myButton);
				dice = new ImageIcon("images/dice.png");
				label1 = new JLabel(dice);
				add(label1);
				validate();
			}
		});
		
		
		  try {
	            image = ImageIO.read(new File("images/dice.png"));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
	}
	
	
	
	  @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        int Height = (int) (screenSize.getHeight() * 0.19);
	        g.drawImage(image, 0, 0, 128 ,128, this);
	    }



}
