public class Sync {
    public static void main(String[] args) throws InterruptedException {
        ResourcesExploiter resources = new ResourcesExploiter(0);
        ThreadedWorkerWithSync worker1 = new ThreadedWorkerWithSync(resources);
        ThreadedWorkerWithSync worker2 = new ThreadedWorkerWithSync(resources);
        ThreadedWorkerWithSync worker3 = new ThreadedWorkerWithSync(resources);
        worker1.start();
        worker2.start();
        worker3.start();
        worker3.join();
        System.out.println(resources.getRsc());
    }
}
