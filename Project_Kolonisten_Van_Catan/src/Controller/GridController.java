package Controller;

import View.GridPanel;

public class GridController {
	private GridPanel gridPanel;
	private int x;
	private int y;
	
	public GridController() {
		gridPanel = new GridPanel();
		x = gridPanel.getX();
		y = gridPanel.getY();
		
	}
	
	public void checkCoördinates() {
		/*
		 * DIT IS ALLEEN VOOR RECHTE ZIJDE
		 * forloop door lijst coördinaten
		 * for(int i=0; i<arraysize; i++){
              get value met index i
              if statement checken of x,y er tussen valt
              if(x>linkerzijde && x<rechterzijde && y> bovenzijde && y<onderzijde){
              value met index i is de straat
         }
		 */
	}
	
	public void showStreets() {
		
	}
	
	public void showTowns() {
		
	}
	
	public void showCities() {
		
	}
	
}
