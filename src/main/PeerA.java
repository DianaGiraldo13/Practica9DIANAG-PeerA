package main;

import java.util.ArrayList;

import com.google.gson.Gson;

import processing.core.PApplet;

public class PeerA extends PApplet{
	
	
	UDPConnectionPeerA udp;
	PedidoVista vista;
	ArrayList<PedidoVista> pedidos;
	Gson gson;

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
		pedidos= new ArrayList<PedidoVista>();
		gson=new Gson();
							
	
	}
	
	public void draw() {
		background(0);
		for(int i=0;i<pedidos.size();i++) {
			pedidos.get(i).pintar(i*130, 20);
		}
		
		
	}
	
	public void mousePressed() {
		for(int i=0;i<pedidos.size();i++) {
			if(pedidos.get(i).onClick(mouseX, mouseY)) {
				ConfirmaciondePedido confirmacion=new ConfirmaciondePedido(true);
				String mensaje=gson.toJson(confirmacion);
				udp.sendMessage(mensaje);
				pedidos.remove(i);
			}
		}
		
	}


	public void onMessage(PedidoVista pedidovista) {
	
		pedidovista.enviarPApplet(this);
		pedidos.add(pedidovista);
		
	}
	
	
	
}
