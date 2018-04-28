package Controller;

import View.GridPanel;

public class GridController {
	private GridPanel gridPanel;
	private int x;
	private int y;
	private int kind;
	//private int x1 = x locatie eerste hoekpunt;
    //private int y1 = y locatie eerste hoekpunt;
    //private int x2 = x locatie tweede hoekpunt;
    //private int y2 = y locatie tweede hoekpunt;
	
	
	
	public GridController() {
		gridPanel = new GridPanel();
		x = gridPanel.getX();
		y = gridPanel.getY();
		
	}
	/*
	public void checkCoordinates() {
		
		 * DIT IS ALLEEN VOOR RECHTE ZIJDE
		 * forloop door lijst coördinaten
		 *  get value met index i
		       
         ALLE ZIJDE
         for(int i=0; i<arraysize; i++){
              private int counter;
              private int location;
              
              if statement checken of x,y er tussen valt
              
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
	public void whichKind(){
	
	
		if(x1 = x2){
			kind == 1;
		}
              if(y1<y2){
              	if(x1>x2){
              		ZWNO
              	}
              	else{
          			NWZO
              	}
              }
              else{
              	if(x2>x1){
              		ZWNO
              	}
              	else{
          			NWZO
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
