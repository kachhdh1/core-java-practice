package com.java.core.programming;

public class ProducerConsumerDemo {

	
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
