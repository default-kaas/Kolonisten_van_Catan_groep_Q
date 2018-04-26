package View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class GridPanel extends JPanel implements MouseListener {
	//overlay grid
	private int x;
	private int y;
	
	public GridPanel() {
		/* set size of map
		this.setPreferredSize(preferredSize);
		*/
		
		this.addMouseListener(this);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub
		x = me.getX();
		y = me.getY();
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub
		
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
