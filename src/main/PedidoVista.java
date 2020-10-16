package main;

import processing.core.PApplet;
import processing.core.PImage;

public class PedidoVista {
	PApplet app;
	private int pedido;
	PImage BonYurt;
	PImage JugoHit;
	PImage Perro;
	PImage Sandwich;
	private String imagen;
	
	public PedidoVista(PApplet app,String imagen ) {
		this.app=app;
		this.imagen=imagen;
		BonYurt=app.loadImage("../Data/Bon yurt.jpg");
		JugoHit=app.loadImage("../Data/Jugo hit.jpg");
		Perro=app.loadImage("../Data/Perro.jpg");
		Sandwich=app.loadImage("../Data/Sandwich.jpg");
		
		
	}
	
	
	public int getPedido() {
		return pedido;
	}


	public void setPedido(int pedido) {
		this.pedido = pedido;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public void pintar(int posX,int posY) {
		switch(imagen) {
		case "BonYurt":
			app.image(BonYurt, posX, posY,100,100);
			break;
			
		case "JugoHit":
			app.image(JugoHit, posX, posY,100,100);
			break;
			
		case "Perro":
			app.image(Perro, posX, posY,190,100);
			break;
			
		case "Sandwich":
			app.image(Sandwich, posX, posY,100,100);
			break;
			
		}
		
	}
}
