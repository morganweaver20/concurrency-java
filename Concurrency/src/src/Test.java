package src;

public class Test {
	
	public static long total;
	
	public static synchronized void addThreadsTogether(long threadSum){
		total += threadSum;
	}
	

	public static void main(String[] args) {
		
		//creating and populating sum array
		int sum []; 
		sum = new int[200000000];
		System.out.println("Creating sum array of 200,000,000");
		
		for(int i = 0; i < 200000000; i++) {
			int element = (int) (1 + (Math.random() * 10));
			sum[i] = element;
		}
		
		
		Thread first = new Thread(new Runnable() {
			public void run() {
				long threadSum = 0;
				for(int i = 0; i < 50000000; i++) {
					threadSum += sum[i];
				}
				addThreadsTogether(threadSum);
			}
		});
		
		Thread second = new Thread(new Runnable() {
			public void run() {
				long threadSum = 0;
				for(int i = 50000000; i < 100000000; i++) {
					threadSum += sum[i];
				}
				addThreadsTogether(threadSum);
			}
		});
		
		Thread third = new Thread(new Runnable() {
			public void run() {
				long threadSum = 0;
				for(int i = 100000000; i < 150000000; i++) {
					threadSum += sum[i];
				}
				addThreadsTogether(threadSum);
			}
		});
		
		Thread fourth = new Thread(new Runnable() {
			public void run() {
				long threadSum = 0;
				for(int i = 150000000; i < 200000000; i++) {
					threadSum += sum[i];
				}
				addThreadsTogether(threadSum);
			}
		});
		
		//starting threads
		long multiThreadStart = System.currentTimeMillis();
		
		try {
			first.start();
			first.join();
			System.out.println("thread 1 total: " + total);
			second.start();
			second.join();
			System.out.println("thread 2 total: " + total);
			third.start();
			third.join();
			System.out.println("thread 3 total: " + total);
			fourth.start();
			fourth.join();
			System.out.println("thread 4 total: " + total);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		long multiThreadEnd = System.currentTimeMillis();
		
		System.out.println("Multithreads sum: " + total + " and runtime: " + (multiThreadEnd - multiThreadStart));
		
		//creating single thread instance
		SingleThread T5 = new SingleThread("fifth", sum);
		T5.start();

	}

}