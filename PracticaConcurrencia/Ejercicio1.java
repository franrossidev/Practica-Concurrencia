import java.util.Scanner;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Ingrese K:");
            int k = scanner.nextInt();
            System.out.println("Ingrese N:");
            int n = scanner.nextInt();

            // Hilo implementando la clase Threads
            Hilo hilo1 = new Hilo(k, n);
            hilo1.start();

            // Hilo implementado la interfaz Runnable
            HiloR runnable = new HiloR(k, n);
            Thread hilo2 = new Thread(runnable);
            hilo2.start();

            // 3er Hilo, en este caso usando la clase Threads
            Hilo hilo3 = new Hilo(k, n);
            hilo3.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Hilo extends Thread {
    private int k, n;

    public Hilo(int k, int n){
        this.k = k;
        this.n = n;
    }
    @Override
    public void run() {
        System.out.println("Suma de los numeros K a N:");
        int suma = k;
        for(int i = k ;i <= n; i++){
            System.out.print(suma + " ");
            suma += i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HiloR implements Runnable {
    private int k, n;

    public HiloR(int k, int n){
        this.k = k;
        this.n = n;
    }
    @Override
    public void run() {
        int suma = k;
        for(int i = k ;i <= n; i++){
            System.out.print(suma + "... ");
            suma += i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}