package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.google.gson.Gson;

public class UDPConnectionPeerA extends Thread{
	
	private DatagramSocket socket;
	private PeerA peerA;
	private int numerodepedido=1;
	
	
	@Override
	public void run() {
		
		try {
			//Escuchar
			socket= new DatagramSocket(5000);
			
			//Escuchar mensajes(Datagrama)
			while(true) {
				
				//2 parametros
				byte[] buffer = new byte[200];
				
				DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
				
				System.out.println("Esperando datagrama");
				
				socket.receive(packet);
				
				String mensaje = new String(packet.getData()).trim();
				
				//System.out.println("Datagrama recibido:"+ mensaje);
				Gson gson=new Gson();
				Pedido pedido=gson.fromJson(mensaje, Pedido.class);
				PedidoVista pedidovista;
				pedidovista= new PedidoVista(pedido.getPedido());
				pedidovista.setPedido(numerodepedido++);
				peerA.onMessage(pedidovista);
			}
				
				
			
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String mensaje) {
		// 4 parametros
		
		new Thread(
			
				()->{
					try {
						
						InetAddress ip = InetAddress.getByName("127.0.0.1");
						DatagramPacket packet = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,ip,5000);
						socket.send(packet);
						System.out.println("mensaje enviado");
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				).start();
		
		
	
		
		
	}
	
	public void setPeerA(PeerA peerA) {
		this.peerA=peerA;
		
	}

}
