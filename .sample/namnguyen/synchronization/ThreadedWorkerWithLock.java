package synchronization;

public class ThreadedWorkerWithLock extends Thread {
	ResourcesExploiterWithLock rExp;
	
	public ThreadedWorkerWithLock(ResourcesExploiterWithLock resource) {
		rExp = resource;
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			rExp.exploit();
		}
	}
}	
