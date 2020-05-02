package concurrent;

public class ConsoleProgress implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(2000);
        progress.interrupt();
    }
    @Override
    public void run() {
        try{
        while (!Thread.currentThread().isInterrupted()) {
            {
                System.out.print("\r load: " + "\\ |");
                    Thread.sleep(500);
                System.out.print("\r load: " + "  | /");
                    Thread.sleep(500);
            }
        }}
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
