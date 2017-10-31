package com.dharmik.threads;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerDemo_Simple_Wait_Notify {

	
	public static void main(String[] args) throws InterruptedException {
		final WorkerProducerConsumer worker = new WorkerProducerConsumer();
		
		Thread t = new Thread(new Runnable() {
			
			public void run() {
				try {
					worker.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				try {
					worker.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
	}

}

class WorkerProducerConsumer {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int Limit = 10;
	private Object lock = new Object();
	Random random = new Random();
	
	public void produce() throws InterruptedException{
		int value = 0;
		while(true){
			
			synchronized (lock) {
				while(list.size() == Limit){
					lock.wait();
					
				}
				list.add(value++);
				lock.notify();
				
			}
			
			Thread.sleep(random.nextInt(2000));
		}
	}
	
	public void consume() throws InterruptedException{
		while(true){
			synchronized (lock) {
				while(list.size()==0){
					lock.wait();
					
				}
				Integer value = list.removeFirst();
				lock.notify();
				System.out.println(" value - "+value);
				
			}
			
			Thread.sleep(random.nextInt(2000));
		}
	}
	
}

