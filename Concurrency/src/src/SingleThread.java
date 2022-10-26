package src;

public class SingleThread implements Runnable{

	private Thread t;
	private String threadName;
	private int[] sumArray;
	long startTime;

	SingleThread(String name, int passedArray[]) {
		this.threadName = name;
		this.sumArray = passedArray;
	}


	public void start () {
		System.out.println("Starting " +  threadName );
		if (t == null) {
			t = new Thread (this, threadName);
			t.start ();
			startTime = System.currentTimeMillis();
		}
	}
	
	public void run() {
		
		long total = 0;
		for(int i = 0; i < sumArray.length; i++) {
			total += sumArray[i];
		}
		long endTime = System.currentTimeMillis();
		long threadRuntime = (endTime - startTime);
		System.out.println(threadName + " terminated, sum: " + total + ", runtime: " + threadRuntime);
	}

}
