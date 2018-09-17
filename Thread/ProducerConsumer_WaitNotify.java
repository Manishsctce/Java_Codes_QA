package threadDemo;
import java.util.*;

/*//This is also working
  class Produce extends WaitNotifyProducerConsumerDemo1 implements Runnable{
	  static final int MAXQUEUE = 5;
	    private Vector messages = new Vector();
	 
	    @Override
	    public void run() {
	        try {
	            while (true) {
	                putMessage();
	                //sleep(5000);
	            }
	        } catch (InterruptedException e) {
	        }
	    }
	 
	    private synchronized void putMessage() throws InterruptedException {
	        while (messages.size() == MAXQUEUE) {
	            wait();
	        }
	        messages.addElement(new java.util.Date().toString());
	        System.out.println("put message");
	        notify();
	        //Later, when the necessary event happens, the thread that is running it calls notify() from a block synchronized on the same object.
	    }
	 
	    // Called by Consumer
	    public synchronized String getMessage() throws InterruptedException {	        
	        while (messages.size() == 0) {
	            wait();//By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
	        }
	        String message = (String) messages.firstElement();
	        messages.removeElement(message);
	        notify();
	        return message;
	    }
}
class Consume extends WaitNotifyProducerConsumerDemo1 implements Runnable{
	   Produce producer;
	   
	    Consume(Produce p) {
	        producer = p;
	    }
	 
	    @Override
	    public void run() {
	        try {
	            while (true) {
	                String message = producer.getMessage();
	                System.out.println("Got message: " + message);
	                //sleep(200);
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}*/
class Produce extends ProducerConsumer_WaitNotify implements Runnable{
	//int count = 10;
	boolean flag = false;
	public void run() {
		try {
			while(count > 0){
				produce();
				count--;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public synchronized void produce() throws InterruptedException{
		if(flag)
			wait();
		
		System.out.println("put" + count);
		 flag = true;
		notify();
			
	}
	public synchronized void consume() throws InterruptedException{				
		if(!flag)
			wait();
		System.out.println("get"+ (count+1));
		flag = false;
		notify();
	}	
}
class Consume extends ProducerConsumer_WaitNotify implements Runnable{
	Produce p;
	
	Consume(Produce p){
		this.p=p;
	}
	public void run() {
		try {
			while(count>0)
				p.consume();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class ProducerConsumer_WaitNotify {
//	boolean flag= false;
	int count = 10;
	public static void main(String[] args) throws InterruptedException  {	
		
		Produce p = new Produce();
		Consume c = new Consume(p);
		
		Thread t1 = new Thread(p);
		t1.start();
		
		Thread t2 = new Thread(c);
		t2.start();
		
	}

}
