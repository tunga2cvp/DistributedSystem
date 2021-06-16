public class ThreadedWorkerWithSync extends  Thread {
    private volatile ResourcesExploiter rExp;

    public ThreadedWorkerWithSync(ResourcesExploiter resourcesExploiter) {
        rExp = resourcesExploiter;
    }

    @Override
    public void run() {
        synchronized (rExp) {
            super.run();
            for (int i = 0; i < 1000; i++) {
                rExp.exploit();
            }
//            System.out.println(rExp.getRsc());
        }
    }
}