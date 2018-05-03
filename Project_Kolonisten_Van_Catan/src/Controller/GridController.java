package Controller;

import View.GridPanel;

public class GridController {
	private GridPanel gridPanel;
	private int x;
	private int y;
	private int kind;
	private int x1; //x locatie eerste hoekpunt
	private int y1; //y locatie eerste hoekpunt
	private int x2; //x locatie tweede hoekpunt
	private int y2; //y locatie tweede hoekpunt

	public GridController() {
		gridPanel = new GridPanel();
		x = gridPanel.getX();
		y = gridPanel.getY();

	}
	/*
	 * public void checkCoordinates() {
	 * 
	 * forloop door lijst coördinaten get value met index i
	 * 
	 * ALLE ZIJDE
	 * for(int i=0; i<arraysize; i++){
	 * x1 = x locatie eerste hoekpunt
	 * y1 = y locatie eerste hoekpunt
	   x2 = x locatie tweede hoekpunt
	   y2 = y locatie tweede hoekpunt
	   private int counter;
	   private int location;
	 * 
	 * if statement checken of x,y er tussen valt
	 * if(x1 == x2){ 
		 * if(x>(x1-5) && x<(x2+5) && y>(y1-5) && y<y2+5){
		 * 	location = i;
		 * 	counter++;
		 * }
		VOOR Schijne Zijde
//		Xa en Xb zijn de x'en van de hoekpunten
//		Ya en Yb zijn de y'en van de hoekpunten
//		W is de breedte
//		
//		Dx= Xb - Xa
//		Dy= Yb - Ya
//		D= sqrt(Dx * Dx + Dy * Dy)
//		Dx= (0.5 * W * Dx) / D
//		Dy= (0.5 * W * Dy) / D
//
//		dit zijn de hoekpunten
//		a = Xa - Dy, Ya + Dx
//		b = Xa + Dy, Ya - Dx
//		c = Xb - Dy, Yb + Dx
//		d = Xb + Dy, Yb - Dx
//		p = geklikt punt
//		
//		if opp abcd = (opp abp + opp bcp + opp cdp + opp dap) || een van de opp is nul
//		dan ligt hij binnen het gebied 
	 * }
	 * 
	 * 
	 * if(counter = 1){
	 * 		dan heb je de straat
	 * 	}
	 * 
	 * DIT IS VOOR DORP
	 * 
	 * for(int i=0; i<arraysize; i++){
	 * 		private int r = 10;
	 * 		private int counter;
	 *		private int location;
	 * 
	 * if statement checken of x,y er tussen valt
	 * if((x-x1)*(x-x1) + (y-y1)*(y-y1)<r*r || (x-x1)*(x-x1) + (y-y1)*(y-y1) == r*r){
	 * 		location = i;
	 * 		counter++;
	 * 		}
	 * }
	 * 
	 * if(counter = 1){ 
	 * 		dan heb je het hoekpunt dorp
	 * 		}
	 * }
	 */

	public void showStreets() {
//	pak alle mogelijke straten
//	controleer soort straat
//	teken een blok er om heen
//	g.setColor(kleur van speler)
//	maak transparant
//	g.fill		
	}

	public void showTowns() {
//	pak alle hoekpunten gerelateerd aan jouw straten
//	verwijder degene die al een dorp hebben of aan een grensen
//	g.drawOval(x,y,w,h);
//	g.setColor(kleur van speler)
//	maak transparant
//	g.fill
	}

	public void showCities() {
//		if(er is een dorp van jouw)
//		g.drawOval(x,y,w,h);
//		g.setColor(kleur van speler)
//		maak transparant
//		g.fill
	}

}
