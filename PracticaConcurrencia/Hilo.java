
public class Hilo extends Thread {
    private int n;
    int xCompartida;
    public Hilo(int n){
        this.n = n;
    }
    @Override
    public void run() {
        for(int i = 0; i < n; i++){
            System.out.print(i+" ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo(5);
        Hilo hilo2 = new Hilo(5);
        Hilo hilo3 = new Hilo(5);
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
