public class ThreadedWorkerWithLock extends Thread{
    private ResourcesExploiterWithLock rExp;
    public ThreadedWorkerWithLock(ResourcesExploiterWithLock resourcesExploiter){
        rExp = resourcesExploiter;
    }
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++){
            rExp.exploit();
        }
    }

}
