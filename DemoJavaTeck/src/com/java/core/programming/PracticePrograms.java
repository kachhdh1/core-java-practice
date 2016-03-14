package com.java.core.programming;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class PracticePrograms {

	
	
	
	public static void main(String args[]) throws InterruptedException{
		
		final Worker worker = new Worker();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					worker.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					worker.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
	
}

class Worker{
	Random random = new Random();
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	private int count=0;
	public void consumer() throws InterruptedException{
		while(true){
			queue.put(random.nextInt(100));
		}
	}
	
	public void producer() throws InterruptedException{
		while(true){
			Thread.sleep(5000);
			
				Integer value = queue.take();
				System.out.println("Vlaue taken"+ value);
			
		}
	}
	
}



