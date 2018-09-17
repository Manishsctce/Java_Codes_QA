package com;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client1 {
	static InetAddress host = null;
	static Socket socket = null;
	static ObjectOutputStream out = null;
	static  ObjectInputStream in = null;
    
    public static void main(String[] args) throws  IOException, ClassNotFoundException, InterruptedException{
        boolean  flag = true;
    	Client1 c = new Client1();
    	c.connection();
    	System.out.println("Client Connection established...");
    	
    	c.inOutSocket();
    	System.out.println("Input Output Socket created...");
    	
    	
        for(int i=0; i<5;i++){
            if(i==4)
            	out.writeObject("exit");
            else{ 
            	
            	
            }
            Thread.sleep(100);
        }
        
        while(true){
        	c.sendRequest();
        	while(flag){
        		flag = c.receiveResponse();
        	}
        	flag = true;
        }
    }
    public void connection(){	

        try {
        	host = InetAddress.getLocalHost();
        	
        	//establish socket connection to server
			socket = new Socket(host.getHostName(), 9876);
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void sendRequest(){
    	System.out.println("Enter any number: ");
    	int num = new Scanner(System.in).nextInt();
    	try {
			out.writeObject(""+num);
		} catch (IOException e) {
			System.out.println("error while sending request to server...");
			e.printStackTrace();
		}
    }
    
    public boolean receiveResponse(){
    	boolean flag = true;
    	String message = null;
		try {
			message = (String) in.readObject();
			if(message == null)
				return false;
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("Receive Message: " + message);
        return flag;
    }
    
    public void inOutSocket(){
    	try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("Error in making IN OUT socket");
			e.printStackTrace();
		}
    }
    
    public void doOtherWork(){
    	System.out.println("Client is engage in doing some other activity...");
    	for(int i=0;i<5;i++){
    		System.out.print(i + " ");
    	}
    }
}
