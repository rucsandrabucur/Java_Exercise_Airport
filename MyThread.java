public class MyThread extends Thread {

    private boolean shouldExit = false;

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }

    Aeroport aeroport = Aeroport.getInstance();

    @Override
    public void run(){
        while (!shouldExit){
            aeroport.nrCurseCurente();
        }
        try {
            Thread.sleep(120000); // 120 secunde
        }catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}
