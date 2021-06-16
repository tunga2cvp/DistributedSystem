public class Lock {
    public static void main(String[] args) throws InterruptedException {
        ResourcesExploiterWithLock resources = new ResourcesExploiterWithLock(0);
        ThreadedWorkerWithLock worker1 = new ThreadedWorkerWithLock(resources);
        ThreadedWorkerWithLock worker2 = new ThreadedWorkerWithLock(resources);
        ThreadedWorkerWithLock worker3 = new ThreadedWorkerWithLock(resources);
        worker1.start();
        worker2.start();
        worker3.start();
        worker3.join();
        System.out.println(resources.getRsc());
    }
}
