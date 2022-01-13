public class Main {
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor(3);
        Producer producer = new Producer(monitor, 4);
        Commercial commercial = new Commercial(monitor,4);

        producer.start();
        commercial.start();
    }
}
