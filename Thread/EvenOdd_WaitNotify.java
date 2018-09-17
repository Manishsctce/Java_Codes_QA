package threadDemo;
//Even and Odd with 2 threads

class Even1 implements Runnable{
	boolean flag = false;
	int count = 0;
	public void run(){
		try {
			while(count<50)
				even();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized public void even() throws InterruptedException{
		if(flag)
			wait();		
		System.out.println("Even: "+count);
		Thread.sleep(1000);
		count++;
		flag= true;
		notify();
	}
	synchronized public void odd() throws InterruptedException{
		if(!flag)
			wait();		
		System.out.println("Odd: "+count);
		Thread.sleep(1000);
		count++;
		flag= false;
		notify(); 
	}
}

class Odd1 implements Runnable{
	Even1 e;
	Odd1(Even1 e){
		this.e=e;		
	}
	public void run(){
		try {
			while(e.count<50)
				e.odd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class EvenOdd_WaitNotify {
	public static void main(String[] args) {
		Even1 e = new Even1();
		Thread t1 = new Thread(e);
		t1.start();
		
		Odd1 o = new Odd1(e);
		Thread t2 = new Thread(o);
		t2.start();
	}
		
}


