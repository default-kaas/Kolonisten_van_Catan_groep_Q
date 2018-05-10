package View;

import java.awt.Color;
import java.awt.Graphics;
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

	}
}