package main;



import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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
	private int posX;
	private int posY;
	private Date date;
	String horapedido;
	
	
	public PedidoVista(String imagen ) {
		this.imagen=imagen;
		date= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		LocalDateTime now = LocalDateTime.now();
		horapedido=sdf.format(date);
		
		
		
		
	}
	
	public void enviarPApplet(PApplet app) {
		this.app=app;
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
		this.posX=posX;
		this.posY=posY;
		switch(this.imagen) {
		case "BonYurt":
			app.image(BonYurt, posX, posY,100,100);
			
			break;
			
		case "JugoHit":
			app.image(JugoHit, posX, posY,90,100);
			
			break;
			
		case "Perro":
			app.image(Perro, posX, posY,110,100);
			
			break;
			
		case "Sandwich":
			app.image(Sandwich, posX, posY,100,100);
			
			break;
			
		}
		app.text(horapedido, posX+50, posY+120);
		app.text("numero de orden"+" "+pedido, posX+10, posY+160);
		
	}
	
	public boolean onClick(int mouseX,int mouseY) {
		if(mouseX>posX&&mouseX<posX+100&&mouseY>posY&&mouseY<posY+100) {
			return true;
		}
		return false;
	}
}
