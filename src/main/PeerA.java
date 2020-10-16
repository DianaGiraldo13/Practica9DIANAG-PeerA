package main;

import processing.core.PApplet;

public class PeerA extends PApplet{
	
	
	UDPConnectionPeerA udp;
	PedidoVista vista;

	public static void main(String[] args) {
		PApplet.main("main.PeerA");
		
	}

	
	public void settings() {
		size(500,500);
	}
	public void setup() {
		
		udp = new UDPConnectionPeerA();
		udp.start();
		udp.setPeerA(this);
				
	
	}
	
	public void draw() {
		background(0);
		
		
	}
	
	public void mousePressed() {
		udp.sendMessage("Hola desde PeerA");
		
	}


	public void onMessage(Pedido pedido) {
		PedidoVista temporal=new PedidoVista(this,pedido.getPedido());
		System.out.println("temporal.getImagen()");
		
	}
	
	
}
