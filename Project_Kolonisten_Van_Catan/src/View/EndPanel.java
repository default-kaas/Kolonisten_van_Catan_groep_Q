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
import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.EndController;

public class EndPanel extends JPanel {
	private EndController endController;

	public EndPanel(EndController endController) {
		this.endController = endController;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) (screenSize.getHeight() * 0.8);
		int width = (int) (screenSize.getWidth() * 0.8);

		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(new Color(57, 121, 186));

	}
}