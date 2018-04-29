package Controller;

import View.GridPanel;

public class GridController {
	private GridPanel gridPanel;
	private int x;
	private int y;
	private int kind;
	//private int x1; x locatie eerste hoekpunt
    //private int y1; y locatie eerste hoekpunt
    //private int x2; x locatie tweede hoekpunt
    //private int y2; y locatie tweede hoekpunt
	
	
	
	public GridController() {
		gridPanel = new GridPanel();
		x = gridPanel.getX();
		y = gridPanel.getY();
		
	}
	/*
	public void checkCoordinates() {
		
		 * forloop door lijst coördinaten
		 *  get value met index i
		       
         ALLE ZIJDE
         for(int i=0; i<arraysize; i++){
         	  x1 = x locatie eerste hoekpunt
         	  y1 = y locatie eerste hoekpunt
         	  x2 = x locatie tweede hoekpunt
         	  y2 = y locatie tweede hoekpunt
              private int counter;
              private int location;
              
              if statement checken of x,y er tussen valt
              
              whichKind(x1, y1, x2, y2);
              	if(kind == 1){
              	
              	}
              	else if(kind == 2){
              	
              	}
              	else if(kind == 3){
              	
              	}
              
              
              
              
              rechte lijn
	              	if(x>(x1-5) && x<(x2+5) && y>(y1-5) && y<y2+5){
	              	location = i;
	              	counter++;
	              }
	              
              schuine lijn
              else if(){
              
              }
                   
         }
         
         if(counter = 1){
         	dan heb je de straat
         }
         
         
         DIT IS VOOR DORP
        
         for(int i=0; i<arraysize; i++){
              private int r = 10;
              private int counter;
              private int location;
              
              if statement checken of x,y er tussen valt
              if((x-x1)*(x-x1) + (y-y1)*(x-y1)< r*r || (x-x1)*(x-x1) + (y-y1)*(x-y1) == r*r){
              	location = i;
              	counter++;
              }
         }
         
         if(counter = 1){
         	dan heb je het hoekpunt dorp
         }
         
          DIT IS VOOR STAD
        
         for(int i=0; i<arraysize; i++){
              private int r = 10;
              private int counter;
              private int location;
              
              if statement checken of x,y er tussen valt
              if((x-x1)*(x-x1) + (y-y1)*(x-y1)< r*r || (x-x1)*(x-x1) + (y-y1)*(x-y1) == r*r){
              	location = i;
              	counter++;
              }
         }
         
         if(counter = 1){
         	dan heb je het hoekpunt stad
         	controleer of er wel een dorp staat
         }
		 
	}
	
	welke schuine lijn
	public void whichKind(int xh1, int yh1, int xh2, int yh2){
	
		if(xh1 = xh2){
			recht
			kind == 1;
		}
              if(y1<yh2){
              	if(xh1>xh2){
              		ZWNO
              		kind == 2;
              	}
              	else{
          			NWZO
          			kind == 3;
              	}
              }
              else{
              	if(xh2>xh1){
              		ZWNO
              		kind == 2;
              	}
              	else{
          			NWZO
          			kind == 3;
              	}
              }
	}
	*/
	public void showStreets() {
		
	}
	
	public void showTowns() {
		
	}
	
	public void showCities() {
		
	}
	
}
