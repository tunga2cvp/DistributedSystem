package synchronization;

public class ThreadedWorkerWithoutSync extends Thread {
	ResourcesExploiter rExp;
	
	public ThreadedWorkerWithoutSync(ResourcesExploiter resource) {
		rExp = resource;
	}
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			rExp.exploit();
		}
	}
	
}
