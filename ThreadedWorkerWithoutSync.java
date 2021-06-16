public class ThreadedWorkerWithoutSync extends  Thread{
    private ResourcesExploiter rExp;
    public ThreadedWorkerWithoutSync(ResourcesExploiter resourcesExploiter){
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
