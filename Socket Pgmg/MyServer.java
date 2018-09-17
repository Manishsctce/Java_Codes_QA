package com;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

class MainServer implements Runnable{
	private Socket socket;
	public MainServer(Socket client){
		this.socket = client;		
	}
	
	public void run(){
		Object line ;
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		try{
			 in = new ObjectInputStream(socket.getInputStream());
	            
			out = new ObjectOutputStream(socket.getOutputStream());
		
		}catch (IOException e) {
			System.out.println("IN out failed");
			e.getMessage();
		}
		
		while(true){
			try {				
				line =  in.readObject();
				
				System.out.println("Server Receive a new request....sending ackl");

				String receiveTime = new Date().toString();
				out.writeObject("Request received at "+ receiveTime);				
				//Thread.sleep(2000);				
				
				
				out.writeObject(line +" - "+ receiveTime);
				out.writeObject(null);
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				//System.out.println("error in rec and send data ...."+e.getMessage());
				e.printStackTrace();
			}/*catch (InterruptedException e) {
				System.out.println("interrupted...");
			}*/		
		}		
	}
}

public class MyServer {
	private static ServerSocket server;
    private static int port = 9876;
    
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			
			while(true){
				System.out.println("Server started listening at port 9876...");
				Socket socket = serverSocket.accept();
				System.out.println("Connection established...");
				MainServer mserver = new MainServer(socket);
				Thread t = new Thread(mserver);
				t.start();
			}
		} catch (IOException e) {
			System.out.println("Server Socket connection failed.."+e.getMessage());
		}

	}

}
