public class NoSync {
    public static void main(String[] args) throws InterruptedException {
        ResourcesExploiter resources = new ResourcesExploiter(0);
        ThreadedWorkerWithoutSync worker1 = new ThreadedWorkerWithoutSync(resources);
        ThreadedWorkerWithoutSync worker2 = new ThreadedWorkerWithoutSync(resources);
        ThreadedWorkerWithoutSync worker3 = new ThreadedWorkerWithoutSync(resources);
        worker1.start();
//        worker1.join();
        worker2.start();
//        worker2.join();
        worker3.start();
        worker3.join();
        System.out.println(resources.getRsc());
    }
}
