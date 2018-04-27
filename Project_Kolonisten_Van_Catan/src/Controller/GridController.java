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
	
	public void checkCoordinates() {
		/*
		 * DIT IS ALLEEN VOOR RECHTE ZIJDE
		 * forloop door lijst coördinaten
		 *  get value met index i
		 * for(int i=0; i<arraysize; i++){
              private int x1 = x locatie eerste hoekpunt;
              private int y1 = y locatie eerste hoekpunt;
              private int x2 = x locatie tweede hoekpunt;
              private int y2 = y locatie tweede hoekpunt;
              private int counter;
              private int location;
              
              if statement checken of x,y er tussen valt
              if(x>(x1-5) && x<(x2+5) && y>(y1-5) && y<y2+5){
              	location = i;
              	counter++;
              }
         }
         
         if(counter = 1){
         	dan heb je de straat
         }
         
         SCHUINE ZIJDE ???
         for(int i=0; i<arraysize; i++){
              private int x1 = x locatie eerste hoekpunt;
              private int y1 = y locatie eerste hoekpunt;
              private int x2 = x locatie tweede hoekpunt;
              private int y2 = y locatie tweede hoekpunt;
              private double corner = 70;
              private double tan(corner);
              private int counter;
              private int location;
              
              if statement checken of x,y er tussen valt
              if(x>(x1-5) && x<(x2+5) && y>(y1-5) && y<y2+5){
              	location = i;
              	counter++;
              }
         }
         
         if(counter = 1){
         	dan heb je de straat
         }
         
         
         DIT IS VOOR DORP
        
         for(int i=0; i<arraysize; i++){
              private int x1 = x locatie hoekpunt;
              private int y1 = y locatie hoekpunt;
              private int r = 10;
              private int counter;
              private int location;
              
              if statement checken of x,y er tussen valt
              if((x-x1)^2 + (y-y1)^2 < r^2 || (x-x1)^2 + (y-y1)^2 == r^2){
              	location = i;
              	counter++;
              }
         }
         
         if(counter = 1){
         	dan heb je het hoekpunt dorp
         }
         
          DIT IS VOOR STAD
        
         for(int i=0; i<arraysize; i++){
              private int x1 = x locatie hoekpunt;
              private int y1 = y locatie hoekpunt;
              private int r = 10;
              private int counter;
              private int location;
              
              if statement checken of x,y er tussen valt
              if((x-x1)^2 + (y-y1)^2 < r^2 || (x-x1)^2 + (y-y1)^2 == r^2){
              	location = i;
              	counter++;
              }
         }
         
         if(counter = 1){
         	dan heb je het hoekpunt stad
         	controleer of er wel een dorp staat
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
