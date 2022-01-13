/**
 * Monitor
 */
public class Monitor extends Thread{
    private String[] cars;
    private int firstFreeSpace = 0;
    private boolean full = false;
    private boolean empty = true;

    public Monitor(int capacity) {
        this.cars = new String[capacity];
    }

    public synchronized void add(String car) throws InterruptedException {
        while (full) {
            wait();
        }

        cars[firstFreeSpace] = car;
        firstFreeSpace++;

        if (firstFreeSpace >= cars.length) {
            full = true;
        }
        empty = false;

        notifyAll();
    }

    public synchronized String sell() throws InterruptedException {
        while (empty) {
            wait();
        }

        String car = cars[0];
        firstFreeSpace--;

        if (firstFreeSpace <= 0) {
            empty = true;
        } 
        full = false;

        notifyAll();
        return car;
    }
}