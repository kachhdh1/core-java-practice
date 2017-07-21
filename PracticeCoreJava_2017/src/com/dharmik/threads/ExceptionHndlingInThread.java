package com.dharmik.threads;

public class ExceptionHndlingInThread {

	public static void main(String[] args) throws InterruptedException {
		TestThread t = new TestThread();
		try {
			/**
			 * if we do not specify the exptionhandler for 
			 * the thread, the exception will go unnotice in 
			 * main thread as main thread is not aware of the
			 * exception thrown by the some other thread
			 */
			t.setUncaughtExceptionHandler(uh);
			t.start();
			t.join();
		} catch (RuntimeException e) {
			System.out.println("Cathing thread exception in main");
		}
		System.out.println("Main thread finishes");
	}
	
	//defining exception handler
	static Thread.UncaughtExceptionHandler uh= new Thread.UncaughtExceptionHandler() {
		@Override
		public void uncaughtException(Thread th, Throwable ex) {
			System.out.println("Uncaught exception: " + ex);
		}
	}; 

}



class TestThread extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("Throwing runtime exception");
			throw new RuntimeException("RE");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
