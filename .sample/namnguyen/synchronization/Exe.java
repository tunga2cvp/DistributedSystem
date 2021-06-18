package synchronization;

public class Exe {
	public static void main(String args[]) {
		ResourcesExploiterWithLock resource = new ResourcesExploiterWithLock(0);
		
		ThreadedWorkerWithLock worker1 = new ThreadedWorkerWithLock(resource);
		ThreadedWorkerWithLock worker2 = new ThreadedWorkerWithLock(resource);
		ThreadedWorkerWithLock worker3 = new ThreadedWorkerWithLock(resource);
		
		worker1.start();
		worker2.start();
		worker3.start();
		try {
			worker1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			worker2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			worker3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resource.getRsc());
	}
}
